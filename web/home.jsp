<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatitble" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>The Coffee Shop </title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <!-- start header -->
        <header class="header">
            <a href="home" class="logo">
                <img src="img/logo.jpg" width="150" height="60">
            </a>

            <nav class="navbar">
                <ul>
                    <li><a href="home">home</a></li>
                    <li><a href="#menu">menu</a>
                        <ul class="dropdown">
                            <c:forEach  var="o" items="${listc}" >
                                <li><a href="category?cid=${o.categoryID}#menu">${o.categoryName}</a></li>    
                                </c:forEach>
                        </ul>
                    </li>

                    <li><a href="#about">about</a></li>
                    <li><a href="#contact">contact</a></li>
                        <c:if test="${sessionScope.acc == null}">
                        <li><a href="login.jsp">login</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                        <li><a href="Profile.jsp" >Welcome ${sessionScope.acc.username} !</a>
                            <ul class="dropdown">
                                <li><a href="Profile.jsp">Infomation</a></li>
                                <li><a href="ordercustomer">Order History</a></li>
                            </ul>
                        </li>
                        <li><a href="logout">logout</a></li>
                        </c:if>
                </ul>
            </nav>





            <form action="search#menu" class="search" method="post">
                <span class="icon-large"><i class="ri-search-line"></i></span>
                <input oninput="searchByName(this)" type="search" value="${txtS}"  name="txt" placeholder="Search for products" 
                       style="height: 25px; border-radius: 7px;padding-right: 20px; ">
                <button type="submit" name="action" style="background-color: transparent; color: white">  <div class="fas fa-search" id="seach-btn"
                                          ></div></button>                
            </form>

            <div class="icons">
                <c:set var="size" value="${sessionScope.size}" />
                <a href="cart.jsp"> <div class="fas fa-shopping-cart" id="cart-btn"> </div>
                    <p style="color: white; margin-left: 30px; margin-top: 10px; ">my bag (${size}) items</p>
                </a>
                <div class="fas fa-bars" id="menu-btn"></div>
            </div>
            <!-- <div class="cart-item-container">
                <div class="cart-item">
                    <span class="fas fa-times"></span>
                    <img src="img/cart1.png">
                    <div class="content">
                        <h3>cart item 1</h3>
                        <div class="price">$15.99</div>
                    </div>
                </div>
            </div> -->
        </header>

        <!-- home start -->
        <section class="home" id="home">
            <div class="content">
                <h3>fresh coffee in the morning</h3>
                <p>enjoy your day!</p>
                <a href="#menu" class="btn"> get yours now</a>
            </div>
        </section>

        <!-- menu start -->
        <section class="menu" id="menu">
            <p class="text-danger" style="color: white">${searchmessage}</p>
            <h1 class="heading">
                <div class="box-container">
                    <c:forEach  var="o" items="${listp}" >
                        <div class="box">
                            <img src=${o.img}>
                            <h3>${o.productName}</h3>
                            <div class="price">${o.productPrice} </div>
                            <a href="cart?pid=${o.productID}#menu" class="btn">add to cart</a>
                        </div>
                    </c:forEach>
                </div>


            </h1>
        </section>

        <!-- about start -->
        <section class="about" id="about">
            <h1 class="heading"><span>about</span> us</h1>

            <div class="row">
                <div class="image">
                    <img src="img/about.jpg" width="150" height="500">
                </div>

                <div class="content">
                    <h3>what makes our coffee special?</h3>
                    <p>Coffee beans</p>
                    <p>Freshness</p>
                    <p>Processing Method</p>
                    <p>Artisanal or Specialty Coffee</p>
                    <a href="#" class="btn">learn more</a>
                </div>
            </div>
        </section>


        <!-- contact-start -->
        <section class="contact" id="contact">
            <h1 class="heading"><span>contact</span> us</h1>
            <div class="row">
                <iframe class="map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3917.
                        7259804969535!2d106.73889967451872!3d10.908417456746292!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.
                        1!3m3!1m2!1s0x3174d14575edc615%3A0x47c3f5cace0b3b2c!2sVincom%20Plaza%20D%C4%A9%20An!5e0!3m2!1svi!2s!4v1699687043948!5m2!1svi!2s" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
                </iframe>

                <form action="">
                    <h4 class=""><i class="fa-solid fa-location-dot"></i> Vincom Plaza Di An, Binh Duong</h4>
                    <h4 class=""><i class="fa-regular fa-envelope"></i> dinhquynh240703@gmail.com</h4>
                    <h4 class=""><i class="fa-solid fa-phone"></i> (+84)32465113</h4>
                </form>
            </div>
        </section>

        <!-- footer start -->
        <section class="footer">
            <div class="share">
                <a href="#" class="fab fa-facebook-f"></a>
                <a href="#" class="fab fa-twitter"></a>
                <a href="#" class="fab fa-instagram"></a>
                <a href="#" class="fab fa-tiktok"></a>
            </div>

            <div class="links">
                <a href="#">home</a>
                <a href="#menu">menu</a>
                <a href="#about">about us</a>
                <a href="#contact">contact</a>
            </div>

            <div class="credit">created by <span>group 7</span></div>
        </section>
        <script src="js/script.js"></script>
    </body>

</html>