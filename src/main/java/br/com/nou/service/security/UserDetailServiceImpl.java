package br.com.nou.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.nou.entity.UserEntity;
import br.com.nou.repository.IUserRepository;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService{
	
	final static Logger logger = Logger.getLogger(UserDetailServiceImpl.class);
	
	@Autowired
	private IUserRepository userRepository;
	


	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity user = new UserEntity();
		user.setName(login);
        try {
        	user = userRepository.getUserByName(user);
            if (user == null){
            	logger.debug("Usuario nao foi encontrado.");
                return null;
            }
        } catch (Exception e) {
        	logger.debug("Usuario nao foi encontrado. "+e);
            return null;
        }

        return buildUserFromUserEntity(user);
	}
	
	 public UserDetails loadUserByUsernameAndPassword(final String login, final String password) throws UsernameNotFoundException  {
		 UserEntity user = new UserEntity();
	        user.setName(login);
	        user.setPassword(password);
	        try {
	            user = userRepository.getUserByNamePassword(user);
	            if (user == null){
	                return null;
	            }else{
	                return buildUserFromUserEntity(user);
	            }
	        } catch (Exception e) {
	            return null;
	        }
	    }

	public UserDetails buildUserFromUserEntity(final UserEntity user) {
		User springUser = null;

        try {
            // convert model user to spring security user
            String login = user.getName();
            String senha = user.getPassword();
            boolean enabled = true;
            if(user.getEnabled() == 1) {
            	enabled = true;
            } else {
            	enabled = false;
            }
            
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
             
            SimpleGrantedAuthority authorityAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
            SimpleGrantedAuthority authoritySearch = new SimpleGrantedAuthority("ROLE_SEARCH");
            authorities.add(authorityAdmin);
            authorities.add(authoritySearch);
            springUser = new User(login, senha, enabled,
                    accountNonExpired, credentialsNonExpired, accountNonLocked,
                    authorities);
            
        } catch (Exception e) {
          logger.debug("Erro ao logar: "+e);
        }

        return springUser;
	}
	
	

}
