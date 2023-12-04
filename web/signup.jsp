<!DOCTYPE html>
<html lang="en">

<head>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
     <link href="css/logincss.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <form method="post" action="signup" class="box">
        <H1>Sign up</H1>
        <input type="text" placeholder="Username" name="username">
        <input type="password" placeholder="Password" name="password">
        <input type="email" placeholder="Email" name="email">
        <input type="text" placeholder="Fullname" name="name">
        <input type="tel" placeholder="Telephone" name="sdt">
        <input type="text" placeholder="Adress" name="address">
        <input type="submit" value="Register">
    </form>
</body>

</html>
