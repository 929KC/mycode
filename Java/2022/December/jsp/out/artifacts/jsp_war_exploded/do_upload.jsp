<%@ page import="com.jspsmart.upload.SmartUpload" %><%--
  Created by IntelliJ IDEA.
  User: 萧寒
  Date: 2022/12/8
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    //新建上传对象

    SmartUpload su=new SmartUpload();

    // 上传初始化

    su.initialize(pageContext);

    // 设定上传限制

    // 限制每个上传文件的最大长度。

    // su.setMaxFileSize(10000);

    // 限制总上传数据的长度。

    // su.setTotalMaxFileSize(20000);

    // 通过扩展名限制设定允许上传的文件,这里仅允许doc,txt文件。

    // su.setAllowedFilesList("doc,txt");

    // 通过扩展名限制设定禁止上传的文件,禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。

    // su.setDeniedFilesList("exe,bat,jsp,htm,html,,");

    // 实现文件上传

    su.upload();

    // 将上传文件全部保存到指定目录,必须保证upload目录在应用程序根文件夹中存在

    int count = su.save("./upload", su.SAVE_VIRTUAL);

    //提示成功上传文件数量

    out.println(count+"个文件上传成功！<br>");

    // 逐一提取上传文件信息，同时可保存文件。

    for (int i=0;i<su.getFiles().getCount();i++)

    {

        com.jspsmart.upload.File file = su.getFiles().getFile(i);

        // 若文件不存在则继续

        if (file.isMissing()) continue;

        // 显示当前文件信息

        //out.println("<br>文件长度" + file.getSize());

        out.println("<br>文件名：" + file.getFileName()+"　长度："+file.getSize());

    }

%>
</body>
</html>
