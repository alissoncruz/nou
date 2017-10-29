<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<sec:authorize ifAllGranted="ROLE_USER">
	<c:redirect url="/inicio" />
</sec:authorize>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="pt-br">
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="format-detection" content="telephone=no" />
<title>nou - System Solutions</title>

<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" /> --%>
<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" /> --%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/js/bootstrap.min.js" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/js/jquery.min.js" />


</head>


<body>

	<div class="container-fluid">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">nou | Login</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#">Esqueceu a senha?</a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form class="form-horizontal" role="form" id="form-login"
						action="<c:url value="j_spring_security_check"/>" method="post">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control login" name='j_username'
								value="" placeholder="login">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" name='j_password' class="form-control password"
								placeholder="senha">
						</div>

						<c:if test="${!empty param.login_error}">
							<label class="control-label error">Desculpe, tente	novamente</label>
						</c:if>


						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Lembrar </label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<button id="btn-login" href="#" type="submit" class="btn btn-success">Login </button>

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Não tem uma conta! <a href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										Crie uma agora. </a>
								</div>
							</div>
						</div>
					</form>



				</div>
			</div>
		</div>
</html>
