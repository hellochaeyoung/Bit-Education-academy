<%@ page import="dto.MemberDto" %>
<%@ page import="dto.CalendarDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="dao.CalendarDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-06
  Time: 오전 10:12
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

<%!
    // 문자열 검사 : 빈문자열 -> true
   public boolean nvl(String msg) {
       return msg == null || msg.trim().equals("");
   }

   public String two(String msg) {
       return msg.trim().length() < 2 ? "0" + msg.trim() : msg.trim();
   }

   // 일별 일정 모두 보는 callist.jsp로 이동
   public String calList(int year, int month, int day) {
       String str = "";

       str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>", year, month, day);

       // 날짜 위치 맞추는 포맷
       str += String.format("%2d", day);

       return str;
   }

   // 일정 추가 link
   public String showPen(int year, int month, int day) {
       String str = "";

       String image = "<img src='image/pen2.png' width='18px' height='18px'>";
       str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>", year, month, day, image);

       return str;
   }

   // 게시물 리스트의 제목 길 경우 ... 으로 처리하여 다음줄로 넘어가지 않게 처리
   public String dot3(String msg) {
       String str = "";
       if(msg.length() >= 10) {
           str = msg.substring(0, 10);
           str += "...";
       } else {
           str = msg.trim();
       }

       return str;
   }

   public String makeTable(int year, int month, int day, List<CalendarDto> list) {

       String str = "";

       // 2022 7 6 -> 20220706
       String dates = (year + "") + two(month + "")  + two(day + "");

       str += "<table>";

       for(CalendarDto dto : list) {
           if(dto.getRdate().substring(0, 8).equals(dates)) {
               str += "<tr>";
               str += " <td style='padding:0px; border:1; background-color:white; border-color:blue; radius:3'>";

               str += "     <a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";

               str += "         <font style='font-size:10px'>";
               str +=               dot3(dto.getTitle());
               str += "         </font>";

               str += "     </a>";

               str += " </td>";
               str += "</tr>";
           }
       }

       str += "</table>";

       return str;
   }
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

<h2>일정 관리</h2>

<%
    Calendar cal = Calendar.getInstance();

    cal.set(Calendar.DATE, 1);

    String syear = request.getParameter("year");
    String smonth = request.getParameter("month");

    int year = cal.get(Calendar.YEAR);
    if(!nvl(syear)) { // 파라미터로 넘어온 데이터가 있을 때
        year = Integer.parseInt(syear);
    }

    int month = cal.get(Calendar.MONTH) + 1;
    if(!nvl(smonth)) {
        month = Integer.parseInt(smonth);
    }

    if(month < 1) {
        month = 12;
        year--;
    }else if(month > 12) {
        month = 1;
        year++;
    }

    cal.set(year, month - 1, 1);

    // 요일
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    // << year--
    String pp = String.format("<a href='%s?year=%d&month=%d'><img src='image/left.gif' width='20px' height='20px'></a>"
            ,"calendar.jsp", year-1, month);

    // < month--
    String p = String.format("<a href='%s?year=%d&month=%d'><img src='image/prec.gif' width='20px' height='20px'></a>"
            ,"calendar.jsp", year, month-1);

    // > month++
    String n = String.format("<a href='%s?year=%d&month=%d'><img src='image/next.gif' width='20px' height='20px'></a>"
            ,"calendar.jsp", year, month+1);

    // >> year++
    String nn = String.format("<a href='%s?year=%d&month=%d'><img src='image/last.gif' width='20px' height='20px'></a>"
            ,"calendar.jsp", year+1, month);

    // DB
    CalendarDao dao = CalendarDao.getInstance();

    List<CalendarDto> list = dao.getCalendarList(mem.getId(), year + two(month + ""));
%>

<div align="center">
    <table class="table table-bordered" style=" width: 65%">
        <col width="100"><col width="100"><col width="100"><col width="100">
        <col width="100"><col width="100"><col width="100">

        <tr>
            <td colspan="7" align="center">
                <%= pp %>&nbsp;&nbsp;<%= p%>&nbsp;&nbsp;
                &nbsp;&nbsp;
                <font color="black" style="font-size: 50px; font-family: fantasy">
                    <%= String.format("%d년&nbsp;&nbsp;%d월", year, month)%>
                </font>
                &nbsp;&nbsp;
                <%= n%>&nbsp;&nbsp;<%= nn%>&nbsp;&nbsp;
            </td>
        </tr>

        <tr height="50" style="background-color: #f0f0f0; color: white;">
            <th class="text-center">일</th>
            <th class="text-center">월</th>
            <th class="text-center">화</th>
            <th class="text-center">수</th>
            <th class="text-center">목</th>
            <th class="text-center">금</th>
            <th class="text-center">토</th>
        </tr>

        <tr height="100" align="left" valign="top">
            <%
                // 1일 요일 맞추기 위한 윗쪽 빈칸
                for (int i=1;i<dayOfWeek;i++) {
                    %>
                    <td style="background-color: #cecece">&nbsp;</td>
                    <%
                }

                // 날짜
                int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                for(int i=1;i<=lastDay;i++) {
                    %>
                    <td>
                        <%= calList(year, month, i)%>&nbsp;&nbsp;<%= showPen(year, month, i) %>
                        <%= makeTable(year, month, i, list)%>
                    </td>
                    <%
                    if((i + dayOfWeek - 1) % 7 == 0 && i != lastDay) {
                        %>
                        </tr><tr height="100" align="left" valign="top">
                        <%
                    }
                }

                cal.set(Calendar.DATE, lastDay);
                int weekDay = cal.get(Calendar.DAY_OF_WEEK);
                for(int i=0;i<7-weekDay;i++) {
                    %>
                    <td style="background-color: #cecece">&nbsp;</td>
                    <%
                }
            %>

        </tr>
    </table>
</div>

</body>
</html>
