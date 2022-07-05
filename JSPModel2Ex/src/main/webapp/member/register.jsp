<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-01
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style type="text/css">
        .center {
            margin: auto;
            width: 60%;
            border: 3px solid #00ff00;
            padding: 10px;
        }
    </style>
</head>
<body>

<h2>회원가입</h2>

<div class="center">
    <form action="<%= request.getContextPath()%>/member" method="post">
        <input type="hidden" name="param" value="regiAf">
        <table border="1">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"><br>
                    <p id="idcheck" style="font-size: 8px"></p>
                    <input type="button" id="idBtn" value="아이디확인">
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td>
                    <input type="text" name="pwd" size="20">
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" size="20">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
