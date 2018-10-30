<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Результаты поиска</title>
    <link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
</head>
<body>
<div style="text-align: right; margin:10px">${userName} <a href="/logout">Выход</a></div>
<div class="card">
    <div class="card-header">
        <h2>Результаты поиска по запросу "${searchString}"</h2>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <tr>
                <th scope="row"></th>
                <th scope="row">Текст</th>
                <th scope="row">Дата</th>
                <th scope="row">Действие</th>
            </tr>
            <c:forEach var="note" items="${notesList}">
                <tr class="table-light">
                    <td><img style="width:50px" src="${note.avatar}"></td>
                    <td>${note.shortText} <a href = "/note/${note.id}">Открыть</a></td>
                    <td>${note.date}</td>
                    <td><a href = "/deleteNote/${note.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
        <div class="row">
            <div class="btn-group">
                <a class="btn btn-primary btn-sm" href="/note">Добавить заметку</a>
                <p> </p>
                <a class="btn btn-success btn-sm" href="/notes">К списку заметок</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>