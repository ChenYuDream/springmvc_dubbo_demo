<%--
  Created by IntelliJ IDEA.
  User: ChenYu
  Date: 2017-06-05
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../public/back/commonCss.jsp" %>
    <%@include file="../public/back/commonJs.jsp" %>
    <title>Dubbo_demo</title>
</head>
<body ms-controller="user">
<div style="padding: 10px">
    <button class="layui-btn" ms-on-click="openIframe('')">新增用户</button>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>用户昵称</th>
            <th>用户账号</th>
            <th>邮箱</th>
            <th>手机号</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr ms-repeat="tableData">
            <td>{{el.id}}</td>
            <td>{{el.nickName}}</td>
            <td>{{el.username}}</td>
            <td>{{el.email}}</td>
            <td>{{el.phoneNum}}</td>
            <td>
                <button class="layui-btn layui-btn-mini layui-btn-primary" ms-on-click="openIframe(el.id)">编辑</button>
                <button class="layui-btn layui-btn-mini layui-btn-danger">删除</button>
                <button class="layui-btn layui-btn-mini">发送邮件</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    var vm = {
        tableData: [],
        loadTableData: function () {
            ajaxUtil.post("${ctx}/user/list", "", false, function (data) {
                vm.tableData = data.data
            })
        },
        openIframe: function (id) {
            layerUtil.iFrame("${ctx}/user/form/" + id || "", "编辑/添加用户", ["500px", "400px"]);
        }
    }
    vm = avalonFn.define("user", vm);
    vm.loadTableData();
</script>
</body>
</html>
