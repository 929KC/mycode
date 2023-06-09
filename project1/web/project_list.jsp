<%@page import="bean.Project"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<LINK 
href="css/content.css" type=text/css rel=stylesheet>
</head>

<body>
<table width="834" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30" background="images/title01.jpg" class="title">&gt;&gt;项目信息录入</td>
    <td width="27" height="30"><img src="images/title02.jpg" width="27" height="30" /></td>
    <td height="30" bgcolor="#029AC5" class="txt">您的位置：招投标流程 &gt; 建设工程报建 &gt; 项目信息录入</td>
  </tr>
</table>
<br />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="33%" height="37">&nbsp;</td>
    <td width="34%" height="37">&nbsp;</td>
    <td width="33%" height="37" align="right" valign="top"><a href="project_add.jsp" target="_self"><img src="images/addpro.jpg" border="0" /></a>&nbsp;</td>
  </tr>
  <tr>
    <td height="30" colspan="3" bgcolor="#029AC5" class="titletxt">&#8226;项目信息</td>
  </tr>
  <tr>
    <td height="30" colspan="3"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="33%" height="30" align="center" bgcolor="#80C6FF"><span class="txt"><span class="titletxt">工程编号</span></span></td>
        <td width="34%" height="30" align="center" bgcolor="#80C6FF" class="titletxt">工程名称</td>
        <td width="33%" height="30" align="center" bgcolor="#80C6FF" class="titletxt">相关操作</td>
      </tr>
      <%
      	List<Project> list = (List<Project>)session.getAttribute("list");
      	for(Project p : list){
      		
      %>
      <tr>
        <td width="33%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt"><%=p.getProjectId() %></span></td>
        <td width="34%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt"><%=p.getProjectName() %></span></td>
        <td width="33%" height="30" align="center" bgcolor="#FFF5D7"><span class="txt">【修改】【删除】</span></td>
      </tr>
      <%
      	}
      %>
    </table></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
