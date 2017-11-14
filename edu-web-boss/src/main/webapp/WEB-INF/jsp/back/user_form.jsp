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
    <div class="layui-form-item">
        <label class="layui-form-label">姓名：</label>
        <div class="layui-input-inline">
            <input type="text" name="nickName" placeholder="请输入姓名" value="${user.nickName}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名：</label>
        <div class="layui-input-inline">
            <input type="text" name="userName" placeholder="请输入用户" value="${user.username}" class="layui-input">
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
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;
    });
</script>
</body>
</html>
