<!DOCTYPE html>
<html lang="en">

<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
    <link href="css/edituser.css" rel="stylesheet" type="text/css"/>
   
</head>
<body>
    
        <form method="post" action="manage" class="box">
            <input type="hidden" name="action" value="updateuser">
            <input type="hidden" name="id" value=${user.userId} >
            <H1>Edit User</H1>
            
            <input type="text" name="username" value=${user.username}>
            <input type="password" name="password" value=${user.password}>
            <input type="email" name="email" value=${user.email}>
            <input type="text" name="name" value=${user.name}>
            <input type="tel" name="sdt" value=${user.sdt}>
            <input type="text" name="address" value=${user.diachi}>
            <input type="submit" value="UPDATE">
            
        </form>
    
</body>

</html>