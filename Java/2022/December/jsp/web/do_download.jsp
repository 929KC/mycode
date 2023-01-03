<%@ page import="com.jspsmart.upload.SmartUpload" %><%--
  Created by IntelliJ IDEA.
  User: 萧寒
  Date: 2022/12/8
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    // 新建一个smartupload对象
    SmartUpload su = new SmartUpload();
    // 初始化
    su.initialize(pageContext);
    // 设定contentdisposition为null以禁止浏览器自动打开文件，
    //保证点击链接后是下载文件。若不设定，则下载的文件扩展名为
    //doc时，浏览器将自动用word打开它。扩展名为pdf时，
    //浏览器将用acrobat打开。
    su.setContentDisposition(null);
    // 下载文件
    su.downloadFile("./upload/shop.doc");

%>
</body>
</html>
