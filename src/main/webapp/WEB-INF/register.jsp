<%--
  Created by IntelliJ IDEA.
  User: Bennett
  Date: 15-Oct.-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register JSP</title>
</head>
<body>
<h1>Shopping List</h1>

<div>
    <form method="post">
        <label>Username: </label>
        <input type="text" name="username">
        <input type="submit" value="Register Name">
        <input type="hidden" value="register" name="action">
    </form>
</div>
<div>
    <p>${message}</p>
</div>
</body>
</html>
