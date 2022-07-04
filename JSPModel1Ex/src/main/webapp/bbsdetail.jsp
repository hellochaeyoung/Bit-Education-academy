<%@ page import="dto.MemberDto" %>
<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오후 3:29
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
    int seq = Integer.parseInt(request.getParameter("seq"));
    String title = request.getParameter("title");

    BbsDao dao = BbsDao.getInstance();

    BbsDto dto = dao.getBbs(seq);

%>

<div align="center">
    <table border="1">
        <tr>
            <th>id</th>
            <td><%= dto.getId()%></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><%= dto.getTitle()%></td>
        </tr>
        <tr>
            <th>게시시간</th>
            <td><%= dto.getWdate()%></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><%= dto.getContent()%></td>
        </tr>
    </table>

    <br><br>

    <button type="button" onclick="updateBtn()">수정</button>
    <button type="button" onclick="deleteBtn()">삭제</button>
    <button type="button" onclick="backBtn()">글 목록</button>
</div>

<script type="text/javascript">

    function updateBtn() {
        location.href = "updateBbs.jsp?seq=" + <%= seq%>;
    }


    function deleteBtn() {
        location.href = "deleteBbs.jsp?seq=" + <%= seq%>;
    }

    function backBtn() {
        location.href = "bbslist.jsp";
    }

</script>
</body>
</html>
