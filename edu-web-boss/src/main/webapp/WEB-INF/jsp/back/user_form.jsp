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
</head>
<body>
<div class="layui-form" style="padding: 20px">
    <input type="hidden" name="id" value="${user.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">用户昵称：</label>
        <div class="layui-input-inline">
            <input type="text" name="nickname" placeholder="请输入用户昵称" value="${user.nickname}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户账号：</label>
        <div class="layui-input-inline">
            <input type="text" name="username" placeholder="请输入用户账号" value="${user.username}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱：</label>
        <div class="layui-input-inline">
            <input type="text" name="email" placeholder="请输入邮箱" value="${user.email}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号：</label>
        <div class="layui-input-inline">
            <input type="text" name="phoneNum" placeholder="请输入手机号" value="${user.phoneNum}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <button class="layui-btn" lay-submit="" lay-filter="save">保存</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    //监听提交
    form.on('submit(save)', function (data) {
        ajaxUtil.post("${ctx}/user/save", data.field, true, function (data) {
            layerUtil.closeAll();
            layerUtil.success("保存成功");
            parent.vm.loadTableData();
        });
        return false;
    });
</script>
</body>
</html>
