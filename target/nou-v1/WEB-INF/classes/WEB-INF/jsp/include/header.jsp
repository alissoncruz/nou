

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<header>
	<h1 class="float-l">
		<a href="#" title="nou"> <img
			src="${pageContext.request.contextPath}/static2/img/logomenor.png"
			alt="" style="width: 20%"></a>
	</h1>

	<input type="checkbox" id="control-nav" /> <label for="control-nav"
		class="control-nav"></label> <label for="control-nav"
		class="control-nav-close"></label>
	<nav class="float-r">
		<ul class="list-auto">
			<li><a href="${pageContext.request.contextPath}/" title="Search">search</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/user/"
				title="Users">users</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/listAccess"
				title="Admin">admin</a></li>
			<li><a href="${pageContext.request.contextPath}/logout"
				title="Admin">logout</a></li>
		</ul>
	</nav>
</header>
