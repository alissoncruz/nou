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
		<a href="${pageContext.request.contextPath}/">home </a>
		<a href="${pageContext.request.contextPath}/user/">users </a>
		<a href="${pageContext.request.contextPath}/user/novo">new users </a>
	</div>