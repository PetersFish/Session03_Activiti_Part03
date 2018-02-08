<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 18/2/7
  Time: 下午5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
</head>
<body>
<span id="usernameErr">${errMsg}</span>
<form id="loginForm" action="${pageContext.request.contextPath}/user/checklogin.do" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>

    </table>
</form>
<form id="deploy">
    <table>
        <tr>
            <td>部署模式：</td>
            <td>
                <select name="id" id="deploymode">
                    <option value="0">inlineMode</option>
                    <option value="1">parrallelMode</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="部署" onclick="deployMode()">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function deployMode() {
        alert("mode:"+$("#deploymode").val());
        $.post(
            "${pageContext.request.contextPath}/engine/deployment.do",
            {"id":$("#deploymode").val()},
            function (data) {
                if(data == '1'){
                    alert("部署成功！")
                }
            },
            "text"
        )
    }
</script>
</html>
