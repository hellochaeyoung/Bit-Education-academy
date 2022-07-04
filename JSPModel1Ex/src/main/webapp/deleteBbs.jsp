<%@ page import="dto.MemberDto" %>
<%@ page import="dao.BbsDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오후 5:17
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
    BbsDao dao = BbsDao.getInstance();
    int result = dao.deleteBbs(seq);

    if(result == 0) {
%>
    <script type="text/javascript">
        alert("글 삭제를 실패하였습니다.");
    </script>

<%
    }else {
%>
    <script type="text/javascript">
        alert("글 삭제를 성공하였습니다.");
        location.href = "bbslist.jsp";
    </script>

<%
    }
%>

</body>
</html>
