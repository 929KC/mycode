<%--
  Created by IntelliJ IDEA.
  User: 萧寒
  Date: 2022/9/19
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: yellow;
        }
    </style>
</head>
<body>
<%
    String [] name =request.getParameterValues("username");

%>
目前共有人浏览<%=name.length%>了该页面,他们的名字是，
<%
for (String val:name)
    out.print(val);
%>
</body>
</html>
