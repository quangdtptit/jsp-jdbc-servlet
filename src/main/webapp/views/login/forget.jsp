<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<h3 style="text-align: center;">FORGOT YOUR PASSWORD</h3>
<span style="text-align: center;">Forgot your password? Enter
	your email address and we will send you instructions on how to reset
	your password.</span>
<form style="text-align: center; padding: 10px;" class="form-horizontal"
	action="forgotpassword" method="post">
	<br>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-envelope"></i></span> <input
			style="height: 40px;" type="text" class="form-control" name="email"
			placeholder="Enter Email...">
	</div>
	<br>
	<div class="input-group">
		<button type="submit" class="btn btn-default"
			style="text-align: center; height: 40px; width: 350px;">Next</button>
	</div>
	<br> <a style="text-align: center;" href="<c:url value='/login?action=signin' />">Login</a> <br>
	<a href="<c:url value='/login?action=signup' />" style="text-align: center;">Register an
		Account</a> <br>
</form>