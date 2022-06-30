package com.example.sample01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");

        String name = request.getParameter("name");
        String food = request.getParameter("food");

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h3>이름:" + name + "음식:" + food + "</h3>");

        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // get 방식은 필요 없지만 post는 request 인코딩 방식을 맞춰줘야한다!
        resp.setContentType("text/html; charset=utf-8");

        String fruit = req.getParameter("fruit");

        String[] hobbyArr = req.getParameterValues("name");

        //String hobby = req.getParameter("name");
        String info = req.getParameter("info");

        //System.out.println(fruit + " " + hobby + " " + info);

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h3>좋아하는 과일:" + fruit + "<br>");

        pw.println("<h3>취미</h3>");
        for (String h : hobbyArr) {
            pw.println("<h4>" + h + "</h4><br>");
        }
        pw.println("<p>자기소개 : " + info + "</p>");

        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }
}