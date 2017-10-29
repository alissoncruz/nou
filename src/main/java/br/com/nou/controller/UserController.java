package br.com.nou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.controller.facade.UserFacade;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private UserFacade userFacade;
	
	@RequestMapping("/")
	public ModelAndView obterUsuarios() {
		return userFacade.obterUsers();
	}
	
	@RequestMapping("/index")
	public ModelAndView obterUsuariosIndex() {
		return userFacade.obterUsers();
	}
	

	@RequestMapping("/novo")
	public ModelAndView novoUsuario() {
		return userFacade.novoUsuario();
		
	}
	
	@RequestMapping("/save/{id}/{name}/{email}/{password}/{enabled}")
	public @ResponseBody Boolean salvarUsuario(
			@PathVariable("id") final String id,
			@PathVariable("name") final String name,
			@PathVariable("email") final String email,
			@PathVariable("password") final String password,
			@PathVariable("enabled") final Integer enabled
			) {
		return userFacade.saveUser(id, name, email, password, enabled );
		
	}
	
	@RequestMapping("/alter/{name}")
	public  ModelAndView alterUsuario(
			@PathVariable("name") final String name
			
			) {
		return userFacade.alterUser(name );
		
	}
	
	@RequestMapping("/delete/{id}")
	public @ResponseBody Boolean delete(@PathVariable("id") final Long id) {
		return userFacade.delete(id);
	}

}
