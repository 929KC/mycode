<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/11/27
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="add.html">添加一个学生</a>
<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>身份证号</th>
        <th>电话</th>
        <th>住址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.username}</td>
            <td>${st.gender}</td>
            <td>${st.card}</td>
            <td>${st.phone}</td>
            <td>${st.address }</td>
            <td>删除</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
