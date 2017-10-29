<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<legend>Access Users</legend>

		<table id="table-admin-user-access"
			class="table table-striped table-bordered nowrap display"
			width="100%" cellspacing="0">
			<thead>
				<th>name</th>
				<th>amount</th>
				<th>last access</th>
			</thead>
			<c:if test="${not empty list }">

				<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<td class="tr-name" name="${list.name}">${list.name}</td>
							<td>${list.amount }</td>
							<td>${list.lastAccess }</td>
						</tr>

					</c:forEach>
				</tbody>

			</c:if>
		</table>
