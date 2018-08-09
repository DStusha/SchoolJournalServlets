<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HelloPage</title>
</head>
<%
    String f = request.getAttribute("ifNull").toString();
    if (f == "true") {
%>
<style>
    .inputtext{
        border: 1px solid #ff0000;
    }
</style>
<%
    }
%>
<body>
    <form method="POST" action="regPage">
        <p><input  type="radio" name="usertype" value="student" checked/> Ученик </p>
        <p><input type="radio"  name="usertype" value="teacher"/> Учитель</p>
        Логин : <input class = "inputtext" type="text" name="login"
            value="<c:out value="${user.login}" />" /> <br />
        Пароль : <input class = "inputtext"
            type="password" name="password"
            value="<c:out value="${user.password}" />" /> <br />
        <%
            String flg = request.getAttribute("ifReg").toString();
            if (flg == "true") {
        %>
        <input type="submit" name = "reg" value="Зарегистрироваться" />
        <%            } else {
        %>
        <input type="submit" name = "in" value="Войти" />
        <%
            }
        %>
    </form>
</body>
</html>