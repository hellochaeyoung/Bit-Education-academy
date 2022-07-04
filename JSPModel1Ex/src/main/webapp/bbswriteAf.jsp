<%@ page import="dto.BbsDto" %>
<%@ page import="dao.BbsDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    BbsDto dto = new BbsDto(id, title, contents);

    BbsDao dao = BbsDao.getInstance();

    boolean result = dao.addBbs(dto); // 게시물 DB에 저장
    if(!result) {
        %>
        <script type="text/javascript">
            alert("글 추가에 실패하였습니다.");
        </script>
<%
    }
    %>
    <script type="text/javascript">
        location.href = "bbslist.jsp";
    </script>

%>

</body>
</html>
