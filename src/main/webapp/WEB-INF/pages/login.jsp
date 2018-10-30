<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Вход</title>
    <link href='<spring:url value="${pageContext.request.contextPath}/resources/css/style.css"/>' rel="stylesheet" />
</head>
<body>
<c:if test="${not empty errorMessage}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessage}</div></c:if>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h3 class="mb-0">Вход</h3>
                        </div>
                        <div class="card-body">
                            <form action="/login" class="form" role="form" autocomplete="off" id="formLogin" method="POST">
                                <div class="form-group">
                                    <label for="username">Имя пользователя</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="username" id="username" required="">
                                </div>
                                <div class="form-group">
                                    <label>Пароль</label>
                                    <input type="password" name="password" class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-primary btn-lg float-right" id="btnLogin">Войти</button>
                            </form>
                            <a href = "/user">Зарегистрироваться</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>