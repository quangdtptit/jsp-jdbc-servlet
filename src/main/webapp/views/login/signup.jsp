<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<h2 style="text-align: center;">SIGN UP</h2>
<form style="text-align: center; padding: 10px;" class="form-horizontal"
	action="sign-up" method="post">
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-user"></i></span> <input style="height: 40px;"
			name="username" id="username" type="text" class="form-control"
			placeholder="Enter User...">
	</div>
	<span id="result1" style="color: #c61313; float: left;"></span> <br>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-envelope"></i></span> <input
			style="height: 40px;" id="email" type="email" class="form-control"
			name="email" placeholder="Enter Email...">
	</div>
	<span id="result2" style="color: #c61313; float: left;"></span> <br>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-lock"></i></span> <input style="height: 40px;"
			id="password" type="password" class="form-control" name="password"
			placeholder="Enter Password...">
	</div>
	<br>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-ok"></i></span> <input style="height: 40px;"
			id="cfpassword" type="password" class="form-control"
			name="cfpassword" placeholder="Confirm Password...">
	</div>
	<span id="result3" style="color: #c61313; float: left;"></span> <br>
	<div class="input-group">
		<button type="submit" class="btn btn-default"
			style="text-align: center; height: 40px; width: 350px;">Next</button>
	</div>
	<br> <a style="text-align: center;"
		href="<c:url value='/login?action=signin'/>">Login</a> <br> <a
		href="<c:url value='/login?action=forget'/>"
		style="text-align: center;">Forgot Password?</a> <br>
</form>