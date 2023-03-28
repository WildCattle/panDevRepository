<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/20
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <table width="100%" cellspacing="10px" cellpadding="0">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>email</th>
            </tr>
            <c:forEach var="student" items="${requestScope.get('allStudents')}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.email}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
