<%@ page import="dao.BbsDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");

    int seq = Integer.parseInt(request.getParameter("seq"));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    BbsDao dao = BbsDao.getInstance();
    int result = dao.updateBbs(seq, title, contents);
    if(result == 0) {
%>
    <script type="text/javascript">
        alert("글 수정을 실패하셨습니다.");
    </script>

<%
    }else {
%>
    <script type="text/javascript">
        alert("글 수정을 성공하였습니다.");
        location.href = "bbslist.jsp";
    </script>

<%
    }
%>


</body>
</html>
