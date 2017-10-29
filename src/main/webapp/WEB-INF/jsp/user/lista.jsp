<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="exception-result">
	<p>
		<c:if test="${not empty mensagem }">
			<p>
				<c:out value="${mensagem}" />
			<p>
		</c:if>
		
	</p>
</div>

	<table id="table-users"
			class="table table-striped table-bordered nowrap display" width="100%"
			cellspacing="0">
			<thead>
				<th>name</th>				
				<th>email</th>
				<th>enabled</th>
				<th><button type="button" class="btn btn-primary btn-novo">new</button></th>
			</thead>
	<c:if test="${not empty usuarios }">
		
			<tbody>
				<c:forEach var="pessoa" items="${usuarios}">
					<tr   >
						<td class="tr-name" name="${pessoa.name}" >${pessoa.name}</td>
						<td > ${pessoa.email }</td>
						<td > 
						    <c:if test = "${pessoa.enabled == 1}">
         									true	
      						</c:if>
      						<c:if test = "${pessoa.enabled == 0}">
         									false	
      						</c:if>
						</td>
						<td > 
						  <a type="button"  name-id="${pessoa.name}" id="${pessoa.id}" class="btn btn-success btn-sm btn-alter">alter</a>
						  <a type="button" name-id="${pessoa.name}"  id="${pessoa.id}" class="btn btn-danger btn-sm btn-delete">delete</a>
						</td>
					</tr>
	
				</c:forEach>
			</tbody>
		
	</c:if>
</table>

	
			