package br.com.nou.controller.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.service.IAdminService;

@Service("adminFacade")
public class AdminFacade {

	@Autowired
	private IAdminService adminService;
	
	public ModelAndView getListAccess(final String jsp) {
		ModelAndView model = new ModelAndView(jsp);
		model.addObject("list", adminService.getListAccess());
		return model;
	}
	
	public ModelAndView allListAcess(final String jsp) {
		ModelAndView model = new ModelAndView(jsp);
		model.addObject("list", adminService.getListAccess());
		return model;
	}
}
