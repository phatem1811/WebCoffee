<!DOCTYPE html>
<html lang="en">


<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Category</title>
        <link href="css/editcategory.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="manage" method="post" class="box">
            <input type="hidden" name="action" value="addcategory">
            <H1>Add Category</H1>
            <input type="text" name="categoryName">
            
           
            <input type="submit" value="ADD">
                
        </form>
    </body>
</html>
