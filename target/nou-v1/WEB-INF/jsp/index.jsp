<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<script async
	src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
	(adsbygoogle = window.adsbygoogle || []).push({
		google_ad_client : "ca-pub-4306889111193948",
		enable_page_level_ads : true
	});
</script>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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


<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<div class="header">
		<jsp:include page="include/header.jsp" />
	</div>

	<div class="content">
		<div id="divBusca">
			 <input type="text" id="txtBusca" class="valor"
				placeholder="Buscar" />
			<button id="btnBusca" class="btn-pesquisa" type="submit">
			<i class="glyphicon glyphicon-search"></i>
			</button>
		</div>
		<!-- <div class="input-group" id="pesquisa-botoes">
			<input type="text" class="form-control valor" placeholder="Search">
				<div class="input-group-btn">
					<button class="btn btn-default  btn-pesquisa" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
		</div> -->



		<div id="resultado" class="result">
			<jsp:include page="lista.jsp" />
		</div>
	</div>



	<jsp:include page="javascripts.jsp" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/nou.js"></script>

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