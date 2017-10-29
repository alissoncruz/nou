package br.com.nou.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nou.entity.UsersDayAccess;
import br.com.nou.entity.view.UsersDayAccessAmount;
import br.com.nou.repository.IAdminRepository;

@Repository
public class AdminRepository implements IAdminRepository{
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired
	public AdminRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UsersDayAccessAmount> getListAccess() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsersDayAccessAmount.class);
		
		return criteria.list();
	}

}
