<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오전 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // jsp는 이 과정이 매 페이지 마다 있어야함, 스프링에서는 web.xml에 다 설정해줄 수 있음
    Object obj = session.getAttribute("login");
    MemberDto mem = null;

    if(obj == null) {
%>
<script>
    alert('로그인 해 주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto) obj;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="bbswriteAf.jsp" method="post">
<table border="1">
    <tr>
        <th>id</th>
        <td><%=mem.getId()%></td>
    </tr>
    <tr>
        <th>제목</th>
        <td><input type="text" name="title"></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><textarea name="contents"></textarea></td>
    </tr>
</table>
<input type="hidden" name="id" value="<%= mem.getId()%>">
<input type="submit" value="글 추가">
</form>

</body>
</html>
