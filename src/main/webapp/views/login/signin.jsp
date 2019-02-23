<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-In</title>
</head>
<body>
	<h2 style="text-align: center;">SIGN IN</h2>
	<form style="text-align: center; padding: 10px;"
		class="form-horizontal" action="<c:url value ='/login'/>"
		method="post">
		<c:if test="${not empty message}">
			<div class="form-group">
				<div class="alert alert-${alert}"
					style="background-color: #62f762; border: 1px solid #62f762; margin-top: -18px; margin-bottom: -18px;">
					<strong>${message}</strong>
				</div>
			</div>
		</c:if>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-user"></i></span> <input style="height: 40px;"
				type="text" class="form-control" name="userName"
				placeholder="Tên tài khoản">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input style="height: 40px;"
				id="password" type="password" class="form-control" name="password"
				placeholder="Mật khẩu">
		</div>
		<br>
		<div class="input-group">
			<button type="submit" class="btn btn-default"
				style="text-align: center; height: 40px; width: 350px;">Login</button>
		</div>
		<input type="hidden" name="action" value="signin"> <br> <a
			style="text-align: center;" href="login?action=signup">Register
			an Account</a> <br> <a href="login?action=forget"
			style="text-align: center;">Forgot Password?</a> <br>
	</form>
</body>
</html>