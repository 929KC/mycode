<%@ page import="org.example.bean.Land" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>无标题文档</title>
</head>

<body>
<table width="495" border="1" style="border-collapse:collapse">
    <tr>
        <td width="72"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"> 说明书序号</font> </div></td>
        <td width="72"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"> 单位名称 </font></div></td>
        <td width="72"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000" > 第一期面积</font></div></td>
        <td width="95"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">本期用地总面积</font></div> </td>
        <td width="46"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">填表人</font></div></td>
        <td width="105"><div align="center"></div></td>
    </tr>
    <%
        List<Land> list = (List<Land>)session.getAttribute("list");
        for (Land l : list) {

    %>
    <tr>
        <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=l.getGuid()%></font></div></td>
        <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=l.getName()%></font> </div></td>
        <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=l.getArea()%></font></div></td>
        <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=l.getSumArea()%></font></div></td>
        <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=l.getInputer()%></font></div></td>
        <td>
            <input type="button" name="bt1" value="删除">
            <a href="LandModifyServlet?guid=<%=l.getGuid()%>"><input type="button" name="bt2" value="修改" ></a>
        </td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>