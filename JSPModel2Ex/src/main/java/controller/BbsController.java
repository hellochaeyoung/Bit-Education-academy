package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BbsDao;
import dto.BbsDto;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BbsController extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String param = req.getParameter("param");

        if(param.equals("bbslist")) {

            String choice = req.getParameter("choice");
            String search = req.getParameter("search");
            if(choice == null) {
                choice = "";
            }

            if(search == null) {
                search = "";
            }

            BbsDao dao = BbsDao.getInstance();

            // 페이지 번호
            String sPageNumber = req.getParameter("pageNumber");
            int pageNumber = 0; // 파라미터에 페이지 번호 없을 때
            if(sPageNumber != null && sPageNumber.equals("")) { // 파라미터로 페이지 번호 있을 때
                pageNumber = Integer.parseInt(sPageNumber);
            }

            List<BbsDto> list = dao.getBbsPageList(choice, search, pageNumber);

            // 글의 총수
            int len = dao.getAllBbs(choice, search);

            // 페이지의 수
            int bbsPage = len / 10;
            if(len % 10 > 0) bbsPage++;

            JSONObject obj = new JSONObject();
            obj.put("list", list);
            obj.put("bbsPage", bbsPage);
            obj.put("pageNumber", pageNumber);
            obj.put("search", search);
            obj.put("choice", choice);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");

            req.setAttribute("data", obj);
            req.getRequestDispatcher("bbs/bbslist.jsp").forward(req, resp);

        }
        else if(param.equals("bbswrite")) {
            resp.sendRedirect("bbs/bbswrite.jsp");
        }
        else if(param.equals("bbswriteAf")) {

            String id = req.getParameter("id");
            String title = req.getParameter("title");
            String contents = req.getParameter("contents");

            BbsDao dao = BbsDao.getInstance();

            boolean result = dao.addBbs(new BbsDto(id, title, contents));

            String msg = "";
            if(result) {
                msg = "addBbs OK";
            }else {
                msg = "addBbs NO";
            }

            resp.sendRedirect("message.jsp?msg=" + msg);
        }
        else if(param.equals("bbsdetail")) {

            int seq = Integer.parseInt(req.getParameter("seq"));

            BbsDao dao = BbsDao.getInstance();
            BbsDto dto = dao.getBbs(seq);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");

            req.setAttribute("bbs", dto);
            req.getRequestDispatcher("bbs/bbsdetail.jsp").forward(req, resp);

        } else if(param.equals("updateBbs")) {

            int seq = Integer.parseInt(req.getParameter("seq"));

            BbsDao dao = BbsDao.getInstance();
            BbsDto dto = dao.getBbs(seq);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("bbs/updateBbs.jsp").forward(req, resp);


        } else if(param.equals("updateBbsAf")) {

            String title = req.getParameter("title");
            String contents = req.getParameter("contents");

            int seq = Integer.parseInt(req.getParameter("seq"));

            BbsDao dao = BbsDao.getInstance();
            int result = dao.updateBbs(seq, title, contents);

            String msg = "updateBbs OK";
            if(result == 0) {
                msg = "updateBbs NO";
            }

            resp.sendRedirect("message.jsp?msg=" + msg);


        } else if(param.equals("deleteBbs")) {

            int seq = Integer.parseInt(req.getParameter("seq"));
            BbsDao dao = BbsDao.getInstance();
            int result = dao.deleteBbs(seq);

            String msg = "deleteBbs OK";
            if(result == 0) {
                msg = "deleteBbs NO";
            }

            resp.sendRedirect("message.jsp?msg=" + msg);


        } else if(param.equals("answer")) {

            int seq = Integer.parseInt(req.getParameter("seq"));

            BbsDto bbs = BbsDao.getInstance().getBbs(seq);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");

            req.setAttribute("bbs", bbs);
            req.getRequestDispatcher("bbs/answer.jsp").forward(req, resp);

        } else if(param.equals("answerAf")) {

            int seq = Integer.parseInt(req.getParameter("seq"));
            String id = req.getParameter("id");
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            BbsDao dao = BbsDao.getInstance();

            boolean isSuccess = dao.answer(seq, new BbsDto(id, title, content));

            String msg = "comment OK";
            if(!isSuccess) {
                msg = "comment NO";
            }

            resp.sendRedirect("message.jsp?msg=" + msg);

        }
    }


}
