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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/fontawesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/comic-detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/header.css">
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="container">
    <div class="head">
        <span class="name text-size-big text-uppercase">${comic.name}</span>
        <span class="text-gray text-itali text-size-small">[Cập nhật lúc ${comic.getMostNewUpdate().timeUpdate}]</span>
    </div>
    <div class="base-info row">
        <div class="left col-4">
            <img src="${pageContext.request.contextPath}${comic.cover}" alt="">
        </div>
        <div class="right col-8">
            <ul class="info-list">
                <li class="row">
                    <span class="col-4"><i class="fa-solid fa-user"></i> Tác giả</span>
                    <span class="col-8"><a href="" class="text-blue">${comic.author}</a></span>
                </li>
                <li class="row">
                    <span class="col-4"><i class="fa-solid fa-rss"></i>Tình trạng</span>
                    <span class="col-8">${comic.state}</span>
                </li>
                <li class="row">
                    <span class="col-4"><i class="fa-solid fa-tags"></i>Thể loại</span>
                    <span class="col-8">
                            <c:forEach items="${comic.categorys}" var="category" varStatus="loop">
                                <c:if test="${!loop.last}">
                                    <a href="" class="text-blue">${category}</a> -
                                </c:if>
                                <c:if test="${loop.last}">
                                    <a href="" class="text-blue">${category}</a>
                                </c:if>
                            </c:forEach>
                        </span>
                </li>
                <li class="row">
                    <span class="col-4"><i class="fa-solid fa-eye"></i>Lượt xem</span>
                    <span class="col-8">${comic.view}</span>
                </li>
            </ul>
            <div class="button-group">
                <button type="button" class="button-1 orange-button">Đọc từ đầu</button>
                <button type="button" class="button-1 orange-button">Đọc mới nhất</button>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="title">
            <span class="text-blue text-uppercase text"><i class="fa-solid fa-file-lines"></i> Nội dung</span>
        </div>
        <div class="content__main">
            <p>${comic.content}</p>
        </div>
    </div>
    <div class="list-chapter">
        <div class="title">
            <span class="text-blue text-uppercase text"><i class="fa-solid fa-list"></i> Danh sách chương</span>
        </div>
        <div class="list-head row">
            <div class="col-5">Số chương</div>
            <div class="col-4 text-center">Cập nhật</div>
            <div class="col-3 text-center">Xem</div>
        </div>
        <ul>
            <c:forEach items="${comic.chapters}" var="chapter">
                <li class="row">
                    <%--5. Chọn chương muốn đọc--%>
                    <a href="${pageContext.request.contextPath}/chapter?comic-id=${comic.id}&chapter-id=${chapter.id}"
                       class="col-5">Chapter ${chapter.number}</a>
                    <span class="col-4 text-center text-size-small text-gray text-itali">1 giờ trước</span>
                    <span class="col-3 text-center text-size-small text-gray text-itali">${chapter.view}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>