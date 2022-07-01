<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-01
  Time: 오전 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
  $(document).ready(function () {
      $("button").click(function () {
          $.ajax({
              url:"data.json",
              type:'get',
              dataType:'json',
              success:function (data) {
                  alert("success");
                  alert(JSON.stringify(data));
              },
              error:function () {
                  alert("error");
              }
          })
      })
  })

  $(function () {
      $("button").click(function () {
          $.ajax({
              url:"./hello",
              type:"get",
              data:{"id":"abc", "pwd" : "123"},
              success:function (data) {
                  alert("success")
              },
              error:function () {
                  alert("error");
              }
          })
      })
  })
</script>
</body>
</html>
