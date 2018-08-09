<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset=UTF-8">
    <title>EditPage</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Дата</th>
        <th>День недели</th>
        <th>Класс</th>
        <th>Предмет</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${date}" /></td>
        <td><c:out value="${week}" /></td>
        <td><c:out value="${cl}"/></td>
        <td><c:out value="${subject.name}" /></td>
    </tbody>
</table>
<form method="POST" action="edit?id=<c:out value="${subject.id}" />">
    <%
        String action = request.getAttribute("edit").toString();
        if (action.equalsIgnoreCase("mark")){
    %>
    Оценка: <input class = type="text" name="mark"
                   value="<c:out value="${value}" />" />
    <input type="submit" name = "markSave" value="Сохранить" />
    <%            } else {
    %>
    Домашнее задание: <input class = type="text" name="homework"
                   value="<c:out value="${value}" />" />
    <input type="submit" name = "workSave" value="Сохранить" />
    <%
        }
    %>
</form>
</body>
</html>
