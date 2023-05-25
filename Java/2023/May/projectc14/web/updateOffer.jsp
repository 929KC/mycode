<%@ page import="org.example.bean.Land" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>添加供地方案

    </title>
</head>

<body>
<script language="javascript">

</script>


<table width="340" border="0">
    <tr><td width="553">
        <form action="LandUpdateServlet" method="post" name="form1" onSubmit="return check()">
        <table width="290" height="70" border="1" align="center" style="border-collapse:collapse">
            <%
                Land land = (Land)session.getAttribute("land");
            %>
            <tr>
                <td width="131" height="9"><div align="right"><font color="#3074A2" style="font-size:9pt;color:#000000">说明书序号</font></div></td>
                <td width="188"><input name="guid" type="text" id="title" size="20"value="<%=land.getGuid()%>" readonly="true"></td>
            </tr>
            <tr>
                <td width="131" height="4"><div align="right"><font color="#3074A2" style="font-size:9pt;color:#000000">单位名称 </font ></div></td>
                <td><input name="name" required type="text" id="title" size="20"value="<%=land.getName()%>"><span style="color:red;">*</span></td>
            </tr>

            <tr>
                <td width="131" height="29"><div align="right"><font color="#3074A2" style="font-size:9pt;color:#000000">第一期面积</font ></div></td>
                <td><input name="area" type="text" id="title" size="20"value="<%=land.getArea()%>"></td>
            </tr>
            <tr>
                <td width="131" height="4"><div align="right"><font color="#3074A2" style="font-size:9pt;color:#000000">本期用地总面积 </font ></div></td>
                <td><input name="sumarea" type="text" id="title" size="20"value="<%=land.getSumArea()%>"></td>
            </tr>
            <tr>
                <td height="4"><div align="right"><font color="#3074A2" style="font-size:9pt;color:#000000">填表人 </font></div></td>
                <td><input name="Inputer" type="text" id="title" size="20"value="<%=land.getInputer()%>"></td>
            </tr>
            <tr>
                <td width="131" height="4"><div align="right"></div></td>
                <td><input type="submit" name="bt1" value="确定"></td>
            </tr>
        </table>
    </form></td>
    </tr>
</table>
</body>
</html>
