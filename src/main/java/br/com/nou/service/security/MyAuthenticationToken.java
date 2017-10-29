package br.com.nou.service.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MyAuthenticationToken extends UsernamePasswordAuthenticationToken{
	
	private static final long serialVersionUID = 3456784186417970504L;
	
	public MyAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities){
        super(principal, credentials, authorities);
    }
	
	public String getLogin() {
		return getLogin();
	}
	
	public String getNome() {
		return getNome();
	}

}
