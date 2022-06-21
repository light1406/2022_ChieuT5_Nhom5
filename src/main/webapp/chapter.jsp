<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/fontawesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/chapter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/header.css">
</head>

<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="title">
            <span class="text-size-big">
                <a href="" class="text-blue text-capitalize text-size-big">${comic.name}</a>
                - Chapter 1
            </span>
            <span class="text-itali">[Cập nhật lúc: ${chapter.timeUpdate}]</span>
        </div>
        <div class="op-group row">
            <a href="" class="col-auto"><i class="fa-solid fa-house"></i></a>
            <a href="" class="col-auto"><i class="fa-solid fa-list"></i></a>
            <button type="button" class="red-button col-auto left-btn"><i class="fa-solid fa-angle-left"></i></button>
            <select name="slect-chapter" id="select-chapter" class="col-4">
                <option value="1">Chapter ${chapter.number}</option>
            </select>
            <button type="button" class="red-button col-auto right-btn"><i class="fa-solid fa-angle-right"></i></button>
        </div>
        <div class="main">
            <c:forEach items="${chapter.pages}" var="page">
                <div class="page-chapter">
                    <img src="${pageContext.request.contextPath}${page.url}" alt=""/>
                </div>
            </c:forEach>
        </div>
        <div class="bottom-group-bottom row">
            <button class="button-1 red-button col-auto">Chapter trước</button>
            <button class="button-1 red-button col-auto">Chapter sau</button>
        </div>
    </div>
</body>

</html>