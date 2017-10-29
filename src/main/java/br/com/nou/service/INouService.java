package br.com.nou.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import br.com.nou.entity.PessoaFisicaEntity;
import br.com.nou.entity.PessoaJuridicaEntity;

public interface INouService {


	PessoaJuridicaEntity obterPessoaJuridica(final String cnpj);

	ModelAndView obterPessoa(final String valor);

	PessoaFisicaEntity obterPessoaFisicaPorCpf(final String cpf);
	
}
