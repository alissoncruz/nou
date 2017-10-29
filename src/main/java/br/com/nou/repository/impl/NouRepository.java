package br.com.nou.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nou.entity.PessoaFisicaEntity;
import br.com.nou.entity.PessoaJuridicaEntity;
import br.com.nou.entity.UsersDayAccess;
import br.com.nou.repository.INouRepository;

/**
 * 
 * @author Alisson Cruz
 *
 */

@Repository
public class NouRepository implements INouRepository{
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired 
	public NouRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public PessoaFisicaEntity obterPessoaFisicaPorCpf(final String cpf) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(PessoaFisicaEntity.class);
		criteria.add(Restrictions.eq("cpf",cpf));
		criteria.setMaxResults(1);
		PessoaFisicaEntity e = new PessoaFisicaEntity();
		e = (PessoaFisicaEntity) criteria.uniqueResult();
		saveSearch();
		return e;
	}

	@Override
	@Transactional
	public PessoaJuridicaEntity obterPessoaJuridica(String cnpj) {
		// TODO PessoaJuridica
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(PessoaJuridicaEntity.class);
		return (PessoaJuridicaEntity) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PessoaFisicaEntity> obterPessoaFisicaPorNome(final String valor) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(PessoaFisicaEntity.class);
		criteria.setMaxResults(1500);
		criteria.add(Restrictions.like("nome",valor+"%").ignoreCase());
		return criteria.list();
	}
	
	@Override
	@Transactional
	public Boolean saveSearch() {
		final Session session = sessionFactory.getCurrentSession();
		UsersDayAccess accessSearch = new UsersDayAccess();
		accessSearch.setDate(new Date());
		accessSearch.setUser("master");
		accessSearch.setAmount(1);
		try {
			session.save(accessSearch);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	
}
