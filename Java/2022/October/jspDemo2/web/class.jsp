<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.kc.web.utils.DBUtils" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .a{
            margin-left: 200px;
        }
    </style>
</head>
<body>
<form action="" method="get">
    班级号： <input type="text" name="cno"/>
    班级名称：<input type="text" name="cname"/><br />
    班主任： <input type="text" name="tname"/>
    专&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp业：<input type="text" name="major"/><br />
    <input type="submit" value="添加" class="a">
</form>

<jsp:useBean id="c" class="com.kc.web.model.BeanClass"/>
<jsp:setProperty name="c" property="*"/>
<table border="" cellspacing="" cellpadding="">
    <tr>
        <th>班级号</th>
        <th>班级名称</th>
        <th>班主任</th>
        <th>专业</th>
    </tr>
    <%
        String sql = "insert into class2 VALUES(?,?,?,?)";
        DBUtils.inserInto(sql,c);

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            sql = "select cno,cname,tname,major from class2";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String cno = rs.getString("cno");
                String cname = rs.getString("cname");
                String tname = rs.getString("tname");
                String major = rs.getString("major");%>
    <tr>
        <td><%=cno%></td>
        <td><%=cname%></td>
        <td><%=tname%></td>
        <td><%=major%></td>
    </tr>
    <%

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
    %>
</table>
</body>
</html>
