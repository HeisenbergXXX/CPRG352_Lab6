<%--
  Created by IntelliJ IDEA.
  User: Bennett
  Date: 15-Oct.-22
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ShoppingList JSP</title>
</head>
<body>
    <h1>Shopping List</h1>
    <div>
      <p>Hello, ${username} <a href="login?logout">Logout</a></p>
    </div>
        <h2>List</h2>
    <div>
        <form method="post">
            <label>Add item:</label>
                <input type="text" name="item"/>
                <input type="submit" value="Add"/>
                <input type="hidden" value="add" name="action">
        </form>
    <div>
        <p>${message2}</p>
    </div>
    </div>
    <form method="post">
        <div>
          <c:if test="${username != null}">
            <p>Hey the fucking JSTL finally worked!</p>
          </c:if>
          <c:forEach var="item" items="${list}">
            <p><input type="radio" name="items" value="${item}"> ${item}</p>
          </c:forEach>
        </div>
        <div>
            <c:if test="${list.size()>0}">
                <input type="submit" value="Delete"/>
                <input type="hidden" value="delete" name="action">
                <input type="hidden" value="${item}" name="itemDel">
            </c:if>
        </div>
    </form>

</body>
</html>
