<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <%@page contentType="text/html" pageEncoding="UTF-8"%>
         <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        
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
                                    <li> <a href="testjpql">Manager User</a></li>
                                    <li> <a href="testproduct">Manager Products</a></li>
                                    <li> <a href="manageorder">Manager Orders</a></li>
                                    <li> <a href="loadcategoryadmin">Manage Categories</a></li>
                                </ul>
                            </div>
                            <div class="row"> 
                                <div class="col col-xs-6"> 
                                    <h3 class="panel-title">Quản lí User</h3> 
                                </div> 
                            <div class="col col-xs-6 text-right"> 
                                <button type="button" class="btn btn-sm btn-primary btn-create">Thêm mới</button> 
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
                                <th class="username">Username</th>
                                <th class="password">Password</th>
                                <th class="email">Email</th> 
                                <th class="SDT">SDT</th>
                                <th class="address">Address</th>
                    
                            </tr> 
                        </thead> 
                        <tbody>
                           <c:forEach  var="o" items="${users}" >
                               <tr > 
                                   <td align="center"><a href="edituser?uid=${o.getUserId()}" class="btn btn-default"><em class="fa fa-pencil"></em></a> 
                                                      <a href="delete?uid=${o.getUserId()}" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                   </td> 
                                   <td class="hidden-xs">${o.getUserId()}</td> 
                                   <td class="modify">${o.name}</td> 
                                   <td>${o.getUsername()}</td> 
                                   <td>${o.getPassword()}</td> 
                                   <td>${o.getEmail()}</td> 
                                   <td>${o.getSdt()}</td>
                                   <td>${o.getDiachi()}</td>
                               </tr> 
                            </c:forEach>
                                                          
                      
                 </tbody></table> 
                </div> 
                <div class="panel-footer"> 
                    <div class="clearfix">  
                    <ul class="pagination">
                        <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                            <li class="page-item ${loop.index == currentPage ? 'active' : ''}">
                                <a href="<c:url value='paginguser'><c:param name='page' value='${loop.index}'/></c:url>" class="page-link">${loop.index}</a>
                                </li>
                        </c:forEach>
                    </ul>
                </div> 
               </div> 
              </div> 
             </div>
            </div>
    </body>
</html>