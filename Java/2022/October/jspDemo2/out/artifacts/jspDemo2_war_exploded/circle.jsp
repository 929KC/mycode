
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="c" class="com.kc.web.model.Circle" scope="page"></jsp:useBean>
<%
    c.setRadius(10);
%>
<P>圆的半径是：
        <%=c.getRadius()%>
<P>圆的周长是：
        <%=c.circlLength()%>
<P>圆的面积是：
        <%=c.circleArea()%>
</body>
</html>
