<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="css/editcategory.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"> <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
                                    <li> <a href="testjpql">Manage User</a></li>
                                    <li> <a href="testproduct">Manage Products</a></li>
                                    <li> <a href="manageorder">Manage Orders</a></li>
                                    <li> <a href="loadcategoryadmin">Manage Categories</a></li>
                                </ul>
                            </div>
                            <div class="row"> 
                                <div class="col col-xs-6"> 
                                    <h3 class="panel-title">Manage Categories</h3> 
                                </div> 
                                 <div class="col col-xs-6 text-right"> 
                                    <!--<button type="button" class="btn btn-sm btn-primary btn-create">Thêm mới</button>-->
                                    <a href="addcategory.jsp" ><button type="button" class="btn btn-sm btn-primary btn-create">ADD</button></a>
                                    
                                 </div>
                                         
                            </div> 
                        </div> 
                <div class="panel-body"> 

                    <table class="table table-striped table-bordered table-list"> 
                        <thead> 
                            <tr> 
                                <th><em class="fa fa-cog"></em> </th> 
                                <th class="hidden-xs">ID</th> 
                                <th class="name">Name</th> 

                            </tr> 
                        </thead> 
                        <tbody>
                           <c:forEach  var="o" items="${categories}" >
                               <tr > 
                                   <td align="center">
                                        <a href="editcategory?cid=${o.categoryID}" class="btn btn-default"><em class="fa fa-pencil"></em></a> 
                                        <a href="deletecategory?cid=${o.categoryID}" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                   </td>
                                   <td class="hidden-xs">${o.categoryID}</td>
                                   <td class="modify">${o.categoryName}</td> 
   
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table> 
                </div> 
                <div class="panel-footer"> 
                 <div class="row"> 
                  <div class="col col-xs-4"> </div> 
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