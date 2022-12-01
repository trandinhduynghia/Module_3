<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chủ</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->

    <link rel="stylesheet" href="ogani-master/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="ogani-master/css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="ogani-master/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="ogani-master/img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
            <div class="header__top__right__auth">
                <a href="/DangNhap"><i class="fa fa-user"></i> Đăng nhập</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="/TrangChu">Trang Chủ</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shop-details.html">Shop Details</a></li>
                        <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                        <li><a href="./checkout.html">Check Out</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> Xin chào</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="ogani-master/img/language.png" alt="">
                                <div>English</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Vietnam</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                            <c:if test="${sessionScope.nguoiDung == null}">
                                <div class="header__top__right__auth">
                                    <a href="/DangNhap"><i class="fa fa-user"></i> Đăng nhập</a>
                                </div>
                            </c:if>

                            <c:if test="${sessionScope.nguoiDung != null}">
                                <div class="header__top__right__auth">
                                    <a href="/DangXuat"><i class="fa fa-user"></i> Đăng xuất</a>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.jsp"><img src="ogani-master/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="/TrangChu">Trang Chủ</a></li>
                            <c:if test="${sessionScope.nguoiDung != null}">
                                <li><a href="/ThongTinCaNhan?manguoidung=${sessionScope.nguoiDung.manguoidung}">Cá Nhân</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 1}">
                                <li><a href="/DanhMuc">Danh mục</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 1}">
                                <li><a href="/DanhSachNguoiDung">Người dùng</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 1}">
                                <li><a href="/DangKy">Thêm người dùng</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 1}">
                                <li><a href="/DanhMuc?action=create">Thêm danh mục</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 2}">
                                <li><a href="/DanhSachSanPham?manguoidung=${sessionScope.nguoiDung.manguoidung}">Sản phẩm</a></li>
                            </c:if>
                            <c:if test="${sessionScope.nguoiDung.IDquyen == 2}">
                                <li><a href="/DanhSachSanPham?action=create">Thêm sản phẩm</a></li>
                            </c:if>


                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> </a></li>
                            <li><a href="/GioHang"><i class="fa fa-shopping-bag"></i> </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Danh mục</span>
                        </div>
                        <ul>

                            <c:forEach items="${danhMucs}" var="danhmuc">
                                <li><a href="/DanhMuc?action=sanphamtheodanhmuc&Madanhmuc=${danhmuc.getMadanhmuc()}">${danhmuc.getTendanhmuc()}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="/DanhSachNguoiDung">
                                <input type="text" placeholder="Nhập tên người dùng" name="hoTen">
                                <button type="submit" class="site-btn">Tìm kiếm</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>Hỗ trợ 24/7</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->



    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>

                            <tr>
                                <th>Mã người dùng</th>
                                <th>Họ tên</th>
                                <th>Email</th>
                                <th>Điện thoại</th>
                                <th>Mật khẩu</th>
                                <th>Địa chỉ</th>
                                <th>ID quyền</th>
                                <th>Sửa</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="o" items="${listNguoiDung}">
                                <tr>
                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getManguoidung()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getHoten()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getEmail()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getDienthoai()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getMatkhau()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getDiachi()}
                                    </td>

                                    <td class="shoping__cart__item" style="text-align: center">
                                            ${o.getIDquyen()}
                                    </td>


                                    <td class="shoping__cart__item__close">
                                        <form method="get">
                                            <button class="btn btn-danger btn-sm" type="submit" style="background-color: #005cbf">
                                                <a style="text-decoration: none; color: white" href="/DanhSachNguoiDung?action=edit&manguoidung=${o.getManguoidung()}">Sửa</a>
                                            </button>
                                        </form>
                                    </td>

                                    <td class="shoping__cart__item__close">
                                        <form method="get">
                                            <button class="btn btn-danger btn-sm" type="submit">
                                                <a style="text-decoration: none; color: white" href="/DanhMuc?action=delete&manguoidung=${o.getManguoidung()}">Xóa</a>
                                            </button>
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>



                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </section>


    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.jsp"><img src="ogani-master/img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: Đà Nẵng</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: ogani@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">

                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="ogani-master/img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="ogani-master/js/jquery-3.3.1.min.js"></script>
    <script src="ogani-master/js/bootstrap.min.js"></script>
    <script src="ogani-master/js/jquery.nice-select.min.js"></script>
    <script src="ogani-master/js/jquery-ui.min.js"></script>
    <script src="ogani-master/js/jquery.slicknav.js"></script>
    <script src="ogani-master/js/mixitup.min.js"></script>
    <script src="ogani-master/js/owl.carousel.min.js"></script>
    <script src="ogani-master/js/main.js"></script>



</body>

</html>