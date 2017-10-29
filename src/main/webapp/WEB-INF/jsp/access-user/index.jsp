<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
<title>nou - System Solutions</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static2/css/nou.css" />


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static2/css/form.css" />


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.min.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static2/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static2/css/admin.css" />


</head>
<body>
	<div class="header">
		<jsp:include page="../include/header.jsp" />
	</div>
<div class="content">

		<jsp:include page="list.jsp" />

</div>

	<jsp:include page="../javascripts.jsp" />


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/users.js"></script>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/responsive.bootstrap.min.js" />


</body>
</html>

