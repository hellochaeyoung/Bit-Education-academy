package util;

import dao.PdsDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/filedown")
public class FileDownLoader extends HttpServlet {

    ServletConfig mConfig = null;
    final int BUFFER_SIZE = 8192;

    @Override // 업로드한 경로를 취득하기 위해서
    public void init(ServletConfig config) throws ServletException {
        mConfig = config;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newfilename = req.getParameter("newfilename");
        int seq = Integer.parseInt(req.getParameter("seq"));

        // downcount를 증가


        PdsDao dao = PdsDao.getInstance();
        String filename = dao.getPds(seq).getFileName(); // 원본 파일명

        BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());

        // path
        // tomcat
        //String path = mConfig.getServletContext().getRealPath("/upload");
        String path = req.getSession().getServletContext().getRealPath("/upload");

        // 폴더
        //String path = "d:\\tmp";

        path = path + "\\" + newfilename;

        File f = new File(path);

        // 다운로드 다이얼로그
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
        resp.setHeader("Content-Transfer-Encoding", "binary;");
        resp.setHeader("Content-Length", "" + f.length());
        resp.setHeader("Pragma", "no-cache;");
        resp.setHeader("Expires", "-1;");

        // 파일 생성 및 기입
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        byte buffer[] = new byte[BUFFER_SIZE];
        int read = 0;

        while((read = bis.read(buffer)) != -1) {
            out.write(buffer, 0, read); // 실제 다운로드
        }
        bis.close();
        out.flush();
    }
}
