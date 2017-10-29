package br.com.nou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.controller.facade.AdminFacade;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final static String LIST_ACCESS = "access-user/index"; 

	@Autowired
	private AdminFacade adminFacade;
	
	@RequestMapping("/listAccess")
	public ModelAndView getListAccess() {
		return adminFacade.getListAccess(LIST_ACCESS);
	}
	
	@RequestMapping("/allListAccess")
	public ModelAndView allListAccess() {
		return adminFacade.allListAcess(LIST_ACCESS);
	}
}
