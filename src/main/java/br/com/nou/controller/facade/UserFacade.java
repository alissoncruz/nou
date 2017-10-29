package br.com.nou.controller.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.entity.UserEntity;
import br.com.nou.service.IUserService;

@Service("userFacade")
public class UserFacade {
	
	@Autowired
	private IUserService userService;
	
	public ModelAndView obterUsers() {
		ModelAndView model = new ModelAndView("/user/index");
	
		model.addObject("usuarios", userService.obterUsuarios());
		model.addObject("user", "master");
		return model;
	}

	public ModelAndView novoUsuario() {
		final ModelAndView  model = new ModelAndView("/user/editar");
		model.addObject("user", "master");
		return model;
	}

	public Boolean saveUser(final String id, final String name, final String email, final String password, final Integer enabled) {
		Long iId = null;
		if(!id.equals("null")) {
			iId =  (long) Integer.parseInt(id);
		} 
		return userService.saveUser(iId,name, email, password, enabled);
	}
	
	public Boolean alterUser(final String name, final String email, final String password) {
		
		return userService.alterUser(name, email, password);
	}
	
	public Boolean delete(final Long id) {
		return  userService.delete(id);
	}

	public ModelAndView alterUser(final String name) {
		final ModelAndView model = new ModelAndView("/user/editar-dados");
		UserEntity user = userService.getUser(name);
		System.out.println(user.getName()+" "+user.getEnabled());
		model.addObject("entity", userService.getUser(name));
		model.addObject("user", "master");
		return model;
	}

}
