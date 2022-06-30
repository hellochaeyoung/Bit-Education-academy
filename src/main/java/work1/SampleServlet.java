package work1;

import sample02.dto.StudentDto;
import work1.dto.HumanDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/work1/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        HumanDto human = (HumanDto) req.getSession().getAttribute("dto");

        System.out.println(human.getName() + " " + human.getAge());

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<p>이름 :" + human.getName() + "</p>");
        pw.println("<p>연령대 :" + human.getAge() + "</p>");
        pw.println("<p>성별 :" + human.getSex() + "</p>");

        pw.println("<p>취미</p>");
        for (String s : human.getHobby()) {
            pw.println("<p> :" + s + "</p>");
        }


        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
