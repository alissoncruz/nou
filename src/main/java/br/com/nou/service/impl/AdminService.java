package br.com.nou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nou.entity.view.UsersDayAccessAmount;
import br.com.nou.repository.IAdminRepository;
import br.com.nou.service.IAdminService;

@Service("adminService")
public class AdminService implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;
	
	@Override
	public  List<UsersDayAccessAmount> getListAccess() {
		return adminRepository.getListAccess();
	};
}
