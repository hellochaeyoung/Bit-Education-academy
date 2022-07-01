<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-01
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
    <style type="text/css">
        .center {
            margin: auto;
            width: 60%;
            border: 3px solid #00ff00;
            padding: 10px;
        }
    </style>
    <title>Title</title>
</head>
<body>

<div class="center">
    <form action="loginAf.jsp" method="post">
        <table border="1">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"><br>
                    <input type="checkbox" id="chk_save_id">save id
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td>
                    <input type="password" name="pwd" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="로그인">
                    <a href="register.jsp">회원가입</a>
                </td>
            </tr>
        </table>

    </form>
</div>

<script type="text/javascript">
    let user_id = $.cookie("user_id");
    if(user_id != null) {
        $("#id").val(user_id);
        $("#chk_save_id").prop("checked", true);

    }

    $("#chk_save_id").click(function () {
        if($("#chk_save_id").is(":checked")) {
            if($("#id").val().trim() == "") {
                alert("아이디를 입력해주세요");
                $("#chk_save_id").prop("checked", false);
            }else {
                $.cookie("user_id", $("#id").val().trim(), {expires:7, path:'./'});
            }
        }else {
            $.removeCookie("user_id", {path: './'});
        }
    })
</script>

</body>
</html>
