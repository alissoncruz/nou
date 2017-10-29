<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<form class="form-informacoes">
		<fieldset>
			<legend>Informações</legend>
			
					<p>
						<label>Nome</label>
					<p>${pessoaFisica.nome }</p>
					<label>CPF</label>
					<p>${pessoaFisica.cpf }</p>
					<label>RG</label>
					<p>${pessoaFisica.rg }</p>
					<label>Telefone</label>
					<p>${pessoaFisica.telefone}</p>
					
					<label>Cidade</label>
					<p>${pessoaFisica.cidade}</p>
					<label>UF</label>
					<p>${pessoaFisica.uf}</p>
				
		</fieldset>
	</form>