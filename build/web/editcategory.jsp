<!DOCTYPE html>
<html lang="en">

<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
    <link href="css/editcategory.css" rel="stylesheet" type="text/css"/>
   
</head>
<body>
    
        <form method="post" action="updatecategory" class="box">
            <input type="hidden" name="cid" value=${category.categoryID}>
            <H1>Edit Category</H1>
            <input type="text" name="categoryName" value=${category.categoryName}>    
            <input type="submit" value="UPDATE">
        </form>
    
</body>

</html>