<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/16
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="${pageContext.request.getContextPath()}/login.action" method="post">
        <center>
            姓名：<input type="text" name="username"><br/>
            密码：<input type="password" name="password"><br/>
            验证码：<input type="text" name="certificationCodeFromBrowser"><br/>
            <img id="imgVerify" width="116px" height="36px" title="单击刷新验证码"/>
            <input type="submit" value="登录">
        </center>

    </form>
</body>
<script type="text/javascript">
    window.onload=function () {
        var imgVerify = document.getElementById("imgVerify");
        document.getElementById("imgVerify").setAttribute("src","http://localhost:8085/demo_war_exploded/getCertifationCode?" + Math.random() * 5)
        imgVerify.onclick = function () {
            fun1()
        }
        fun1 = function () {
            document.getElementById("imgVerify").setAttribute("src","http://localhost:8085/demo_war_exploded/getCertifationCode?" + Math.random() * 5)
        }
    }

</script>
</html>
