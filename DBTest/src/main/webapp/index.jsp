<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>mydb Tables</h1>
<br/>

<pre>
    모든 테이블 목록을 출력한다.
</pre>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/mydb";
    String user = "root";
    String password = "znzlcodud123";

    Connection conn = DriverManager.getConnection(url, user, password);

    String sql = "show table status";

    PreparedStatement psmt = conn.prepareStatement(sql);

    ResultSet rs = psmt.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();
    int count = rsmd.getColumnCount();
%>

<table border="1">
    <tr>
        <%
            for (int i=1;i<count+1;i++) {
        %>
        <td><%=rsmd.getColumnName(i) %></td>
        <%
            }
        %>
    </tr>

    <%
        while(rs.next()) {
            %>
        <tr>
            <%
                for(int i=1;i<count+1;i++) {
                    String cols = rs.getString(i);
                %>
            <td><%= cols %></td>
            <%
                }
            %>
        </tr>
        <%
        }
    %>
</table>

<%
    if(rs != null) rs.close();
    if(psmt != null) psmt.close();
    if(conn != null) conn.close();
%>
</body>
</html>