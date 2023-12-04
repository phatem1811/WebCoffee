<!DOCTYPE html>
<html lang="en">

<head>
      <%@page contentType="text/html" pageEncoding="UTF-8"%>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link href="css/logincss.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
       <form method="post" action="login" class="box">
        <H1>Login</H1>
        <p class="text-danger">${message}</p>
        <input type="text" placeholder="User" name="username">
        <input type="password" placeholder="Password" name="password">
        <div class="remember-forgot">
            <label><input type="checkbox">remember me</label>
            <a href="#">forgot password</a>
        </div>
        <input type="submit" value="Login" name="btAction">
        
        <div class="register-link">
            <p> Don't have an account?<a href="signup.jsp">Register</a></p>
    </form>
    
</body>

</html>