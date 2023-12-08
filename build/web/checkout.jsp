<!doctype html>
<html lang="en">
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>Checkout </title>
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/>
        <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">

        <!-- Bootstrap core CSS -->
        <link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <!-- Custom styles for this template -->
        <link href="form-validation.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container">
            <div class="py-5 text-center">

                <h2>CHECKOUT FORM</h2>
            </div>
            <c:set var="size" value="${sessionScope.size}" />
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Your cart</span>
                        <span class="badge badge-secondary badge-pill">${size}</span>
                    </h4>
                    <c:set var="o" value="${sessionScope.cart}" />
                    <ul class="list-group mb-3">
                        <c:forEach items="${o.items}" var="i"> 
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 class="my-0"> ${i.product.productName}</h6>
                                    <small class="text-muted">Amount: ${i.quantity}</small>
                                </div>
                                <span class="text-muted">${i.product.productPrice}</span>
                            </li>
                        </c:forEach>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (VND)</span>
                            <strong>${cart.totalPrice} đ</strong>
                        </li>
                    </ul>

                  
                </div>
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Billing address</h4>

                    <p class="text-danger">${message}</p>

                    <c:set var="u" value="${sessionScope.acc}" />
                    <form class="needs-validation" novalidate action="purchase" method="post" class="box">

                        <div class="mb-3">
                            <label for="name">Full Name <span class="text-muted"></span></label>
                            <input type="text" class="form-control" name="name" value="${u.name}">
                        </div>

                        <div class="mb-3">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" name="address" value="${u.diachi}" required>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="address2">Telephone <span class="text-muted"></span></label>
                            <input type="text" class="form-control" name="sdt" value="${u.sdt}">
                            <div class="invalid-feedback">
                                Please enter your telephone.
                            </div>
                        </div>
                        <input type="submit" class="btn btn-primary btn-lg btn-block" value="Payment" > 
                    </form>
                    <a href="home"> Back Home</a>
                </div>
            </div>


        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.js"></script></body>
</html>
