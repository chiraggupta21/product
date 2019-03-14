<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Add</title>
<style type="text/css">
* {
	box-sizing: border-box;
}
a{
text-decoration:none;
}
body {
	margin: 0;
}

.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
	border-style: solid;
	border-width: 0 0 6px 0;
}

label {
	color: #c2c2c5;
	display: block;
	font-size: 20px;
	height: 25px;
	margin-top: 20px;
	margin-bottom: 5px;
}

input {
	background: transparent;
	color: #000000;
	font-size: 20px;
	height: 30px;
	line-height: 30px;
	outline: none !important;
	width: 100%;
	border-style: solid;
	border-width: 2px 2px;
}

.left {
	float: left;
	padding: 10px;
	width: 25%;
}

.right {
	float: left;
	padding: 10px;
	width: 75%;
	border-style: solid;
	border-width: 0 0 0 6px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

@media screen and (max-width: 600px) {
	.left, .right {
		width: 100%;
	}
}

#submit {
	color: #707075;
	margin-top: 40px;
	transition: color 300ms;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="listall">Grizzly Store &nbsp;&nbsp;&nbsp;&nbsp; Welcome,${pageContext.request.userPrincipal.name}</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="#"
					onClick="window.location.href='logout';return false;"><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="col-sm-2 sidenav">
		<blockquote>
			<p>This is the best website ever created</p>
			<footer>William Shakespeare</footer>
		</blockquote>
		<blockquote class="blockquote-reverse">
			<p>OMG, best site</p>
			<footer>Akshay Katoch</footer>
		</blockquote>
	</div>

	<form class="text-center border border-light p-5">
		<h4 align="left">&nbsp;&nbsp;&nbsp;&nbsp;Add Product</h4>

		<div class="col-sm-8 text-left">
			<input type="text" name="product_name" class="form-control mb-2"
				placeholder="Name" value="${product.getProduct_name()}"><br>
			<input type="text" name="product_category" class="form-control mb-2"
				placeholder="Category" value="${product.getProduct_category()}"><br>
			<input type="text" name="product_price" class="form-control mb-2"
				placeholder="Price" value="${product.getProduct_price()}"><br>
			<button class="btn btn-info btn-md my-4" type="submit" id="submit"
				value="submit">Submit</button>
		</div>

		<div class="d-flex justify-content-around">
			<div></div>
		</div>
	</form>
	<div class="footer navbar-fixed-bottom container-fluid text-center"
		style="background-color: #c2c2c2">
		<p>Is this a footer?</p>
	</div>
</body>
</html>