<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
     <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- Font awesome -->
   

    <!-- Custom css - Các file css do chúng ta tự viết -->
    <link href="css/orderdetail.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <section class="h-100 h-custom" style="background-color: #eee;">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
              <div class="card border-top border-bottom border-3" style="border-color: #f37a27 !important;">
                <div class="card-body p-5">
      
                  <p class="lead fw-bold mb-5" style="color: #f37a27;">Purchase Reciept</p>
      
                  <div class="row">
                    <div class="col mb-3">
                      <p class="small text-muted mb-1">Date</p>
                      <p>${order.date}</p>
                    </div>
                    <div class="col mb-3">
                      <p class="small text-muted mb-1">Order No.</p>
                      <p> ${order.orderId}</p>
                    </div>
                  </div>
      
                  <div class="mx-n5 px-5 py-4" style="background-color: #f2f2f2;">
                    <div class="row">
                        <c:forEach  var="o" items="${ordertails}" >
                            <div class="col-md-8 col-lg-9">
                                <p>${o.product.productName} x ${o.quantity}</p>
                            </div>
                            <div class="col-md-4 col-lg-3">
                                <p>${o.getTotal()}</p>
                            </div>
                        </c:forEach> 
                    </div>
                  <div class="row my-4">
                    <div class="col-md-4 offset-md-8 col-lg-3 offset-lg-9">
                      <p class="lead fw-bold mb-0" style="color: #f37a27;">Total: ${order.total}</p>
                    </div>
                  </div>
      
                  <p class="lead fw-bold mb-4 pb-2" style="color: #f37a27;">
                     <a href="javascript:history.back()">Go Back</a>
                  </p>
      
                  <div class="row">
                    <div class="col-lg-12">
      
                      
      
                    </div>
                  </div>
      
                  
      
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
</body>
</html>