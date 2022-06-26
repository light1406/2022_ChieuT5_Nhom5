<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comic-2022</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/searchScreen.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/fontawesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/comic-banner.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/comic-card.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/header.css">

    <!-- SPLIDE -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/node_modules/@splidejs/splide/dist/css/themes/splide-default.min.css">
</head>
<body>
<%--<jsp:include page="IdeaProjects/ComicWeb/src/main/webapp/Header.jsp"/>--%>
<jsp:include page="Header.jsp"/>
<div id="main">
    <div class="result" style="padding: 0 15px 0">
        <H2 class="text-center">Kết quả</H2>
        <div class="col1">
            <div class="row">

                <c:forEach items="${result}" var="item">
                    <div class="comic-card">
                        <div class="cover">
                            <a href="${pageContext.request.contextPath}/comic-detail?comic-id=${item.id}">
                                <img src="${pageContext.request.contextPath}${item.cover}" alt="">
                            </a>
                            <div class="base-eva">
                                <span>
                                    <i class="fa-solid fa-eye"></i> ${item.view}
                                    <i class="fa-solid fa-comment"></i> 0
                                    <i class="fa-solid fa-heart"></i> 0
                                </span>
                            </div>
                        </div>
                        <div class="name">
                            <a href="${pageContext.request.contextPath}/comic-detail?comic-id=${item.id}">${item.name}</a>
                        </div>
                        <ul class="chapter">
                            <c:forEach items="${item.getThreeChapterNewUpdate()}" var="chap">
                                <li>
                                    <a href="${pageContext.request.contextPath}/chapter?comic-id=${item.id}&chapter-id=${chap.id}"
                                       class="text-size-small">Chapter ${chap.number}</a>
                                    <span class="text-size-small text-gray text-itali">${chap.timeUpdate}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="type-list" style="padding-left: 25px;">
        <h2 class="text-center">Thể loại</h2>
        <ul style="list-style-type:none;">
            <li><a href="">Action</a></li>
            <li><a href="">Anime</a></li>
            <li><a href="">Drama</a></li>
            <li><a href="">Ecchi</a></li>
            <li><a href="">Fantasy</a></li>
            <li><a href="">Horror</a></li>
            <li><a href="">Manga</a></li>
            <li><a href="">Manhwa</a></li>
            <li><a href="">Mystery</a></li>
            <li><a href="">One shot</a></li>
            <li><a href="">Romance</a></li>
            <li><a href="">Shoujo</a></li>
            <li><a href="">Shounen</a></li>
        </ul>
    </div>
</div>
</body>
</html>