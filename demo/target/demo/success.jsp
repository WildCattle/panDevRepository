<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/16
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎 + ${pageContext.session.getAttribute("username")}</h1>
</body>
</html>
