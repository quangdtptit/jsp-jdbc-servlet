<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.CategoryModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
					<a href="#" class="list-group-item active">Category 1</a> <a
						href="#" class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="http://placehold.it/900x400" alt="">
					<div class="card-body">
						<h3 class="card-title">Product Name</h3>
						<h4>$24.99</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
							facere, soluta. Totam id dolores, sint aperiam sequi pariatur
							praesentium animi perspiciatis molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Reviews</div>
					<div class="card-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<a href="#" class="btn btn-success">Leave a Review</a>
					</div>
				</div>
				<!-- /.card -->
				<hr>

				<!-- Comments Form -->
				<div class="card my-4">
					<h5 class="card-header">Leave a Comment:</h5>
					<div class="card-body">
						<form>
							<div class="form-group">
								<textarea class="form-control" rows="3"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
				<!-- Comments Form -->
				<!-- Single Comment -->
				<div class="media mb-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
					</div>
				</div>

				<!-- Comment with nested comments -->
				<div class="media mb-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

						<div class="media mt-4">
							<img class="d-flex mr-3 rounded-circle"
								src="http://placehold.it/50x50" alt="">
							<div class="media-body">
								<h5 class="mt-0">Commenter Name</h5>
								Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
								scelerisque ante sollicitudin. Cras purus odio, vestibulum in
								vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
								nisi vulputate fringilla. Donec lacinia congue felis in
								faucibus.
							</div>
						</div>

						<div class="media mt-4">
							<img class="d-flex mr-3 rounded-circle"
								src="http://placehold.it/50x50" alt="">
							<div class="media-body">
								<h5 class="mt-0">Commenter Name</h5>
								Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
								scelerisque ante sollicitudin. Cras purus odio, vestibulum in
								vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
								nisi vulputate fringilla. Donec lacinia congue felis in
								faucibus.
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>

	</div>
	<!-- /.container -->
</body>
</html>