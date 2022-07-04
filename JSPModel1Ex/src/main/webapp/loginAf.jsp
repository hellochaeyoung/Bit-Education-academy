<%@ page import="dao.MemberDao" %>
<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  MemberDao dao = MemberDao.getInstance();

  MemberDto mem = dao.login(new MemberDto(id, pwd, null, null, 0));

  if(mem != null && !mem.getId().equals("")) {

      session.setAttribute("login", mem);
      session.setMaxInactiveInterval(60 * 60 * 2);
      %>
      <script type="text/javascript">
          alert("안녕하세요. <%=mem.getName() %>님");
          location.href = "bbslist.jsp";
      </script>

      <%
  }else {
      %>
      <script type="text/javascript">
      alert("아이디나 패스워드를 찾을 수 없습니다.");
      location.href = "login.jsp";
      </script>
<%
  }
%>
</body>
</html>
