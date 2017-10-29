package br.com.nou.service;

import java.util.List;

import br.com.nou.entity.view.UsersDayAccessAmount;

public interface IAdminService {

	public  List<UsersDayAccessAmount> getListAccess();
}
