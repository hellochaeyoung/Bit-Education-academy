package ajaxEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ajaxEx/hello")
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        System.out.println(id + " " + pwd);

        String str = "World";

        /*
        JSONObject obj = new JSONObject();
        obj.put("str", str);

        resp.setContentType("application/x-json; charset=utf-8");
        resp.getWriter().println(obj);
        */

        Map<String, Object> map = new HashMap<>();
        map.put("title", "제목입니다.");
        map.put("contents", "내용입니다.");

        //JSONObject object = new JSONObject();
        //object.put("map", map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
