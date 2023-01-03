
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <jsp:useBean id="s" class="com.kc.web.model.Triangle"/>
    <p>输入三角形的边A: <input type="text" name="a" value="<%=s.getA()%>"></p>
    <p>输入三角形的边B: <input type="text" name="b" value="<%=s.getB()%>"></p>
    <p>输入三角形的边C: <input type="text" name="c" value="<%=s.getC()%>"></p><br>
    <input type="submit" value="提交">
</form>
<jsp:setProperty name= "s" property="*" />
<p>你给出的三边是:</p>
<p>边A是：<%=s.getA()%></p>
<p>边B是：<%=s.getB()%></p>
<p>边C是：<%=s.getC()%></p>
<p>这三边能构成三角形吗?<%=s.issanjiao()%></p>
<p>面积是:<%=s.getArea()%></p>
</body>
</html>
