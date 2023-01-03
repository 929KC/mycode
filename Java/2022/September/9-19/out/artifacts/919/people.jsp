<%--
  Created by IntelliJ IDEA.
  User: 萧寒
  Date: 2022/9/19
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
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
    int i=0;
    String [] name = request.getParameterValues("name");
%>
目前共<%= ++i%>有人浏览了该页面,他们的名字是，
<%
 for (int j=0;j<name.length;j++) {
     out.print(name[j]);
 }
%>


</body>
</html>
