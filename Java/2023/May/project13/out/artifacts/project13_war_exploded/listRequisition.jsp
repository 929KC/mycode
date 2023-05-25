<%@ page import="org.example.bean.Requisiton" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
 <form name="form1" method="post" action="">
<table width="627">
 <tr>
    <td width="54"><div align="left"><a href="addRequisition.html">新增</a></div></td>    
    <td width="46"><div align="right"><a href="#">删除</a></div></td>
    <td width="511">&nbsp;</td>
 </tr>
  <tr>
    <td colspan="3"><table width="566" border="1" style="border-collapse:collapse">
  <tr>
    <td width="32"><div align="center"> </div></td>
    <td width="70"><div align="center">项目序号</div></td>
    <td width="120"> <div align="center">呈报说明书序号 </div></td>
    <td width="70"> <div align="center">地类名称</div></td>
    <td width="87"> <div align="center">面积</div></td>
    <td width="68"> <div align="center">补偿标准</div></td><td width="73"><div align="center">操作</div></td>
  </tr>
 <%
 List<Requisiton> list=(List<Requisiton>)session.getAttribute("list");
	for(Requisiton p:list){
 %>
  <tr>
    <td><div align="center">
      <input type="checkbox" name="checkbox" value="checkbox">
    </div></td>
    <td><div align="center"><%=p.getTd_guid() %></div></td>
    <td><div align="center"><%=p.getBpl_guid() %></div></td>
    <td><div align="center"><%=p.getDl_name() %></div></td>
    <td><div align="center"><%=p.getArea() %></div></td>
    <td><div align="center"><%=p.getStd() %></div></td>
    <td><div align="center"><a href="addstaff.htm">修改</a></div></td>
  </tr>
  <%
  }
  %>
</table></td>    
  </tr>
</table>
</form>
</body>
</html>
