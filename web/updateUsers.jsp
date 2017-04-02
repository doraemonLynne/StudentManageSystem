<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更新用户口令</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="commonUI.jsp" />
<div class="g-content">
    <h2 class="content-title">Update Users</h2>
    <table class="resultsTable sortable">
        <tr>
            <th>UserName</th>
            <th>Password</th>
            <th>role</th>
            <th>roleId</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>${user.roleId}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>