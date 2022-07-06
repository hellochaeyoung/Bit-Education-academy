<%@ page import="dto.MemberDto" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-06
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <style type="text/css">
        th{
            background-color: #00a2e8;

        }
    </style>

</head>
<body>

<%
    Calendar cal = Calendar.getInstance();
    int tyear = cal.get(Calendar.YEAR);
    int tmonth = cal.get(Calendar.MONTH) + 1;
    int tday = cal.get(Calendar.DATE);
    int thour = cal.get(Calendar.HOUR_OF_DAY);
    int tmin = cal.get(Calendar.MINUTE);

    cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
%>

<h2>일정 추가</h2>

<div align="center">
    <form action="calwriteAf.jsp" method="post">
        <table class="table table-bordered" style="width: 65%">
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
                    <input type="text" size="60" name="title">
                </td>
            </tr>

            <tr>
                <th>일정</th>

                <%-- 사용자들은 input태그를 더 좋아한다.--%>
                <input type="date">
                <input type="time">

                <td>
                    <select name="year">
                        <%
                            // 5년 전, 5년 후 일정까지
                            for(int i=tyear-5;i<=tyear+5;i++) {
                                %>
                                <option <%= year.equals(i + "")?"selected='selected'":""%> value="<%= i%>" >
                                    <%= i%>
                                </option>
                        <%
                            }
                        %>
                    </select>년

                    <select name="month">
                        <%
                            for(int i=1;i<=12;i++) {
                            %>
                                <option <%= month.equals(i + "")?"selected='selected'":""%> value="<%= i%>" >
                                    <%= i%>
                                </option>
                            <%
                                }
                        %>
                    </select>월

                    <select name="day">
                        <%
                            for(int i=1;i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
                        %>
                        <option <%= day.equals(i + "")?"selected='selected'":""%> value="<%= i%>" >
                            <%= i%>
                        </option>
                        <%
                            }
                        %>
                    </select>일

                    <select name="hour">
                        <%
                            for(int i=1;i<24;i++) {
                        %>
                        <option <%= (thour + "").equals(i + "")?"selected='selected'":""%> value="<%= i%>" >
                            <%= i%>
                        </option>
                        <%
                            }
                        %>
                    </select>시

                    <select name="min">
                        <%
                            for(int i=0;i<60;i++) {
                        %>
                        <option <%= (tmin + "").equals(i + "")?"selected='selected'":""%> value="<%= i%>" >
                            <%= i%>
                        </option>
                        <%
                            }
                        %>
                    </select>분
                </td>
            </tr>

            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="80" name="content"></textarea>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="일정추가">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
