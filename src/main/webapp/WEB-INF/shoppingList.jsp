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
      <p>Hello, ${username} <a href="?action=logout">Logout</a></p>
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
<%--          <c:if test="${username != null}">--%>
<%--            <p>Hey the freaking JSTL finally worked!</p>--%>
<%--          </c:if>--%>
          <c:forEach var="item" items="${items}">
            <input type="radio" name="itemsRadio" value="${item}"> ${item} <br>
          </c:forEach>
        </div>
        <div>
            <br>
            <c:if test="${items.size()>0}">
                <input type="submit" value="Delete"/>
                <input type="hidden" value="delete" name="action">
            </c:if>
        </div>
    </form>

</body>
</html>
