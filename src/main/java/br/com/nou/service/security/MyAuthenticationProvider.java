package br.com.nou.service.security;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@Scope
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	final static Logger logger = Logger.getLogger(MyAuthenticationProvider.class);
	
	@Autowired 
	private UserDetailServiceImpl userDetailService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		 String login = (String) authentication.getPrincipal();
	     String senha = (String) authentication.getCredentials();
	  // Excecao de usuario nao autenticado
	        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(senha)) {
	            throw new AuthenticationServiceException("Erro na localização do LOGIN!!!");
	        } else {
	            // Estou utilizando senha criptografada no banco, por isso esse ELSE
	            senha = ((String) authentication.getCredentials());
	        }

	        //Aqui eu pego as informações do usuário pelo próprio spring security
	        UserDetails user = userDetailService.loadUserByUsernameAndPassword(login, senha);

	        try{
	             //Se o usuário não for null, eu o autentico no sistema
	            if(user != null){
	            	logger.debug("Usuario: "+ user.getUsername());
	                return new MyAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

	            }else{
	            	logger.debug("Usuario nao autenticado.");
	                throw new AuthenticationServiceException("Usuário não autenticado.");
	            }

	        }catch(AuthenticationServiceException e){
	            throw e;
	        }catch(Throwable e){
	        	logger.debug("Ocorreu um erro no ato da autenticação.", e);
	            throw new AuthenticationServiceException("Ocorreu um erro no ato da autenticação.", e);
	        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
                && authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public String getLogin() {
		return getLogin();
	}

}
