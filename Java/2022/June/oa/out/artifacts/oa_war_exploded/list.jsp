
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>部门列表页面</title>
</head>

<body>

<script type="text/javascript">
    function del(dno) {
        // 弹出确认框，用户点击确定，返回true，点击取消返回false
        var ok = window.confirm("亲，删了不可恢复哦！");
        if (ok) {
            // 发送请求进行删除数据的操作。
            // 在JS代码当中如何发送请求给服务器？
            //alert("正在删除数据，请稍后...")

            //document.location.href = "请求路径"
            //document.location = "请求路径"
            //window.location.href = "请求路径"
            //window.location = "请求路径"
            document.location.href = "<%=request.getContextPath()%>/dept/delete?deptno=" + dno;
        }
    }
</script>

<h1 align="center">部门列表</h1>
<hr>
<table border="1px" align="center" width="50%">
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>1</td>
        <td>10</td>
        <td>销售部</td>
        <td>
            <a href="javascript:void(0)" onclick="del(10)">删除</a>
            <a href="<%=request.getContextPath()%>/edit.jsp">修改</a>
            <a href="<%=request.getContextPath()%>/detail.jsp">详情</a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>20</td>
        <td>研发部</td>
        <td>
            <a href="javascript:void(0)" onclick="del(20)">删除</a>
            <a href="<%=request.getContextPath()%>/edit.jsp">修改</a>
            <a href="<%=request.getContextPath()%>/detail.jsp">详情</a>
        </td>
    </tr>
</table>

<hr>
<a href="<%=request.getContextPath()%>/add.html">新增部门</a>

</body>

</html>