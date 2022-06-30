package sample02;

import sample02.dto.StudentDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sample02/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        System.out.println(name + " " + age + " " + address);

        /*// 전송용 오브젝트 준비
        StudentDto dto = new StudentDto(name, age, address);

        req.setAttribute("student", dto);

        RequestDispatcher rd = req.getRequestDispatcher("world");
        rd.forward(req, resp);*/

        //resp.sendRedirect("/sample02/world?name=" + name + "&age=" + age + "&address=" + address);

        StudentDto dto = new StudentDto(name,age, address);
        req.getSession().setAttribute("dto", dto);

        resp.sendRedirect("./world");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
