package br.com.nou.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.controller.facade.NouFacade;
import br.com.nou.service.security.MyAuthenticationProvider;
import br.com.nou.service.security.MyAuthenticationToken;

@Controller
//@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private NouFacade nouFacade;
	
	@RequestMapping("/login")
	public String obterBanco(){				
		return "login";		
	}
	
	@RequestMapping("/inicio")
	public String obterLogin(){
		return "index";
	}
	
	@RequestMapping("/index")
	public ModelAndView obterMenu(){
		final ModelAndView model = new ModelAndView("index");
		model.addObject("user", "master");
		return model;
	}
	
	@RequestMapping("/")
	public ModelAndView obterIndex(){
		final ModelAndView model = new ModelAndView("index");
		model.addObject("user", "master");
		return model;
	}

}
