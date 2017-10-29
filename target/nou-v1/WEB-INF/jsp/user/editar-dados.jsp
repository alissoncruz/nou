<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<div id="resultado" class="result">
		<form action="" class="form-informacoes form-horizontal">
			<fieldset>
				<legend>manage users </legend>
				
				<input id="id" type="hidden"
						class="inp-id" name='id' value="${entity.id }">

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>
						 <input id="name" type="text"
						class="form-control inp-name" name='name' value="${entity.name }"
						placeholder="name ">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-envelope"></i></span> <input id="email"
						type="text" class="form-control inp-email" name='email' value="${entity.email }"
						placeholder="email ">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="password"
						type="password" name='password' class="form-control inp-password"
						placeholder="password" value="${entity.password }">
				</div>

				<div class="input-group">
							<div class="checkbox">
								<label> <input id="enabled" type="checkbox"  class="inp-enabled"
									name="enabled" value="${entity.enabled}" 
									
									<c:if test = "${entity.enabled == 1}">
         									checked ="checked"	
      								</c:if>
									 
									
									/> enabled </label>
							</div>
			     </div>

				</p>
				<button type="button" class="btn btn-primary btn-save">save</button>
				<button type="button" class="btn btn-danger btn-back">back</button>
			</fieldset>
		</form>

	</div>

	