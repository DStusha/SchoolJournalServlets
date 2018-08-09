<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AddPage</title>
</head>
<body>
<form method="POST" action="edit">
    <p>Введите дату в формате "гггг-мм-дд" </p><input class = type="text" name = "date"/>
    <p>Выберите день недели</p>
    <select name="day">
        <option disabled>Выберите день недели</option>
        <option value="Понедельник">Понедельник</option>
        <option value="Вторник">Вторник</option>
        <option value="Среда">Среда</option>
        <option value="Четверг">Четверг</option>
        <option value="Пятница">Пятница</option>
        <option value="Суббота">Суббота</option>
    </select>
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
    <p>1 урок Предмет :  <select name="first">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "firstHW"/></p>
    <p>2 урок Предмет : <select name="second">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "secondHW"/></p>
    <p>3 урок Предмет :  <select name="third">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "thirdHW"/></p>
    <p>4 урок Предмет : <select name="fourth">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "fourthHW"/></p>
    <p>5 урок Предмет : <select name="fifth">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "fifthHW"/></p>
    <p>6 урок Предмет : <select name="sixth">
        <option disabled>Выберите предмет</option>
        <option value="Математика">Математика</option>
        <option value="Русский язык">Русский язык</option>
        <option value="Литература">Литература</option>
        <option value="Физика">Физика</option>
        <option value="Химия">Химия</option>
        <option value="История">История</option></select>
        Домашнее задание : <input class = type="text" name = "sixthHW"/></p>
    <input type="submit" name = "addDay" value="Сохранить" />
</form>
</body>
</html>
