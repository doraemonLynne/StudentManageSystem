<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户口令</title>
</head>
<body>
	更新用户口令
	<form action="updateUser.action" method="post">
		用户名<input type="text" name="username">
		<br/>
		新口令<input type="text" name="password">
		<br/>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>