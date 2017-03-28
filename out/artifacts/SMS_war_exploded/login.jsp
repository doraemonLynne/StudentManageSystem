<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form action="login.action">
    <fieldset>
        <legend>Login</legend>
        <ul>
            <li>
                <label for="username">UserName:</label>
                <input type="text" id="username" name="username" class="small"maxlength="10" required="required" placeholder="UserName" autofocus="autofocus">
            </li>
            <li>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"class="small" maxlength="10" placeholder="Password">
            </li>
        </ul>
        <button type="submit" id="loginBtn">Log in</button>
    </fieldset>
</form>
</body>
</html>