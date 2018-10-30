<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактирование заметки</title>
    <link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
</head>
<body>
<div style="text-align: right; margin:10px">${note.userName} <a href="/logout">Выход</a></div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-5 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-body">
                            <div style="width:150px; margin:20px; text-align: center";><img src = "${note.avatar}"></div>
                            <form action="/note" method="POST">
                                <div class="form-group">
                                    <label for="text">Текст заметки:</label>
                                    <textarea class="form-control"  name="text" id="text" rows="3">${note.text}</textarea>
                                    <input type="hidden" name="id" value="${note.id}">
                                </div>
                                    <div style="text-align: right"><strong>${note.date}</strong></div>
                                <input type="submit" class="btn btn-primary" value="Сохранить">
                                <a href="/notes" class="btn btn-success">К списку заметок</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
