<%@ page import="dto.MemberDto" %>
<%@ page import="dao.PdsDao" %>
<%@ page import="dto.PdsDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-07
  Time: 오후 2:26
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
    int seq = Integer.parseInt(request.getParameter("seq"));

    PdsDao dao = PdsDao.getInstance();
    PdsDto pds = dao.getPds(seq);

%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>자료 상세 내용</h2>
<div align="center">
    <table border="1">

        <tr>
            <th>게시자</th>
            <td><%= mem.getId()%></td>
        </tr>

        <tr>
            <th>제목</th>
            <td><%= pds.getTitle()%></td>
        </tr>

        <tr>
            <th>다운로드</th>
            <td>
                <input type="button" name="btndown" value="파일" onclick="filedownload('<%= pds.getNewFileName()%>', <%= pds.getSeq()%>)">
            </td>
        </tr>

        <tr>
            <th>조회수</th>
            <td><%= pds.getReadCount()%></td>
        </tr>

        <tr>
            <th>다운로드 수</th>
            <td><%= pds.getDownCount()%></td>
        </tr>

        <tr>
            <th>파일명</th>
            <td><%= pds.getFileName()%></td>
        </tr>

        <tr>
            <th>등록일</th>
            <td><%= pds.getRegDate()%></td>
        </tr>

        <tr>
            <th>내용</th>
            <td>
                <textarea>
                    <%= pds.getContent()%>
                </textarea>
            </td>
        </tr>

    </table>
</div>

<script type="text/javascript">
    function filedownload(newfilename, seq) {
        location.href = "filedown?newfilename=" + newfilename + "&seq=" + seq;
    }
</script>

</body>
</html>
