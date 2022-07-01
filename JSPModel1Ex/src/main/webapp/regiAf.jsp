<%@ page import="dao.MemberDao" %>
<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-01
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    MemberDao dao = MemberDao.getInstance();

    MemberDto dto = new MemberDto(id, pwd, name, email, 0);

    boolean iss = dao.addMember(dto);
    if(iss) {
        %>
        <script type="text/javascript">
            alert('success');
            location.href = "login.jsp";
        </script>
        <%
    }else{
        %>
        <script type="text/javascript">
            location.href = "register.jsp";
        </script>
    <%
    }
%>
</body>
</html>
