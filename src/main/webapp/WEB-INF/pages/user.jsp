<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новый пользователь</title>
    <link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
</head>
<body>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-body">
                            <form action="/user" class="form" role="form" method="POST">
                                <legend>Создание профиля</legend>
                                <div class="form-group">
                                    <label for="username">Имя пользователя</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="username" id="username" value="">
                                    <c:if test="${not empty error}">
                                        <div class="invalid-feedback">${error}</div>
                                    </c:if>
                                    <%--<c:if test="${not empty errorMessage}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessage}</div></c:if>--%>
                                </div>
                                <div class = "form-group">
                                    <label for="password">Пароль</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" name="password" id="password" value="">
                                </div>
                                <button type="submit" class="btn btn-primary">Регистрация</button>
                                <a href="/login" class="btn btn-secondary">Отмена</a>

                                <%--<div class="form-group has-danger">--%>
                                    <%--<label class="form-control-label" for="inputDanger1">Invalid input</label>--%>
                                    <%--<input type="text" value="wrong value" class="form-control is-invalid" id="inputInvalid">--%>
                                    <%--<div class="invalid-feedback">Sorry, that username's taken. Try another?</div>--%>
                                <%--</div>--%>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
