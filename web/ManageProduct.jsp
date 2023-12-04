<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <%@page contentType="text/html" pageEncoding="UTF-8"%>
         <link href="css/admin.css" rel="stylesheet" type="text/css"/>
         <link href="styles.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">        
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        
        <div class="container"> 
             <div class="row"> 
                <h1 class="text-center">ADMIN</h1> 

                    <div class="panel panel-default panel-table"> 
                        <div class="panel-heading"> 
                            <div class="menu_admin">
                                <ul >
                                    <li> <a href="testjpql">Manager User</a></li>
                                    <li> <a href="testproduct">Manager Products</a></li>
                                    <li> <a href="manageorder">Manager Orders</a></li>
                                    <li> <a href="loadcategoryadmin">Manage Categories</a></li>
                                </ul>
                            </div>
                            
                            <div class="row"> 
                                <div class="col col-xs-6"> 
                                    <h3 class="panel-title">Quản lí Product</h3> 
                                </div> 
                                
                                <div class="col col-xs-6 text-right"> 
                                    <li><a href="addproduct" type="button" class="btn btn-sm btn-primary btn-create">Add Product</a></li>                                
                                </div> 
                            </div> 
                        </div> 
                <div class="panel-body"> 
                    <table class="table table-striped table-bordered table-list"> 
                        <thead> 
                            <tr> 
                                <th><em class="fa fa-cog"></em> </th> 
                                <th class="hidden-xs">ProductID</th> 
                                <th class="name">Product Price</th> 
                                <th class="img">img</th>
                                <th class="price">Product Price</th>
                                <th class="size">Product Size</th> 
                                <th class="category">Category</th>
                    
                            </tr> 
                        </thead> 
                        <tbody>
                           <c:forEach  var="p" items="${products}" >
                               <tr > 
                                    <td align="center"><a href="editproduct?pid=${p.getProductID()}" class="btn btn-default"><em class="fa fa-pencil"></em></a>
                                        <a href="deleteproduct?pid=${p.getProductID()}" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                    <td class="hidden-xs">${p.getProductID()}</td> 
                                    <td class="modify">${p.getProductName()}</td> 
                                    <td><img class="img" src="${p.getImg()}" alt="alt"/></td>
                                    <td>${p.getProductPrice()}</td> 
                                    <td>${p.getProductSize()}</td>  
                                    <td>${p.category.categoryName}</td>
                               </tr> 
                            </c:forEach>                                                          
                                    
                 </tbody></table> 
                </div> 
                <div class="panel-footer"> 
                 <div class="row"> 
                  <div class="col col-xs-4"></div> 
                  <div class="col col-xs-8"> 
                   
                  </div> 
                 </div> 
                </div> 
               </div> 
              </div> 
             </div>
            </div>
    </body>
</html>