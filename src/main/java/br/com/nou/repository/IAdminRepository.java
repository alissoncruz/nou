package br.com.nou.repository;

import java.util.List;

import br.com.nou.entity.view.UsersDayAccessAmount;

public interface IAdminRepository {
	
	public List<UsersDayAccessAmount> getListAccess();
	
}
