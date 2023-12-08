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
                                <li> <a href="manage?action=manageuser">Manager User</a></li>
                                <li> <a href="manage?action=manageproduct">Manager Products</a></li>
                                <li> <a href="manage?action=manageorder">Manager Orders</a></li>
                                <li> <a href="manage?action=managecategory">Manage Categories</a></li>
                            </ul>
                        </div>
                                        <div class="row"> 
                                                <div class="col col-xs-6"> 
                                                        <h3 class="panel-title">Manage Orders</h3> 
                                                    </div> 
                                           
                                        </div> 
                                </div> 
                        <div class="panel-body"> 
                                <table class="table table-striped table-bordered table-list"> 
                                        <thead> 
                                                <tr> 
                                            <th><em class="fa fa-cog"></em> </th> 
                                            <th>ID</th> 
                                    <th>Username</th>
                                            <th>Date</th> 
                                    <th>Address</th>
                                    <th>SDT</th>
                                            <th>Total</th>    
                                    <th>
                                    </th>
                                                    </tr> 
                                            </thead> 
                                        <tbody>
                                <c:forEach  var="o" items="${orders}" >
                                    <tr > 
                                        <td align="center">
                                            <!--                                            <a href="edituser?uid=" class="btn btn-default"><em class="fa fa-pencil"></em></a> 
                                                                                        <a href="deleteorder?oid=${o.orderId}" class="btn btn-danger"><em class="fa fa-trash"></em></a>-->
                                        </td> 
                                               <td class="hidden-xs">${o.orderId}</td> 
                                               <td class="modify">${o.user.username}</td> 
                                        <td>${o.date}</td> 
                                        <td>${o.adress} </td> 
                                               <td>${o.sdt}</td> 
                                        <td>${o.total}</td>
                                        <td>
                                            <form action="orderdetail" method="post" >
                                                <input type="hidden" name="oid" value="${o.orderId}" >
                                                <input type="submit" value="View Detail" >
                                            </form>
                                        </td>
                                           </tr> 
                                    </c:forEach>

                                  
                                     </tbody></table> 
                            </div> 
                        <div class="panel-footer"> 

                        <a href="home" style="font-size: 20px">Back Home</a>
                              <div class="clearfix">  
                            <ul class="pagination">
                                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                                    <li class="page-item ${loop.index == currentPage ? 'active' : ''}">
                                        <a href="<c:url value='manage?action=manageorder'><c:param name='page' value='${loop.index}'/></c:url>" class="page-link">${loop.index}</a>
                                        </li>
                                </c:forEach>
                            </ul>
                        </div> 
                               
                              </div> 
                         </div> 
                    </div> 
               </div> 
          </div> 
     </div>
</div>
</body>
</html>