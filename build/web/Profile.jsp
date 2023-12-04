<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/profile.css">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Profile</title>
    </head>
    <body>
    <form method="post" action="updateprofile" class="box">
        <input type="hidden" name="id" value="${sessionScope.acc.userId}">
        <div class="container rounded bg-white mt-5 mb-5">
            <p class="text-success"> ${message}</p>
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                        <span class="font-weight-bold">Edogaru</span>
                        <span class="text-black-50">edogaru@mail.com.my</span>          
                    </div>
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6"><label class="labels">Username</label>
                                <input type="text" class="form-control" placeholder="username" value="${sessionScope.acc.username}" name="username">
                            </div>
                            <div class="col-md-6"><label class="labels">Password</label>
                                <input type="text" class="form-control" placeholder="password" value="${sessionScope.acc.password}" name="password">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="enter phone number" value="${sessionScope.acc.sdt}" name="sdt"></div>
<div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control" placeholder="enter address" value="${sessionScope.acc.diachi}" name="diachi"></div>
                            <div class="col-md-12"><label class="labels">Full name</label><input type="text" class="form-control" placeholder="enter address" value="${sessionScope.acc.name}"name="name"></div>
                            <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="enter email" value="${sessionScope.acc.email}" name="email"></div>
                        </div>

                        <div class="mt-5 text-center">
                            <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                            <a href="home.jsp" class="return">Return Home</a>
                        </div>
                    </div>
                </div>
<!--                <div class="col-md-4">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center experience"><span>Edit Experience</span><span class="border px-3 p-1 add-experience"><i class="fa fa-plus"></i>&nbsp;Experience</span></div><br>
                        <div class="col-md-12"><label class="labels">Experience in Designing</label><input type="text" class="form-control" placeholder="experience" value=""></div> <br>
                        <div class="col-md-12"><label class="labels">Additional Details</label><input type="text" class="form-control" placeholder="additional details" value=""></div>
                    </div>
                </div>-->
            </div>
        </div>
    </form>
    </body>
</html>