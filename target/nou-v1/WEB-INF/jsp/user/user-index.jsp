<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
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
	


	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script>
</head>

<body>
	<div id="menu" style="margin-bottom: 25px" class="input-group">
		<span class="input-group-addon"><i
								class="glyphicon glyphicon-user">  </i></span> <label class="form-control login" name='j_username'
								value="${user}" placeholder="login">master</label> 
	</div>

	<div id="logocentral">

		<picture> <source sizes="80%"
			srcset="${pageContext.request.contextPath}/static2/img/logocentral.png 2000w">

		<img
			src="${pageContext.request.contextPath}/static2/img/logocentral.png"
			alt="descrição da imagem"></picture>
	</div>

	<div class="input-group" id="pesquisa-botoes">
		<input type="text" class="form-control valor" placeholder="Search">
			<div class="input-group-btn">
				<button class="btn btn-default  btn-pesquisa" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
	</div>

	<!-- 	<div id="pesquisa-botoes" class="form-group">
			<input class="cpf" type="text" class="form-control input-sm" id="inputsm"  />
		 	<a id="btn-signup" type="button"
				class="btn btn-info btn-pesquisa"> <i class="icon-hand-right"></i>
			
			</a>
			
			 <button type="button" class="btn btn-default  btn-pesquisa">
    			<span class="glyphicon glyphicon-search"></span> 
  			</button>
		</div>
 -->


	<%-- <jsp:include page="include/header.jsp" /> --%>
	<%-- <fmt:setLocale value="pt_BR" scope="session" />
 --%>
   

	<div id="resultado" class="result">
		<jsp:include page="lista.jsp" />
	</div>

<%-- 

<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script> --%>
<jsp:include page="../javascripts.jsp" />

<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/nou.js"></script>

<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/responsive.bootstrap.min.js" />

		
<%--
 
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.min.js" />


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/init.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/jquery-1.12.4.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/dataTables.fixedHeader.min.js" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/dataTables.responsive.min.js" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/responsive.bootstrap.min.js" />

		<jsp:include page="javascripts.jsp" />
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static2/js/materialize.min.js" />
 --%>
</body>
</html>