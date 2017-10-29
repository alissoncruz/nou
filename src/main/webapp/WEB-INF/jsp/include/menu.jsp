<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


	<div id="pop-menu">
		<a id="" data-toggle="popover" title="menu" data-placement="bottom" ><i
			class="glyphicon glyphicon-th"> </i> </a>
			
		<label id=""title="Popover Header" data-placement="bottom" value="${user}"><i
			class="glyphicon glyphicon-user"> </i> ${user}</label>
	
	</div>
	
	<div id="clickGoogle" style="display:none;">
		
		<span class="input-group-addon"><i
						class="glyphicon glyphicon-search">
						<a href="${pageContext.request.contextPath}/">search </a>
						</i></span>
		<fieldset></fieldset>				
		<span class="input-group-addon"><i
						class="glyphicon glyphicon-user">
						<a href="${pageContext.request.contextPath}/user/">users </a>
						</i></span>
		<fieldset></fieldset>
		<span class="input-group-addon"><i
						class="glyphicon glyphicon-off">
						<a href="${pageContext.request.contextPath}/logout">logout</a>
						</i></span>						
							 
		<%-- <a href="${pageContext.request.contextPath}/user/novo">new users </a> --%>
	</div>