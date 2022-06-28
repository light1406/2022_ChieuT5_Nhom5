<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String error = (String) request.getAttribute("error");

%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/fontawesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/comic-banner.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/comic-card.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/boostrap.min.css">

    <!-- SPLIDE -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/node_modules/@splidejs/splide/dist/css/themes/splide-default.min.css">
</head>

<body>
<jsp:include page="Header.jsp"/>

<div class="container_register d-flex justify-content-center">
    <form action="register" method="post" autocomplete="on">
        <%if (error != null) { %>
        <div class="alert alert-danger" role="alert">
            <%=error%>
        </div>
        <%} %>

        <div class="box">
            <label for="fullName" class="fl fontLabel"> Họ tên: </label>
            <div class="new iconBox">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
            <div class="fr">
                <input type="text"
                       name="fullName"
                       placeholder="Họ tên"
                       class="textBox"
                       autofocus="on"
                       required id="fullName">
            </div>
            <div class="clr"></div>
        </div>

        <div class="box">
            <label for="userName" class="fl fontLabel"> Tên đăng nhập: </label>
            <div class="new iconBox">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
            <div class="fr">
                <input
                        type="text"
                        name="userName"
                        placeholder="Tên đăng nhập"
                        class="textBox"
                        autofocus="on"
                        required id="userName">
            </div>
            <div class="clr"></div>
        </div>

        <div class="box">
            <label for="password" class="fl fontLabel"> Mật khẩu </label>
            <div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
            <div class="fr">
                <input
                        type="Password"
                        required name="password"
                        placeholder="Mật khẩu"
                        class="textBox"
                        id="password"

                >
            </div>
            <div class="clr"></div>
        </div>


        <div class="box">
            <label for="re-password" class="fl fontLabel"> Nhập lại mật khẩu </label>
            <div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
            <div class="fr">
                <input
                        type="Password"
                        required
                        name="re-password"
                        placeholder="Nhập lại mật khẩu"
                        class="textBox"
                        id="re-password"
                >
            </div>
            <div class="clr"></div>
        </div>

        <div class="box">
            <label for="birthYear" class="fl fontLabel"> Năm sinh: </label>
            <div class="new iconBox">
                <i class="fa fa-calendar" aria-hidden="true"></i>
            </div>
            <div class="fr">
                <input
                        type="text"
                        name="birthYear"
                        placeholder="Năm sinh"
                        class="textBox"
                        autofocus="on"
                        required id="birthYear">

            </div>
            <div class="clr"></div>
        </div>


        <div class="box box-submit">
            <input type="Submit" name="Submit" class="submit" value="SUBMIT">
        </div>

    </form>

</div>

<script src="${pageContext.request.contextPath}/assert/js/bootstrap.min.js"></script>

</body>
</html>
