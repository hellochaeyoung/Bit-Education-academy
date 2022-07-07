<%@ page import="dto.MemberDto" %>
<%@ page import="dao.PdsDao" %>
<%@ page import="dto.PdsDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-07
  Time: 오전 9:47
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

<%
    PdsDao dao = PdsDao.getInstance();
    List<PdsDto> list = dao.getPdsList();

%>
<html>
<head>
    <title>pdslist</title>
</head>
<body>

<h2>자료실</h2>

<div align="center">
<table border="1">
    <col width="50"><col width="100"><col width="400"><col width="50">
    <col width="50"><col width="50"><col width="100">

    <tr>
        <th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
        <th>조회수</th><th>다운로드수</th><th>작성일</th>
    </tr>

    <%
        for(int i=0;i<list.size();i++) {
            PdsDto pds = list.get(i);
    %>
            <tr>
                <th><%= i+1%></th>
                <td><%= pds.getId()%></td>
                <td>
                    <a href="pdsdetail.jsp?seq=<%= pds.getSeq()%>">
                        <%= pds.getTitle()%>
                    </a>
                </td>
                <td>
                    <input type="button" name="btndown" value="다운로드" onclick="filedownload('<%= pds.getNewFileName()%>', <%= pds.getSeq()%>)">
                </td>
                <td><%= pds.getReadCount()%></td>
                <td><%= pds.getDownCount()%></td>
                <td><%= pds.getRegDate()%></td>
            </tr>
    <%

        }
    %>
</table>

<br>

<a href="pdswrite.jsp">자료올리기</a>

</div>

<script type="text/javascript">
    function filedownload(newfilename, seq) {
        location.href = "filedown?newfilename=" + newfilename + "&seq=" + seq;
    }
</script>
</body>
</html>
