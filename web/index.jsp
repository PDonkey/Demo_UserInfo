<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>首页</title>

    <%--    1.导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%--    2.jQuery导入--%>
    <script src="js/jquery-3.4.1.min.js"></script>
    <%--    导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
查询所有用户信息
<div align="center">
    <div>${user.name},欢迎您</div>
    <a
            href="${pageContext.request.contextPath}/userListServlet" style="font-size: x-large" >查询所有用户信息
    </a>
</div>
</body>
</html>
