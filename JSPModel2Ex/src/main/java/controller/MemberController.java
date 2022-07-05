package controller;

import dao.BbsDao;
import dao.MemberDao;
import dto.MemberDto;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberController extends HttpServlet {

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

        if(param.equals("login")) {
            resp.sendRedirect("member/login.jsp");
        }
        else if(param.equals("register")){
            resp.sendRedirect("member/register.jsp");
        }
        else if(param.equals("idcheck")) { // id 체크 구현 아직 안함
            String id = req.getParameter("id");
            System.out.println("id: " + id );
/*

            MemberDao dao = MemberDao.getInstance();
            boolean b = dao.getId(id);

            String str = "NO";
            if(!b) {
                str = "YES";
            }

            JSONObject obj = new JSONObject();
            obj.put("msg", str);

            resp.setContentType("application/x-json; charset=utf-8");
            resp.getWriter().print(obj);
*/

        }
        else if (param.equals("regiAf")) {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String email = req.getParameter("email");

            MemberDao dao = MemberDao.getInstance();
            boolean b = dao.addMember(new MemberDto(id, pwd, name, email, 0));

            String msg = "OK";
            if(!b) {
                msg = "NO";
            }

            resp.sendRedirect("message.jsp?msg=" + msg);
        }
        else if(param.equals("loginAf")) {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");

            MemberDao dao = MemberDao.getInstance();
            MemberDto dto = dao.login(new MemberDto(id, pwd, null, null, 0));

            String msg = "FAIL";
            if(dto != null && !dto.getId().equals("")) {
                msg = "SUCCESS";

                HttpSession session = req.getSession();
                session.setAttribute("login", dto);
                session.setMaxInactiveInterval(60 * 60 * 2);

                resp.sendRedirect("message.jsp?msg=" + msg + "&id=" + id);

            }else {
                resp.sendRedirect("message.jsp?msg=" + msg);
            }

        }
    }
}
