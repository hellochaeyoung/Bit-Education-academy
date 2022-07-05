<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-05
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

<%
  int seq = Integer.parseInt(request.getParameter("seq"));

  BbsDto bbs = BbsDao.getInstance().getBbs(seq);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>기본(부모)글</h2>

<div align="center">
    <table border="1">
        <col width="200"><col width="500">

        <tr>
            <th>작성자</th>
            <td><%= bbs.getId()%></td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><%= bbs.getWdate()%></td>
        </tr>
        <tr>
            <th>조회수</th>
            <td><%= bbs.getReadCount()%></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><%= bbs.getTitle()%></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><%= bbs.getContent()%></td>
        </tr>
    </table>
</div>

<br><br><br>

<div align="center">
    <form action="answerAf.jsp" id="frm" method="post">
        <input type="hidden" name="seq" value="<%= bbs.getSeq()%>">

        <table border="1">
            <col width="200"><col width="500">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" name="id" id="id" size="50px" value="<%= mem.getId()%>" readonly="readonly">
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" id="title" size="50px">
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="50px" name="content"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="button" id="btn">댓글추가</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#btn").click(function () {

            if($("#title").val().trim() == "") {
                alert("제목을 입력해 주십시오.");
                $("#title").focus()
            }

            $("#frm").attr("action", "answerAf.jsp").submit();
        });
    });
</script>
</body>
</html>
