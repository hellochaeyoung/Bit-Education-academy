<%@ page import="dto.MemberDto" %>
<%@ page import="dao.BbsDao" %>
<%@ page import="dto.BbsDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-04
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    // 댓글용 함수
    // depth와 image를 추가하는 함수
    // >> 댓글....
    public String arrow(int depth) {
        String img = "<img src='./image/arrow.png' width='20px' height='20px'/>";
        String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";

        String ts = "";
        for(int i=0;i<depth;i++) {
            ts += nbsp; // 깊이에 따라 여백을 조정
        }

        return depth==0 ? "" : ts + img;
    }
%>

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

    String choice = request.getParameter("choice");
    String search = request.getParameter("search");
    if(choice == null) {
        choice = "";
    }

    if(search == null) {
        search = "";
    }


    BbsDao dao = BbsDao.getInstance();

    // 페이지 번호
    String sPageNumber = request.getParameter("pageNumber");
    int pageNumber = 0; // 파라미터에 페이지 번호 없을 때
    if(sPageNumber != null && sPageNumber.equals("")) { // 파라미터로 페이지 번호 있을 때
        pageNumber = Integer.parseInt(sPageNumber);
    }

    //List<BbsDto> list = dao.getBbsList();
    //List<BbsDto> list = dao.getBbsSearchList(choice, search);
    List<BbsDto> list = dao.getBbsPageList(choice, search, pageNumber);

    // 글의 총수
    int len = dao.getAllBbs(choice, search);

    // 페이지의 수
    int bbsPage = len / 10;
    if(len % 10 > 0) bbsPage++;
%>

<h2>게시판</h2>

<div align="center">

<table border="1">
    <col width="70"><col width="600"><col width="100"><col width="150">
    <tr>
        <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
    </tr>

    <%
        if(list == null || list.size() == 0) {
    %>
        <tr>
            <td colspan="4">작성된 글이 없습니다.</td>
        </tr>

    <%
        }else {
            for (int i=0;i< list.size();i++) {
                BbsDto bbs = list.get(i);
            %>
            <tr>
                <th><%= i + 1%></th>
                <td>
                    <%= arrow(bbs.getDepth())%>
                    <a href="bbsdetail.jsp?seq=<%= bbs.getSeq() %>"><%=bbs.getTitle() %></a>
                </td>
                <td><%= bbs.getReadCount() %></td>
                <td><%= bbs.getId() %></td>
            </tr>

    <%
            }
            %>
    <%
    }
    %>
</table>
    <br><br>


    <%
        for (int i=0;i<bbsPage;i++) {
            if(pageNumber == i) { // 현재 페이지
                %>
    <span style="font-size: 15pt;color: #0000ff;font-weight: bold;">
        <%= i + 1%>
    </span>
                <%
            }else {                 // 그 외의 페이지 1 [2] [3]
                %>
                <a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
                   style="font-size: 15pt; color: #000; font-weight: bold;text-decoration: none;">
                   [<%=i + 1 %>]
                </a>
                <%
            }
        }
    %>

<select id="choice">
    <option>검색</option>
    <option value="title">제목</option>
    <option value="content">내용</option>
    <option value="write">작성자</option>
</select>
    <input type="text" id="search" value="<%=search %>">
    <button type="button" onclick="searchBtn()">검색</button>
</div>

<a href="bbswrite.jsp">글쓰기</a>


<script type="text/javascript">
    let search = "<%=search %>";
    if(search != "") {
        let obj = document.getElementById("choice");
        obj.value = "<%= choice%>";
        obj.setAttribute("selected", "selected");
    }
    function searchBtn() {
        let choice = document.getElementById('choice').value;
        let search = document.getElementById('search').value;

        location.href = "bbslist.jsp?choice=" + choice + "&search=" + search;
    }

    function goPage(pageNumber) {
        let choice = document.getElementById('choice').value;
        let search = document.getElementById('search').value;

        location.href = "bbslist.jsp?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNumber;
    }
</script>
</body>
</html>
