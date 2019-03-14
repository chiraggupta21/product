<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Product List</title>
<style>

a{
text-decoration:none;
}
html, body {
	height: 100%
}

.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

.row.content {
	height: 450px
}

.sidenav {
	padding-top: 20px;
	
	height: 200%;
}

footer {
	color: white;
	padding: 15px;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Grizzly Store &nbsp;&nbsp;&nbsp;&nbsp; Welcome,${pageContext.request.userPrincipal.name}</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"
					onClick="window.location.href='logout';return false;"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<c:forEach var="temp" items="${products}">
		<c:url var="updateLink" value="/products/update">
			<c:param name="productId" value="${temp.getId()}"></c:param>
		</c:url>
		<c:url var="deleteLink" value="/products/delete">
			<c:param name="productId" value="${temp.getId()}"></c:param>
		</c:url>
	</c:forEach>

	<div class="container-fluid text-center">
		<div class="row content">
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
			<div class="col-sm-8 text-left">
				<br>

				<h4>
					<b>Product List</b>
				</h4>
				<br>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="p" items="${products}">
						<tr class="info">
							<td>${p.id}</td>
							<td>${p.product_name}</td>
							<td>${p.product_category}</td>
							<td>${p.product_price}</td>
							<td><a class="btn-sm btn-primary" href="${updateLink}">Update</a> 
							<a href="${deleteLink}" class="btn-sm btn-primary"
								onClick="if(!(confirm('delete')))return false">Delete</a> <br>
								<br></td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div class="col-sm-2 sidenav">
				<div class="well">
					<a href="#" class="btn-sm btn-primary" onClick="window.location.href='showform';return false;"><span
						class=""></span> Add Product</a>

				</div>
			</div>
		</div>
	</div>
	<div class="footer navbar-fixed-bottom container-fluid text-center"
		style="background-color: #c2c2c2">
		<p>Is this a footer?</p>
	</div>
</body>
</html>