<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link href="css/edituser.css" rel="stylesheet" type="text/css"/>
   
</head>
<body>
    
        <form method="post" action="manage" class="box">
            <input type="hidden" name="action" value="addproduct" >
            <H1>Edit Product</H1>
            <label>Product Name: </label>
            <input type="text" name="productname" >
            <label>Image: </label>
            <input type="text" name="filename" >
            <label>Product Price: </label>
            <input type="text" name="price">
            <label>Product Size: </label>
            <input type="text" name="size" >            
            <label>Category:</label>            
            <select name="category" class="form-select" >
                <c:forEach var="o" items="${listc}" >
                    <option value=${o.categoryID}> ${o.categoryName}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Add Product">
            
        </form>
    
</body>

</html>