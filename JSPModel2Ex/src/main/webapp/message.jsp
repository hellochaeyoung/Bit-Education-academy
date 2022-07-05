<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-05
  Time: 오후 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String msg = request.getParameter("msg");
  String id = request.getParameter("id");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  if(msg.equals("OK")) {
    %>
    <script type="text/javascript">
        alert("가입 되었습니다.");
        location.href = "./member?param=login";
    </script>
<%
  } else if(msg.equals("NO")) {
    %>
    <script type="text/javascript">
      alert("가입 실패했습니다.");
      location.href = "./member?param=register";
    </script>
<%
  } else if(msg.equals("SUCCESS")) {
    %>
    <script type="text/javascript">
      alert("안녕하세요 <%= id%>님");
      location.href = "./bbs?param=bbslist";
    </script>

<%
  } else if(msg.equals("FAIL")) {
    %>
    <script type="text/javascript">
      alert("로그인을 실패했습니다.");
      location.href = "./member?param=login";
    </script>
<%
  } else if(msg.equals("addBbs OK")) {
%>
    <script type="text/javascript">
      alert("글 추가를 성공하였습니다!");
      location.href = "./bbs?param=bbslist";
    </script>
<%
    } else if(msg.equals("addBbs NO")) {
%>
    <script type="text/javascript">
      alert("글 추가를 실패하였습니다");
      location.href = "./bbs?param=bbswrite";
    </script>
<%
    } else if(msg.equals("updateBbs OK")) {
%>
    <script type="text/javascript">
        alert("글 수정을 성공하였습니다!");
        location.href = "./bbs?param=bbslist";
    </script>
<%
    } else if(msg.equals("updateBbs NO")) {
%>
    <script type="text/javascript">
        alert("글 수정을 실패하였습니다");
    </script>
<%
    } else if(msg.equals("deleteBbs OK")) {
%>
    <script type="text/javascript">
        alert("글 삭제를 성공하였습니다!");
        location.href = "./bbs?param=bbslist";
    </script>
<%
    } else if(msg.equals("deleteBbs NO")) {
%>
    <script type="text/javascript">
        alert("글 삭제를 실패하였습니다");
    </script>
<%
  } else if(msg.equals("comment OK")) {
%>
    <script type="text/javascript">
        alert("댓글 등록을 성공하였습니다!");
        location.href = "./bbs?param=bbslist";
    </script>
<%
    } else if(msg.equals("comment NO")) {
%>
    <script type="text/javascript">
        alert("댓글 등록을 실패하였습니다");
    </script>
<%
  } else {
%>

<%
  }
%>
</body>
</html>
