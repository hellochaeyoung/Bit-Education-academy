<%@ page import="dto.MemberDto" %>
<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오후 4:25
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
<%

  BbsDto dto = (BbsDto) request.getAttribute("dto");
  int seq = dto.getSeq();

%>


<form action="<%= request.getContextPath()%>/bbs?param=updateBbsAf" method="post">
  <table border="1">
    <tr>
      <th>id</th>
      <td><%=mem.getId()%></td>
    </tr>
    <tr>
      <th>제목</th>
      <td><input type="text" name="title" value="<%= dto.getTitle()%>"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea name="contents"><%= dto.getContent()%></textarea></td>
    </tr>
  </table>
  <input type="hidden" name="seq" value="<%= seq%>">
  <input type="submit" value="글 수정">
</form>


</body>
</html>
