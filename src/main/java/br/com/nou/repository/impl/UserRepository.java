package br.com.nou.repository.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nou.entity.UserEntity;
import br.com.nou.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{
	
	final static Logger logger = Logger.getLogger(UserRepository.class);
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired 
	public UserRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserEntity> obterUsuarios() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		return criteria.list();
	}


	@Override
	@Transactional
	public boolean salvarUsuario(final UserEntity entity) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.save(entity);
			session.flush();
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}
	


	@Override
	@Transactional
	public boolean deletarUsari(final String name) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("name",name));
		criteria.setMaxResults(1);
		UserEntity usuario = new  UserEntity();
		usuario  = (UserEntity) criteria.uniqueResult();
		try {
			session.delete(usuario);
			session.flush();
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}

	
	
	@Override
	@Transactional
	public UserEntity editarUsuario(final UserEntity usuario) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("name",usuario.getName()));
		criteria.setMaxResults(1);
		UserEntity entity = new  UserEntity();
		entity  = (UserEntity) criteria.uniqueResult();
		try {
			session.saveOrUpdate(usuario);
			session.flush();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		return entity;
	}


	@Override
	@Transactional
	public Boolean saveUser(final UserEntity entity) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			if(getUser(entity.getId()) ==null) {
				System.out.println("usuario novo");
				session.save(entity);	
			} else {
				session.clear();
				System.out.println("usuario já existe");
				session.update(entity);
			}				
			session.flush();
		} catch (Exception e) {
			logger.error(e);
          return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public boolean alterUser(final UserEntity usuario) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(usuario);
			session.flush();
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}
	
	
	
	@Override
	@Transactional
	public Boolean delete(final Long id) {
		final Session session = sessionFactory.getCurrentSession();
		final  Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("id",id));
		criteria.setMaxResults(1);
		UserEntity entity =new UserEntity();
		entity=(UserEntity) criteria.uniqueResult();
		try {
			if(entity != null) {
				session.delete(entity);	
				session.flush();
					
			}else {
				return false;
				}
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}
	
	/**
	 * return UserEntity
	 */
	@Override
	@Transactional
	public UserEntity getUser(final Long id) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("id",id));
		criteria.setMaxResults(1);
		UserEntity entity = new  UserEntity();
		entity  = (UserEntity) criteria.uniqueResult();
		return entity;
	}
	
	@Override
	@Transactional
	public UserEntity getUser(final String name) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("name",name));
		criteria.setMaxResults(1);
		UserEntity entity = new  UserEntity();
		entity  = (UserEntity) criteria.uniqueResult();
		return entity;
	}


	@Override
	@Transactional
	public UserEntity getUserByName(UserEntity user) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("name",user.getName()));
		criteria.setMaxResults(1);
		UserEntity entity = new  UserEntity();
		entity  = (UserEntity) criteria.uniqueResult();
		return entity;
	}


	@Override
	@Transactional
	public UserEntity getUserByNamePassword(final UserEntity user) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("name",user.getName()));
		criteria.add(Restrictions.eq("password",user.getPassword()));
		criteria.setMaxResults(1);
		UserEntity entity = new  UserEntity();
		entity  = (UserEntity) criteria.uniqueResult();
		return entity;
	}
}
