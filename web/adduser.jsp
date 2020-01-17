<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>添加用户信息</title>

    <%--    1.导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%--    2.jQuery导入--%>
    <script src="js/jquery-3.4.1.min.js"></script>
    <%--    导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>

<div class="container">
   <h3>添加用户信息</h3>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">

        </div>
        <div class="form-group">
            <label >性别：</label>
            <input type="radio" name="gender" value="男" checked="checked">男
            <input type="radio" name="gender" value="女" >女
        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" name="age" class="form-control" id="age" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="北京">北京</option>
                <option value="上海">上海</option>
                <option value="杭州">杭州</option>
            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" name="qq" class="form-control" id="qq" placeholder="请输入QQ号">
        </div>
        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" name="email" class="form-control" id="email" placeholder="请输入邮箱">
        </div>
        <div class="form-group" style="align-content: center">
            <input type="submit" class="btn btn-primary" value="提交">
            <input type="reset" class="btn btn-primary" value="重置">
            <input type="button" class="btn btn-primary" value="返回">
        </div>
    </form>
</div>
</body>
</html>
