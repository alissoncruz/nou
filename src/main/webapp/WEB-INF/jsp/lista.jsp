<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



	<c:if test="${not empty listaPessoas }">
		<table id="table-result"
			class="table table-striped table-bordered nowrap display" width="100%"
			cellspacing="0">
			<thead>
				<th>Nome</th>
				<th>CPF</th>
				<!-- 		<th>RG</th> -->
			</thead>
			<tbody>
				<c:forEach var="pessoa" items="${listaPessoas}">
					<tr cpf="${pessoa.cpf }">
						<td class="nome">${pessoa.nome}</td>
						<td class="cpf"><a href="#"> ${pessoa.cpf }</a></td>
						<%-- 			<td class="cpf" ><p><a href="#"> ${pessoa.rg } <p></a></td> --%>
					</tr>
	
				</c:forEach>
			</tbody>
		</table>
	</c:if>


<c:if test="${not empty pessoaFisica}">
	<jsp:include page="form.jsp" />	
</c:if>

<div class="exception-result">
	<p>
		<c:if test="${not empty mensagem }">
			<p>
				<c:out value="${mensagem}" />
			<p>
		</c:if>
		
	</p>
</div>		
			