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

            <h1 class="text-center">Order History</h1>
            <div class="row">
                <div class="col col-md-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Date</th>
                                <th>Adress</th>
                                <th>Telephone</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="datarow">
                         <c:forEach  var="o" items="${orders}" >
                            <tr>
                                <td>${o.orderId}</td>
                                
                                <td>${o.date}</td>
                                <td class="text-right">
                                    ${o.adress}
                                </td>
                                <td class="text-right">${o.sdt}</td>
                                <td class="text-right">${o.total}</td>
                                <td>
                                    <form action="orderdetail" method="post">
                                        <input type="hidden" name="oid" value="${o.orderId}" >
                                        <input type="submit" value="View Detail" >
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        
                            
                        </tbody>
                        
                    </table>
                     
                    <a href="home#menu  " class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                            aria-hidden="true"></i>&nbsp;Quay
                        về trang chủ</a>
                    
                </div>
            </div>
        </div>
        <!-- End block content -->
    </main>



</body>

</html>