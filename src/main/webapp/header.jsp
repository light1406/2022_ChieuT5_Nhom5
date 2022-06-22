<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="app">
    <header class="header" id="header">
        <div class="navbar">
            <div class="navbar-logo">
                <a href="${pageContext.request.contextPath}/home">
                    <img src="http://st.nettruyenco.com/data/logos/logo-nettruyen.png" alt=""/>
                </a>
            </div>
            <form class="navbar-search" action="">
                <input type="text" class="navbar-search__input" placeholder="Tìm truyện..."/>
                <div class="navbar-search-btn-group">
                    <span class="navbar-search-bt__icon"><i class="fa-solid fa-magnifying-glass"></i></span>
                    <input type="submit" value class="navbar-search__btn nor-button"/>
                </div>
            </form>
            <ul class="navbar-account">
                <li class="login-link">
                    <a href="" class="text-white">Đăng nhập</a>
                </li>
                <li class="register-link">
                    <a href="" class="text-white">Đăng ký</a>
                </li>
            </ul>
        </div>
    </header>
    <nav class="nav-main" id="nav-main">
        <ul class="nav-container">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/home"><i class="fa-solid fa-house"></i></a>
            </li>
            <li class="nav-item">
                <a href="">hot</a>
            </li>
            <li class="nav-item">
                <a href="">thể loại</a>
                <ul class="nav-item-submenu">
                    <li class="nav-item-submenu__item">
                        <a href="">Chuyển sinh</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</div>