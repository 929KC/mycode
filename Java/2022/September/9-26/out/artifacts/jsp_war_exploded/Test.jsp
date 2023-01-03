<%--
  Created by IntelliJ IDEA.
  User: 萧寒
  Date: 2022/9/26
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP程序设计网上测试系统</h1>
<form action="submit" method="post">
    请输入姓名: <input type="text" name="username"> 请输入班级: <select name="select" id="">
    <option selected="selected" value="1">软件一班</option>
    <option value="2">软件二班</option>
    <option value="3">软件三班</option>
</select>
    <h3>在JSP,可以获得表单提交的信息的内置对象是:()</h3>
    <input type="radio"> response对象
    <input type="radio"> request对象
    <br>
    <input type="radio">session对象
    <input type="radio"> application对象
    <h3>在SQL语言中,为了实现数据的更新,使用的命令是:()</h3>
    <input type="radio"> update语句
    <input type="radio"> insert语句
    <br>
    <input type="radio">select语句
    <input type="radio"> delete语句<br>
    <button type="submit" >提交答案</button>
</form>
</body>
</html>
