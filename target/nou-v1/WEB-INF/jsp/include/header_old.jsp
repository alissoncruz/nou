<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="header-bloco">
	<div class="header-conteudo">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container" style="width: auto;">

					<%-- 					<a class="brand"
						href="${pageContext.request.contextPath}/indicadoresRisco"> <img
						src="${pageContext.request.contextPath}/static/img/logo-bcinf-sist-blue.png" />
					</a> --%>

					<ul class="nav pull-right">
						<li class=""><a
							href="${pageContext.request.contextPath}/painel-novo">Acesso
								ao sistema</a></li>


<%-- 						<li class="dropdown"><a href="#" id="drop2" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <span
								class="data-area-text">Relatorios</span> <b class="caret"></b></a>

							<ul class="dropdown-menu " role="menu" aria-labelledby="drop2">
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/relatorios">Relatorios
										Gerais</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/detalhe-calculo/titulo">Detalhamento
										de Calculo</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/detalhe-calculo/indices">Detalhamento
										de Indices</a></li>
							</ul></li> --%>


						<li class="dropdown"><a href="#" id="drop2" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <span
								class="data-area-text">Manutencao</span> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu " role="menu" aria-labelledby="drop2">
								<li role="presentation" class="divider"></li>
								
								
							</ul></li>

						<li id="fat-menu" class="dropdown"><a href="#" id="drop3"
							role="button" class="dropdown-toggle" data-toggle="dropdown">
								<span class="data-area-text nome-user"><i
									class="icon-user icon-white"></i> 
									<l:label-nome nome="${user.name }"></l:label-nome> 
								</span><b class="caret"></b>
						</a>

							<ul class="dropdown-menu" role="menu" aria-labelledby="drop3">
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/usuarios">Manutencao
										Usuarios</a></li>
								<li role="presentation" class="divider"></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/usuarios/senharesetar">Trocar
										Senha</a></li>
								<li role="presentation" class="divider"></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath}/logout"><i
										class="icon-off"></i> Sair</a></li>
							</ul></li>

					</ul>

				</div>
			</div>
		</div>
	</div>
</div>