<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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

    <!-- SPLIDE -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/@splidejs/splide/dist/css/themes/splide-default.min.css">
</head>

<body>
    <jsp:include page="IdeaProjects/ComicWeb/src/main/webapp/Header.jsp"/>
    <div class="container">
        <div class="banner">
            <div class="title">
                <span class="text-blue text-size-big">Truyện đề cử <i class="fa-solid fa-angle-right"></i></span>
            </div>
    
            <div class="splide" role="group">
                <div class="splide__track">
                    <ul class="splide__list">
                        <c:forEach items="${banner}" var="item">
                            <li class="splide__slide">
                                <div class="comic-banner__item">
                                    <a href="${pageContext.request.contextPath}/comic-detail?comic-id=${item.id}">
                                        <img src="${pageContext.request.contextPath}${item.cover}" alt="">
                                    </a>
                                    <div class="base-info">
                                        <div class="name">
                                            <a href="${pageContext.request.contextPath}/comic-detail?comic-id=${item.id}" class="text-white">${item.name}</a>
                                        </div>
                                        <div class="chapter">
                                            <a href="${pageContext.request.contextPath}/chapter?comic-id=${item.id}&chapter-id=${item.getMostNewUpdate().id}"
                                               class="text-size-small text-white">Chapter ${item.getMostNewUpdate().number}</a>
                                            <span class="text-size-small text-white text-itali">${item.getMostNewUpdate().timeUpdate}</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <div class="new-update">
            <div class="title">
                <span class="text-blue text-size-big">Mới cập nhật <i class="fa-solid fa-angle-right"></i></span>
            </div>

            <div class="new-update__list">
                <c:forEach items="${new_update}" var="item">
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

    <script src="./node_modules/@splidejs/splide/dist/js/splide.min.js"></script>
    <script>
        new Splide('.splide', {
            type: 'loop',
            perPage: 5,
            autoplay: true,
            interval: 2000,
            perMove: 1
        }).mount();
    </script>
</body>

</html>