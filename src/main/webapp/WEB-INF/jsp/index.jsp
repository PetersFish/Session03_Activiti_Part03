<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 18/2/7
  Time: 下午6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>处理页面</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
</head>
<body>
欢迎回来！${sessionUser.username} <button onclick="logout()">登出</button>
<c:if test="${sessionUser.autority == 1}">
    <table>
        <tr>
            <td>申请人ID</td>
            <td>主题</td>
            <td>原因</td>
            <td>天数</td>
            <td>审批</td>
        </tr>
        <c:forEach items="${leaveList}" var="leave">
            <tr>
                <td id="uid">${leave.uid}</td>
                <td id="title">${leave.title}</td>
                <td id="reason">${leave.reason}</td>
                <td id="days">${leave.days}</td>
                <td>
                    <button onclick="approveLeave('${leave.id}')">审批</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        /*查询本人的task，将其放入session中*/
        $(function () {
            if(${leaveList == null}){
                alert("leaveList is null!");
                $.post(
                    "${pageContext.request.contextPath}/engine/taskQuery.do",
                    {"id":${sessionUser.id}},
                    function (feedback) {
                        if(feedback == '1'){
                            alert("获得task列表！");
                            location.reload(false);
                        }
                    },
                    "text"
                );
            }else{
                alert("leaveList is not null!");
            }
        });

        function approveLeave(data) {
            $.post(
                "${pageContext.request.contextPath}/engine/taskComplete.do",
                {"id":data},
                function(feedback){
                    alert(feedback);
                    if(feedback == "1"){
                        //location.reload(false);
                        location.href = "${pageContext.request.contextPath}/user/toindex.do";
                    }
                },
                "text"
            );
        }
    </script>
</c:if>
<c:if test="${sessionUser.autority == 0}">
    <form id="leaveRequest">
        <table>
            <tr>
                <td>主题：</td>
                <td><input type="text" name="title"></td>
                <td>原因：</td>
                <td><input type="text" name="reason"></td>
                <td>天数：</td>
                <td><input type="text" name="days"></td>
            </tr>
            <tr>
                <td>
                    <input type="button" value="提交" onclick="submitLeave()">
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
<script>

    $(function () {
        if(${sessionUser == null}){
            location.href = "${pageContext.request.contextPath}/user/tologin.do"
        }
    });

    function logout() {
        location.href = "${pageContext.request.contextPath}/user/logout.do"
    }

    function submitLeave() {
        $.ajax({
            url:"${pageContext.request.contextPath}/leave/submitleave.do",
            data:$("#leaveRequest").serialize(),
            type:"POST",
            dataType:"text",
            success:function (feedback) {
                if(feedback == '1'){
                    alert("提交成功！");
                    location.reload(false);
                }
            }
        })
    }
</script>
</html>
