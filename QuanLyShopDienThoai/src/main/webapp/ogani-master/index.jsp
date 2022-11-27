<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
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
            <a href="#"><img src="img/logo.png" alt=""></a>
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
                <img src="img/language.png" alt="">
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
                                <img src="img/language.png" alt="">
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
                        <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
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
                            <form action="/TrangChu">
                                <input type="text" placeholder="Nhập tên sản phẩm" name="q">
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
                    <div class="hero__item set-bg" >
                        <img src="https://cdn.tgdd.vn/2022/10/banner/1200-255-1200x255-5.png" style="height: 331px; width: 847px">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">

                    <div class="col-lg-3" style="text-align: center">
                        <div class="categories__item set-bg">
                        <img style="height: 168.6px" src="data:image/png;base64,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">
                            <h5><a href="/DanhMuc?Madanhmuc=1">Sam Sung</a></h5>
                        </div>
                    </div>

                    <div class="col-lg-3" style="text-align: center">
                        <div class="categories__item set-bg">
                        <img style="height: 168.6px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1GjxmrsNRdWqV0tPQmQvHCYMKi2ZgLK5wtA&usqp=CAU">
                            <h5><a href="/DanhMuc?Madanhmuc=2">Apple</a></h5>
                        </div>
                    </div>

                    <div class="col-lg-3" style="text-align: center">
                        <div class="categories__item set-bg">
                       <img style="height: 168.6px" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAT4AAACeCAMAAACcjZZYAAABIFBMVEX////gXizz8/Pn5+f///54eHjjXSz8/PxwcHDhXix1dXX///zfXyvgXi/hXin//f3///dtbW3OVSDdWCXxxLXdpI/AwMDdXy/008DaloDWXSG4uLj/9O3PaEXTWyjVi3eSkpL45Nh/f3/TUyTIUSj10cTv7+//+/De3t6Hh4f/+/b4//zDUyCfn5+FhYXNzc2qqqq/XjnHYzbJVjL/7+Xy2Mbrwq3hsprWo4XRk3bThWfLcE7JWy2+WSXDckrHgFnIiGziwqz05MrOk2vGVRvXrI/y//fDdFm9WTroXCPmwabMknb/8O743tPRfl7SUyrutZ3WsqXNopLTc1e8gmnimXf/897dinnSZUnepYXbglz51r3HcVm/YCq+WDfBbEFgsUc4AAAPn0lEQVR4nO2dC0PbRhLHVyBrLe9DshUQEcZnY0BgmSQ8bAg4xCQknJMSmvRC017bfP9vcTMryTi8AlHK9iL9KY6slV37x8zOzGq1IqvThb5dZJoU+mYV+DKpwJdJBb5MKvBlUoEvkwp8mVTgy6QCXyYV+DKpwJdJBb5MKvBlUoEvkwp8mVTgy6QCXyb9s/BR9WiqB0ovtprO5HGmeV+f6gZpx8dM4igslDqOaTLGaBQ5IIoPSIkxk8IvHheLUkQHR+r95Cjt+GI+xHRdlwEX5jIl1w3Der2+rVQPQ7fTwZYI8VJojdGZTLMJ6senvFCZFKAJW73+zu7Tvf2FzT8HSs9Ag8HW1sbB85e7M/25VuhGykKBZcR0e7B2fA5BDOCSnXrv/fB4o9v2PI9zLqWlJKXkvt+AHTY0tBubn5/vHm7HNoqOrPfTa8eH/RyNzO3D4aDme7YhfN/ntoB/hJIfb8T/+Ngog6B7sNNCX6c00vvpteMzHYeFJzMbS4aUBrfB3mwDIFp2bHyWYdu2hCeSY6ONz4CgrA32DsOIOEyv+enEZzLqQMB1X7w88oCOYcAv+KpEgiCZClzZAHC4C+gphtDodQ/6bkQdrb2fVusDfGB6rwbgs2BlgM+4lYRAtgC1Nmy5EXR/+jIYrfic6LXbOm57BvgoSBnYLYSGir4tLO/fhyGFDJHoMkGN+KDnom5/YyCAg3U7cLGkMkEJfeDIGuyGEEC0ZdAa8UG/13mwBF0ddG/iTviQnzAEDzCGvA2djjbv1YcP8hX3zaZvjSRgQH807maDQnBICIXReBvqC7968EGxgMVXr+sZvg8ghIoa9p3wqSzHx5T6FaSAmtxXBz5k58D3bX3mwOBOyC4LEsItSGDYa6IjhdGBjwE+8F13CE7r3zJZuQHfyNpoRYQ52Jvet7TgM7HoZ/3aqMHv5q9XyA583hiGkEBGGgo4PfgofNmzDUvwpMDIIIjavqwdwp9DR/mrpe+DOjdirwLM97I6L4RsAZnPQRgxDb6rBZ8DlX700wa3RtziGfEJi0vLkKfLJiMaijctiQvYnrtTs9F0Mvd9INuQ4jkkf879u68W53UYrR831BhB1q4vkb/Z0pL76QkdjJwM7lSn3SQcTbVrOxB585G4QNpn7gTfw23H+KR33KH5wee+k4jv+7gu4pODlo7MRQ8+Gj5rSI5jBOeB176sq1hds9vv9q84sf63Sw8+0utivYEkJIRN4eO5Ie5/Ka5GVLghOZdY2vpYIOM+MDdfQLbH4XVJF8BF45WOUQM9kZf0j6SVeh6eB8Kh90CdnpTqIT3FYeA5IoAIxQkAs220WDtID7P8dKAQ/hhDHaN+evI+NuNJO8UnAVGtOxgsXVa3Vjs9PUXL5D5k2Bbi85e6gy40DXC4HkwywSf3669zEjocd2+Ulhs41CzaP7euVG9urr/z9mCzAY6LsmwZ7L2I22baEvDxFF8w2M4LPhIuSD9xO7Ao4TfmXEgGceLFuUyHMlNNdwnP+sdLIwn1mbBH3oyaX8DIYQOSbmmkfV9Q6+UlcYm2twI/dV6AImtzzKGUqflT8eQLB6dbmSZllDo0isKdLYwT4MLeDIkinFV02JbgsuPQwYPlnFQdhLVOA5F8cQygsj1HKE5Qo5OKn+FsFsiI3cMBxBDp+2B9FHhS8qANsSOtmSGEBO+dfOAzzd4pTsNIs17bai/jEDSEZDDBTjz7B5yWod0xCDQuNLi/tSGCWELhw3d5cITzEUSKz/I+5GS02TTn2oYYF20pPpMAOvBM6ANToRsThiPxjvvimS0TfOpdHtTwhKUYvwl4dU7wkcO2LeRlfGanvl3H/xKFoctemw5OygX3HQZX4PPTNzGCIcsHPoiaNUzhLuGj5ofPm+daWPjj7c4LVw1EmSbpB/ZFfDy1PiEM+S4naTMjr4Kr8XWeBiNjPAANPZtob70JHfRe5vQaxiV89hifLX9x82J9gE9O4BMpPvdpAKkwjgoIKIgBjS39v3rAizmRczYQl5w3DR0QgnOEbyaw0vPjSEpA4uJiLew+hHrWgIDKocKFQIuV7Wio5oGzCHJtCNfejHOOT6aJC5eWXAjzMeIC+DyIAvZ1+HxIjm3OPSznLAnFLPZ9TuTuX8bH84kPrO8GfAvD4X9QewMOGd1gGwsQyPzeYYlX4GPk4U34hPfRdR0XdLYZgAXWWg6eHaFsz7je+sBKN8N8VB2AT16LL5CW9xRnwERRZ3t/NJJ+0IOogrPA98RN+HiBL8bXeEg6Jtgfq++PLJ8HPYdA4C3wJULnlWnRcRGflH7jIQNvhSykDrFW8Nocw6zZYf/yLvZ91niKUe7w8cv4aIoPp08SxMchhwF8eO0avQLf2Ppsi+cKn/V98WGGmCt8VoHvG/W34ctR0fbd8dkLubE+wDeOvDjoFONjV+ILMPJ+DR9EXrEQ3v/ccD2jzTOBSPM+Afjs9rJzLT5eWybn+NIRF4b4+BifJQCfmw/rM8kO4EvPtH0NH1jfLfBBbbzv5qPmNdn7mkiHmm5hfbfAh2d83+VksJ6ww7Zxa3zXWx8/xydtKfNyroOwubb0r+v77Ftb3wQ+ABi8zclos8OWr8Q3kbiwi/iIwse/dN6JyCuk9yov+MjJQKaTNGxIOXh7GZk4jvuwIaU4xSED02GAD/LD4KjnmCRyqPlrYAvBd9NzHd1Ajks/i4vgPclH6HCi7a2RnyR+trAFP13GpXDALBEfWB/B62YYq38aWYIDPpwrRKM9vJDG+82larGhB12c2Zb+EbhoH+al74vqC6PGeIKfrcakcC6LyT4GkgvvI3HUdJ/6J3XB85zK5xz3Vy6FZSnnhTIE8YnxiAs32vmZYeXuySDBBw5o8UYyv+/kdwk45e+tF73WSav1360R1LJJ40nvF8Gh89tL5v793JA4YzLFJwetvOBjbIanU8skzrT1B12lJWtkWb5/unUET45qR/AU7K2h2ra6wUjwQHq1JfX8FAoNnk7OtW35uZ4T5wU3xVkaKT4flzKQcjTCXzUJzcJwAs9wAp/AC3aB8MgKAsuAQMzhKDwWNn07xQd94nMdKzLpqTpo7/R84QIO4SOee8txvSrb4NLmOLHeUsvi4Axx+IUe0vdx3obP43njSPL8GgXh7To0HzUv5HDbW+KLK3mvulYjXURITdi43GypP0Da9/mNvqlhQQhN+NxjjtdSXQHtEkScPXUVPltdU5Pia2y18nM1OTM/QA53K3zqsCuvJFJT7dMRl+APFuXE+nDe7clR1svwebwWU/xE1j6YrJOP4VJcCiI8EJCyZAM4IevZCVQq+QgdZnw1OYRPaX3Vf1XwuA4a2h4u9Wd4z0Os+e79q+gJHU4n2v4TEmSZeSkI2/YtW1hHh7g0TD7wMRMy3M5MAAmyzHpFr4D82vdHn0PEl5O+D5c9pK2NEaTC0vo6opvxSdvntb6LOXNO8OF8n8h9743ENRc33162ujZmL4yoliWcNfV9WPd2jj3fulXud7P9SfFXi6qkLx/WB6HXjKjTebHpSyMrPosH7fdQ7jpaVrHXuPwhxcv88MJU7os79YCqjsNXSe4HgfQeupq+gk58ED7cnS6uM3xee91aQi1AjJMnpXccaig3Eum0PkrdN0fK9vidVkHkRrwmNo46yNoQcpacLb6pZEYODXe2Tn0832gZt18MDNeDgFJDNKDqqz0NXUfD4lWJ9OFTy5c6rLd/Ogrwwua74MORAuHzkbe5EzquvmWbdVofIRGDkLn9cAmKt0l88cjzFzTj5f/TkXnI9jjAGy0d91zqUI3LrmvFZ6rr793ecEng0Luw1Ki8pQbjpULmq6VccKEX9cSGZhvvPQH5ohd8PnTRfvV9fu13TEgWeugNBw2P43WAyf058P4SyT0T8B4UgqtGWxiqBZ42Gvv9bZfSHN8xQQkn/4AFnr0Zbiy1MaHz43NBUt0ZYXzXBEvtUWxFo7H0y4cXLsHF6vN+vw6iTlw6Duu0+rsHG4NaDRLhMbHkZBEYIl5f2fZqR93Nzx93WvV4xRLtN8v6h+CjRC14AwyX+692Xz4/2P/0aeGvrVSDrYWFg+cv387053pnYbJIDi4Vofuja8enpgaBKb12O3jvE7x9mMvwzkX1+EZZZ2fb9fpP9TAMXVctkEPUHRJYfBsy3dKPD/kxU90yTK25hDDVvcfip2byaKobs8XLNOGQjRmbXt7vlPX/rQJfJhX4MqnAl0kFvkwq8GVSgS+TCnyZVODLpAJfJhX4MqnAl0kFvkzSgY8mtzYY3+EANya3J5rIeculK/6uaqD3e9uE+8Y3Ae7Lb58+0JVp0DlPhXZqavIFdJKS2qITb/Ej46Nkdq3ZXI+/43Sz2VzD//1j2JjC1qn55mK5Wq2WF59MpRxWnjQXS6XSo/XVlN/U/BrsWWzOT6+uP1JN00iNqve531NH942P0kflSvWJ+rqlCm6BZmEX4iOr1QqoBD+V8ipR9jRbxR34W22ipVE6XS7HuwB0JVZ1liC+eXifHxofaKVSKlXRktYrpXJTfe3ZcmmMr1xaa65VAFAl3VMqlxcXcU95HY+m6/gGuBcMT+2GjeoKYpuHvT84PkpXq/C1p9DkKovKZRFfOYbVnI0/zmMAihZF1sDOZhHJKmxVVZ8Ir16Eoyi8qoRvQOfh4Mf4Ktj40fEhrWqp0pwGA6quxLvG+M6/+1qlgpa5AofOxrtX4KB5PCb5l0ypDRq3zOKeXOADty2D10Fn9jjhNYFv5fH8kyfrT+YfgWliMKiCWydxuolEY2oKFq2mHCvJRh7wIUBwxBJCSL7rGN9UU0WDMvzAAVS1JMEA+8rKIxJbX77xkWnV7Y99NcFHaQltUulqfItkEl85p/jQ+uBnPd2RWh+4anl9dXpqamW6WbmAjxT4UmHfh4ncbPI8xQd521p6CLCicd+3Qr7o+3KOD7JbCKeLSfpHJhMXwNdMwu9aCUiqyItdJKZ7U/Fmzvs+SjDvq06jYZVKK/QcH6XovCrJw5yuokoTcPPyRN5Hcm99GDZUyvIEguxaWnUgPsyIS+VqabFUVYUEHExV1VGFqgPTxLjWyzM+ShfLcaVLyaO45sU8uhwnLtMlzFtKWPLGdYRqSwvbJlWDLdWk08SNJH9WG9grVH5wfGS+OR5xWcERl1V02nTEBYLv+qPF0uJac3YqDhiU4CgMWOVaMuJCp+DgGG26kezJwYhLOt43uXlxsI4mj3Hz5Hjf+X566T0puTgIex8qBuszqcCXSQW+TCrwZVKBL5MKfJlU4MukAl8mFfgyqcCXSQW+TCrwZVKBL5MKfJlU4MukAl8mFfgyaZqsThX6Zk0T3Z/g/1r0f+iAsiLvPcXjAAAAAElFTkSuQmCC">
                            <h5><a href="/DanhMuc?Madanhmuc=3">Xiaomi</a></h5>
                        </div>
                    </div>

                    <div class="col-lg-3" style="text-align: center">
                        <div class="categories__item set-bg">
                        <img style="height: 168.6px" src="data:image/png;base64,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">
                            <h5><a href="/DanhMuc?Madanhmuc=4">Oppo</a></h5>
                        </div>
                    </div>

                    <div class="col-lg-3" style="text-align: center">
                        <div class="categories__item set-bg">
                        <img style="height: 168.6px" src="data:image/png;base64,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">
                            <h5><a href="/DanhMuc?Madanhmuc=5">Vivo</a></h5>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row featured__filter">

                <c:forEach items="${sanPhams}" var="sanpham">
                    <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                        <div class="featured__item">
                            <div class="featured__item__pic set-bg" >
                                <img src="${sanpham.getAnhbia()}" style="width: 262.2px; height: 262.2px">
                                <ul class="featured__item__pic__hover">
                                    <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                    <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                    <li><a href="/GioHang?action=create&masp=${sanpham.getMasp()}"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="featured__item__text">
                                <h6><a href="#">${sanpham.getTensp()}</a></h6>
                                <h5>${sanpham.getGiatien()} VNĐ</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </section>


    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
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
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>