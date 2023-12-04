<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cart</title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- Font awesome -->
    <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">
    <link href="css/cart.css" rel="stylesheet" type="text/css"/>
    <!-- Custom css - Các file css do chúng ta tự viết -->
   
</head>

<body>
    <!-- header -->
<!--    <nav class="navbar navbar-expand-md navbar-dark sticky-top bg-dark">
        <div class="container">
            <a class="navbar-brand" href="https://nentang.vn">Nền tảng</a>
            <div class="navbar-collapse collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="../index.html">Trang chủ <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="https://nentang.vn">Quản trị</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="products.html">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.html">Liên hệ</a>
                    </li>
                </ul>
                <form class="form-inline mt-2 mt-md-0" method="get" action="search.html">
                    <input class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm" aria-label="Search"
                        name="keyword_tensanpham">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                </form>
            </div>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="cart.html">Giỏ hàng</a>
                </li>
                <li class="nav-item text-nowrap">
                     Nếu chưa đăng nhập thì hiển thị nút Đăng nhập 
                    <a class="nav-link" href="login.html">Đăng nhập</a>
                </li>
            </ul>
        </div>
    </nav>
     end header -->

    <main role="main">
        <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
        <div class="container mt-4">
            <div id="thongbao" class="alert alert-danger d-none face" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>

            <h1 class="text-center">Cart</h1>
            <div class="row">
                <div class="col col-md-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>NO.</th>
                                <th>Img</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Unit Price</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="datarow">
                        <c:set var="o" value="${sessionScope.cart}" />
                        <c:set var="t" value="0" />
                        <c:forEach items="${o.items}" var="i">
                            <c:set var="t" value="${t+1}" />
                            <tr>
                                <td>${t}</td>
                                <td>
                                    <img style="width: 50px; height: 50px" src="${i.product.img}" alt="alt"/>
                                </td>
                                <td>${i.product.productName}</td>
                                <td class="text-right">
                                    <!-- HIển thi và tăng giảm số lượng -->
                                    <a href="handle?num=-1&id=${i.product.productID}" 
                                       style="font-size: 20px;text-decoration: none;">-</a>
                                    ${i.quantity}
                                    <a href="handle?num=1&id=${i.product.productID}" 
                                       style="font-size: 20px ; text-decoration: none;">+</a>
                                </td>
                                <td class="text-right">${i.product.productPrice}</td>
                                <td class="text-right">${i.total}</td>
                                <td>
                                    <!-- Nút xóa, bấm vào sẽ xóa thông tin dựa vào khóa chính `sp_ma` -->
                                    <form action="handle" method="post">
                                        <input type="hidden" name="id" value="${i.product.productID}" >
                                        <input type="submit" value="Remove" >
                                    </form>
                              
                                </td>
                            </tr>
                        </c:forEach>
                        
                            
                        </tbody>
                        
                    </table>
                    <h4>Total Price : ${cart.totalPrice} đ</h4>   
                    <a href="home#menu  " class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                            aria-hidden="true"></i>&nbsp;Back to Home</a>
                    <a href="checkout" class="btn btn-primary btn-md"><i
                            class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Check Out</a>
                </div>
            </div>
        </div>
        <!-- End block content -->
    </main>



</body>

</html>