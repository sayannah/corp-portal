<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Corporate Classifieds</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
        rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Template Main CSS File -->
    <style>
        /*--------------------------------------------------------------
# General
--------------------------------------------------------------*/
/* ==========================================================================
   #BACKGROUND
   ========================================================================== */
body {
		background: linear-gradient(-45deg, #0d99ac, #f7aafa, #3c9757, #24f5c4);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
}
@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
} 

  
  #brand {
    color: white;
    outline: none;
    text-decoration: none;
    padding-left:2rem;
  }
  
  p {
    padding: 0;
    margin: 0 0 30px 0;
  }
  
  h1, h2, h3, h4, h5, h6 {
    font-family: "Poppins", sans-serif;
    font-weight: 400;
    margin: 0 0 20px 0;
    padding: 0;
  }

  
  /*--------------------------------------------------------------
  # Header
  --------------------------------------------------------------*/
  #header {
    height: 70px;
    position: auto;
    left: 0;
    top: 0;
    right: 0;
 background-color: #1a1a1a;
 
  }
  
  #header.header-fixed {
    background: rgba(19, 23, 26, 0.9);
    padding: 10px 0;
    height: 50px;
  }

  .pull-left {
      float: left;
  }

 
 /* ==========================================================================
     #CARD
     ========================================================================== */
  .card {
    overflow: hidden;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    border-radius: 3px;
    background:#fff;
  }
  
  .card-3 {
    background: #000;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    -webkit-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
    -moz-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
    box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
    width: 70%;
    display: table;
  }
  
  .card-3 .card-heading {
    background: linear-gradient(-45deg, #b98997, #5c8fd1, #2f9737, #4c9282);
    background-size: 300% 300%;
    animation: gradient 15s ease infinite;
    display: table-cell;
    width: 30%;
  }
  
  .card-3 .card-body {
    padding: 57px 45px;
    padding-bottom: 35px;
    display: table-cell;
  }
  /*error point*/
  @media (max-width: 707px) {
    .card-3 {
      display: block;
    }
    .card-3 .card-heading {
      display: block;
      width: 80%;
      padding-top: 200px;
      background-position: center center;
    }
    .card-3 .card-body {
      display: block;
      width: 50%;
      padding: 37px 30px;
      padding-bottom: 15px;
    }
  }
   /* ==========================================================================
     #TITLE
     ========================================================================== */
  .title {
    font-size: 24px;
    color: #fff;
    font-weight: 400;
    margin-bottom: 36px;
  }
   .p-t-180 {
    padding-top: 60px;
  }
  .p-b-100 {
    padding-bottom: 50px;
  }
   .wrapper--w780 {
    max-width: 780px;
  }
   .wrapper {
    margin: 0 auto;
  }
   .page-wrapper {
    min-height: 80vh;
  }
   
  .font-poppins {
    font-family: "Poppins", "Arial", "Helvetica Neue", sans-serif;
  }
/*--------------------------------------------------------------
# Footer
--------------------------------------------------------------*/
#footer {
  height: 60px;
  background-color: #1a1a1a;
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  color: white;
  text-align: center;
}

#footercontent {
  padding-top: 2rem;
}

#logo{

  padding-top: 6px;
  font-size: 45px;


}
#invalidmsg{
color:red;
text-align: center;
align-content: center;
padding-top:10px;
}

.btn {
    display: inline-block;
    line-height: 40px;
    padding: 0 33px;
    font-family: Poppins, Arial, "Helvetica Neue", sans-serif;
    cursor: pointer;
    color: #fff;
    -webkit-transition: all 0.4s ease;
    -o-transition: all 0.4s ease;
    -moz-transition: all 0.4s ease;
    transition: all 0.4s ease;
    font-size: 18px;
  }
  .btn--pill {
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
  }
  
  .btn--green {
    background: #57b846;
  }
  
  .btn--green:hover {
    background: #4dae3c;
  }
   /* ==========================================================================
     #FORM
     ========================================================================== */
  input {
    outline: none;
    margin: 0;
    border: none;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;
    width: 100%;
    font-size: 14px;
    font-family: inherit;
  }
  
  .input-icon {
    position: absolute;
    font-size: 18px;
    color: #ccc;
    right: 8px;
    top: 50%;
    -webkit-transform: translateY(-50%);
    -moz-transform: translateY(-50%);
    -ms-transform: translateY(-50%);
    -o-transform: translateY(-50%);
    transform: translateY(-50%);
    cursor: pointer;
  }
  
  .input-group {
    position: relative;
    margin-bottom: 33px;
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  }
  
  .input--style-3 {
    padding: 5px 0;
    font-size: 16px;
    color: #ccc;
    background: transparent;
  }
  
  .input--style-3::-webkit-input-placeholder {
    /* WebKit, Blink, Edge */
    color: #ccc;
  }
  
  .input--style-3:-moz-placeholder {
    /* Mozilla Firefox 4 to 18 */
    color: #ccc;
    opacity: 1;
  }
  
  .input--style-3::-moz-placeholder {
    /* Mozilla Firefox 19+ */
    color: #ccc;
    opacity: 1;
  }
  
  .input--style-3:-ms-input-placeholder {
    /* Internet Explorer 10-11 */
    color: #ccc;
  }
  
  .input--style-3:-ms-input-placeholder {
    /* Microsoft Edge */
    color: #ccc;
  }
  
footer.d{
  text-align: center;
  background-color: rgb(43, 37, 35);
  color: white;
  height: 50px;
  padding-top:5px;
  width:100%;
  font-family: Arial, sans-serif; font-size: 22px;
}
  
  </style>

</head>

<body>

    <!-- ======= Header ======= -->
    <header id="header">
            <div id="logo" class="pull-left" style="font-style:"Brush Script MT, Brush Script Std, cursive;">
               <a id="brand" href="viewalloffers"> Corporate Classifieds</a>

      
        </div>
    </header>
    <!-- End Header -->

    <!-- ======= Start Login ======= -->

 <body>
        <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
            <div class="wrapper wrapper--w780">
                <div class="card card-3">
                    <div class="card-heading"></div>
                    <div class="card-body">
                        <h2 class="title">Login</h2>
    <form action="/login" method="post" >
    
        <div class="text-center"><img src="https://icons-for-free.com/iconfiles/png/512/login+person+profile+user+users+icon-1320166527284195604.png"
        alt="sign in logo" width="100" height="100" ></div>  
        
        <div id="invalidmsg"><p>${invalidmsg}</p></div>   
          <div class="input-group">
           <input type="text" class="input--style-3" id="inputEmail3"
                  name="empUsername" placeholder="Username">
        </div>
         <div class="input-group">
            <input type="password" class="input--style-3" id="inputPassword3"
                  name="empPassword" placeholder="Password">
        </div>
          <div class="input">
            <button id="submit" type="submit" class="btn btn--pill btn--green">Sign in</button>
        </div>
              
    </form>
     </div>
                </div>
            </div>
        </div>




  <!-- ======= End Login ======= -->





    <!-- ======= Footer ======= -->
        <!-- ======= Footer ======= -->
     <footer class="d" >
        <h6>Copyright © 2021 All rights reserved.</h6>
      </footer>
<!-- End Footer -->
   
</body>

</html>