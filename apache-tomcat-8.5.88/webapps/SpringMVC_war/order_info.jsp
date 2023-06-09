<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/5/17
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/orderInfo" method="post">
        <table border="1">
            <tr>
                <td colspan="2">
                    订单id：<input type="text" name="orderId" value="1">
                </td>
            </tr>
            <tr>
                <td>商品Id</td>
                <td>商品名称</td>
            </tr>
            <tr>
                <td>
                    <input name="productInfo['生鲜'].proId" value="1" type="text">
                </td>
                <td>
                    <input name="productInfo['生鲜'].proName" value="三文鱼" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <input name="productInfo['酒水'].proId" value="2" type="text">
                </td>
                <td>
                    <input name="productInfo['酒水'].proName" value="红牛" type="text">
                </td>
            </tr>
        </table>
        <input type="submit" value="提交">
    </form>
</body>
</html>
