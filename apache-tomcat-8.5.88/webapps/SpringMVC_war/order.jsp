<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/17
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/showOrders" method="post">
        <table width="220px" border="1">
            <tr>
                <td>订单号</td>
                <td>订单名称</td>
                <td>配送地址</td>
            </tr>
            <tr>
                <td>
                    <input name="orders[0].orderId" value="1" type="text">
                </td>
                <td>
                    <input name="orders[0].orderName" value="Java基础教程" type="text">
                </td>
                <td>
                    <input name="address" value="北京海淀" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <input name="orders[1].orderId" value="2" type="text">
                </td>
                <td>
                    <input name="orders[1].orderName" value="JavaWeb案例" type="text">
                </td>
                <td>
                    <input name="address" value="北京昌平" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <input name="orders[2].orderId" value="3" type="text">
                </td>
                <td>
                    <input name="orders[2].orderName" value="SSM框架实战" type="text">
                </td>
                <td>
                    <input name="address" value="北京朝阳" type="text">
                </td>
            </tr>
        </table>
        <input type="submit" value="订单信息">
    </form>
</body>
</html>
