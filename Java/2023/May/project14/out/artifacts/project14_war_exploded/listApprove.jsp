<%@ page import="org.example.bean.t_ministry_approve" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
	function del() {
		alert("确定要删除码？");
	}
</script>
<body>
<table width="573" border="1" style="border-collapse:collapse">
  <tr>
    <td width="54"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">编号</font></div></td>
    <td width="94"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">申报批次编号</font></div></td>
    <td width="90"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">批复文号</font></div></td>
    <td width="96"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">批复时间</font></div></td>
    <td width="95"><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000">录入时间</font></div>      <div align="center"></div>      </td>
    <td width="104">&nbsp;</td>
  </tr>
 
  <%
 List<t_ministry_approve> list=(List<t_ministry_approve>)session.getAttribute("list");
	for(t_ministry_approve p:list){
 %>
 
  <form name="form1" method="post" action="">
  <tr>
    <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=p.getMi_guid() %></font></div></td>
    <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=p.getProj_guid() %></font> </div></td>
    <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=p.getApprove_symbo() %></font></div></td>
    <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=p.getApprove_time() %></font></div></td>
    <td><div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"></font></div>      
    <div align="center"><font color="#3074A2" style="font-size:9pt;color:#000000"><%=p.getSubmit_time() %></font></div></td>
    <td>	
      <a onclick="location='t_ministry_approveServlet?type=delete&Mi_guid=<%=p.getMi_guid() %>';return false"href=#>
       <input type="button" name="bt1" value="删除" onclick="del()">
        </a> 
	  <input type="button" name="bt2" value="修改">
	 
	</td>	
  </tr>
  </form>
<%} %>
</table>
</body>
</html>