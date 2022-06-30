package sample02;

import sample02.dto.StudentDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sample02/world")
public class WorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        // 한글 처리 필요
       // StudentDto st = (StudentDto) req.getAttribute("student");
/*

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

*/
        StudentDto st = (StudentDto) req.getSession().getAttribute("dto");

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");
/*

        pw.println("<p>name:" + name + "</p>");
        pw.println("<p>age:" + age + "</p>");
        pw.println("<p>address:" + address + "</p>");

*/

        pw.println("<p>name:" + st.getName() + "</p>");
        pw.println("<p>age:" + st.getAge() + "</p>");
        pw.println("<p>address:" + st.getAddress() + "</p>");


        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
