<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<style>body {
		background-color: yellow;
	}</style>
</head>
<body>
<%!
int count=0;
String persons="";
%>
<%	
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	count++;
	if(persons.length()==0){
		persons=persons+username;
	}else{
		persons=persons+","+username;
	}
%>
目前共有<%=count %>人浏览了该页面，他们的名字是：<%=persons %>
</body>
</html>