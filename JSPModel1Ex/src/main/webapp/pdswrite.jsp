<%@ page import="dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-07
  Time: 오전 10:18
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

<h2>자료올리기</h2>

<div align="center">
    <form action="pdsupload.jsp" method="post" enctype="multipart/form-data"> <%-- 반드시 파일 전송할 때는 post 방식으로 해야함! get 방식은 동작하지 않음--%>
        <table border="1">
            <col width="200"><col width="500">

            <tr>
                <th>아이디</th>
                <td>
                    <%= mem.getId()%>
                    <input type="hidden" name="id" value="<%= mem.getId()%>">
                </td>
            </tr>

            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="title" size="50">
                </td>
            </tr>

            <tr>
                <th>파일업로드</th>
                <td>
                    <input type="file" name="fileload" style="width: 400px">
                </td>
            </tr>

            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="50" name="content"></textarea>
                </td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="자료올리기">
                </td>
            </tr>

        </table>
    </form>

</div>
</body>
</html>
