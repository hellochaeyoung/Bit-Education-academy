package sample03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sample03/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        /*
        *   getSession(false)
        *   session이 존재하면, 현재 세션을 반환
        *   존재하지 않으면, null 반환
        *
        *   getSession(true)
        *   session이 존재하면, 현재 세션을 반환
        *   존재하지 않으면, 새로 생성하여 반환
        * */

        HttpSession session = req.getSession(false);

        if(session == null) {
            session = req.getSession(true);

            // 기한 설정
            session.setMaxInactiveInterval(30);
            session.setAttribute("visited", "1");
            pw.println("<p>첫번째 방문입니다.</p>");
        }else {
            String visited = (String)session.getAttribute("visited");
            int count = Integer.parseInt(visited);

            count++;

            pw.println("<p>방문 횟수는 " + count + "입니다.");
            session.setAttribute("visited", count + "");
        }

        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
