<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-05
  Time: 오전 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");
%>

<%
    int seq = Integer.parseInt(request.getParameter("seq"));
    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    BbsDao dao = BbsDao.getInstance();

    boolean isSuccess = dao.answer(seq, new BbsDto(id, title, content));
    if(isSuccess) {
        %>
        <script type="text/javascript">
            alert("댓글 입력 성공!");
            location.href = "bbslist.jsp";
        </script>
<%
    }else {
        %>
        <script type="text/javascript">
            alert("댓글 입력 실패");
            location.href = "answer.jsp?seq=" + <%= seq%>;
        </script>
<%
    }
%>
</body>
</html>
