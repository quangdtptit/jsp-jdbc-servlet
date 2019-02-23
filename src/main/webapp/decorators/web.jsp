<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><dec:title default="Trang chu" /></title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css " media="all">
<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/style.css' />"
	rel="stylesheet" type="text/css " media="all">
<link rel="stylesheet"
	href="<c:url value='/template/paging/jquery.twbsPagination.js'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/paging/jquery.twbsPagination.js'/>" />
</head>
<body>
	<!--header  -->
	<%@include file="/common/web/header.jsp"%>
	<!--header  -->

	<div class="container">
		<dec:body />
	</div>

	<!--footer  -->
	<%@include file="/common/web/footer.jsp"%>
	<!--footer  -->
	<script src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>