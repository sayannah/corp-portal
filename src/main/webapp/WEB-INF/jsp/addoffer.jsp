<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>AddOffer</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<style>
body {
	padding-top: 3.5rem;
	position: relative;
	margin: 0;
	padding: 0;
	overflow: auto;
		background: linear-gradient(-45deg, #f1f513, #c93636, #756fca, #159b63);
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
  .btn-pink{
  background: #d12890;
  }
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 700px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#main {
	padding-bottom: 15rem;
}

#content1 {
	padding-top: 5rem;
}

#search {
	padding-left: 1rem;
}

#contentcat {
	padding-top: 4rem;
}

#logbutton {
	padding-right: 2rem;
}
#brand {
	font-size: 30px;
}
.space{
padding-top:25px;
}
.black{
background-color: black;}
</style>
<script>
function validateForm() {
  var offername = document.getElementById("offerName").value;
  var openedDate =document.getElementById("openedDate").value;
  var closedDate = document.getElementById("closedDate").value;
  openedDate = new Date(openedDate);
  closedDate = new Date(closedDate);
  var regex = /^[A-Za-z_ ]+$/;
  if (!(offername.match(regex))) {
    alert("Offer Name must be alphabets only");
    return false;
  }
  else if( openedDate > closedDate){
      alert("Offer Closing date should be higher than offer opening date");
      return false;
  }
  
}
</script>


</head>
<body class="text-center">
	<nav class="navbar navbar-expand-md navbar-dark fixed-top black" style="height:80px;">
		<div class="container-fluid">
		<a class="navbar-brand" id="brand" href="viewalloffers">
			<img src="https://www.logoground.com/uploads6/dv6y2020476742020-01-193666677LG-CC-drops1.jpg" height="50"width="80"/></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item active">
              <a class="nav-link" href="viewprofile">My
									Profile </a>
            </li>
							<li><a class="nav-link" href="myoffer">My Offers</a></li>
							<li><a class="nav-link" href="viewtopofferbylikes">Top
									Offers</a></li>
							<li><a class="nav-link" href="viewoffer">Other
									Offers</a></li>
							<li><a class="nav-link" href="viewofferbyposteddate">Search
									Offer By Posted Date</a></li>
							<li><a class="nav-link" href="viewofferbycatid">Search
									Offer By Category</a></li>

					
				</ul>
				<ul class='nav'>
					</form>
					<div id="logbutton">
						<a class="btn " href="logout"><img src="data:image/png;base64,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"
						          height="30" width="30" /><role="button"></a>
						<div></div>
					</div>
	</nav>

	<main class="form-signin" id="main">
		<form name="addoffer" method="post" action="/addOffer" onsubmit="return validateForm()" >
			<div class="jumbotron" id="content">
				<div class="container">
					<h1 class="display-6">Post Your Offer</h1>
				</div>
			</div>
			<div id="content1">

				<label for="inputEmail" class="visually-hidden">Employee Id</label>
				<input type="text" id="inputEmail" class="form-control"
					placeholder="Employee id" value="${empid}" name="empId" required
					autofocus readonly="readonly"> <label for="offerName"
					class="visually-hidden">Offer Name</label> <input type="text"
					id="offerName" class="form-control" placeholder="Offer name"
					name="offerName"   autofocus> <label
					for="openedDate" class="visually-hidden">Open Date</label> <input
					type="date" id="openedDate" class="form-control"
					placeholder="Open Date" name="openedDate" required autofocus>

				<label for="closedDate" class="visually-hidden">Close Date</label> <input
					type="date" id="closedDate"  class="form-control"
					placeholder="Close Date" name="closedDate" required autofocus>

				<label for="inputPassword" class="visually-hidden">Offer
					Category</label> <select name="offerCategoryId" class="form-control"
					id="selectcategory" required>
					<option value="">Choose Category</option>
					<option value="120">Homes</option>
					<option value="121">Vehicles</option>
					<option value="122">Electronics</option>
					<option value="123">Home Appliances</option>
					<option value="124">Mobiles & Tablets</option>
					<option value="125">Furniture & Decors</option>
					<option value="126">Commercial Rentals</option>
				</select>


				<div class="checkbox mb-3"></div>
				<button class="w-100 btn btn-lg btn-primary" type="submit" >Add
					offer</button>
		</form>
	</main>
	</div>
	
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>
</body>


<style>
html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

#content {
	padding-top: 5rem;
}

#content1 {
	padding-top: 2rem;
}

#search {
	padding-left: 65rem;
}

#search {
	padding-left: 1rem;
}

#logbutton {
	padding-left: 2rem;
}

#brand {
	font-size: 45px;
}

#offerbutton {
	padding-top: 2rem;
}
</style>




</html>