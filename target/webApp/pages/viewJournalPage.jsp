<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset=UTF-8">
    <title>JournalPage</title>
</head>
<body>
<%
    String type = request.getAttribute("ustype").toString();
%>
<form method="POST" action="view?type=<c:out value="${ustype}"/>">
    <p>Введите дату в формате "гггг-мм-дд" </p><input class = type="text" name = "date"/>
    <p>Выберите класс</p>
    <select name="studClass">
        <option disabled>Выберите класс</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
    </select>
    <p><input type="submit" name = "viewJ" value="Показать"></p>
</form>
<c:if test = "${schoolday !=null}">
<table>
    <thead>
    <tr>
        <th>Дата</th>
        <th>День недели</th>
        <th>Класс</th>
    </tr>
    </thead>
    <TBODY>
    <tr>
        <td><c:out value="${date}" /></td>
        <td><c:out value="${day}" /></td>
        <td><c:out value="${cl}" /></td>
    </tr>
    </TBODY>
</table>
</c:if>
<table border=1>
    <thead>
    <tr>
        <th>Урок</th>
        <th>Предмет</th>
        <th>Домашнее задание</th>
        <th>Оценка</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
        <c:if test = "${schoolday != null}">
            <%
                int i=0;
            %>
            <c:forEach items="${schoolday}" var="sday">
        <tr>
            <td><%=
                 ++i
            %></td>
            <td><c:out value="${sday.name}" /></td>
            <td><c:out value="${sday.homework}" /></td>
            <td><c:out value="${sday.mark}" /></td>
            <%
                if (type.equalsIgnoreCase("student")){
            %>
            <td><a href="view?action=homework&class=<c:out value="${cl}" />&date=<c:out value="${date}" />&week=<c:out value="${day}" />&subjId=<c:out value="${sday.id}"/>&value=<c:out value="${sday.homework}"/>">Изменить домашнее задание</a><br></td>
            <%            } else {
            %>
            <td><a href="view?action=mark&class=<c:out value="${cl}" />&date=<c:out value="${date}" />&week=<c:out value="${day}" />&subjId=<c:out value="${sday.id}"/>&value=<c:out value="${sday.mark}"/>">Изменить оценку</a></td>
            <%
                }
            %>
        </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<%
    if (type.equalsIgnoreCase("student")){
%>
<p><a href="view?action=addSchoolDay">Составить расписание</a></p>
<%
    }
%><p><a href="helloPage">На главную</a></p>
</body>
</html>