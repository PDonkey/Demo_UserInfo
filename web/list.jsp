<%--
  Created by IntelliJ IDEA.
  User: ngw
  Date: 2020/1/13
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>用户信息管理系统</title>

    <%--    1.导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <%--    2.jQuery导入--%>
    <script src="js/jquery-3.4.1.min.js"></script>
    <%--    导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id
            }
        }

        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {

                if (confirm("确定删除选中条目吗？")) {
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        //表单提交
                        document.getElementById("form_user").submit();
                    }
                }
            }


            //全选或反选
            //获取列表的第一个checkbox
            document.getElementById("checkAll").onclick = function () {
                //获取列表下的所有checkbox
                var cbs = document.getElementsByName("uid");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
        }


    </script>

</head>
<body>
<div class="container">
    <h3 style="color: #2aabd2;text-align: center">用户信息列表</h3>
    <div style="float: left;margin: 5px">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" placeholder="">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" placeholder="">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="">
            </div>
            <button type="submit" class="btn btn-default">查询</button>

        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn bg-primary" href="${pageContext.request.contextPath}/adduser.jsp">添加联系人</a>
        <a class="btn bg-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <form id="form_user" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>

            <%--        <tr>--%>
            <%--            <td colspan="8" align="center"></td>--%>
            <%--        </tr>--%>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px">共10条记录，共2页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
