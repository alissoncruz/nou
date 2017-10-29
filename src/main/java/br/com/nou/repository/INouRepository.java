package br.com.nou.repository;

import java.util.List;

import br.com.nou.entity.PessoaFisicaEntity;
import br.com.nou.entity.PessoaJuridicaEntity;

public interface INouRepository {
	
	PessoaFisicaEntity obterPessoaFisicaPorCpf(final String cpf);

	PessoaJuridicaEntity obterPessoaJuridica(final String cnpj);

	List<PessoaFisicaEntity> obterPessoaFisicaPorNome(final String valor);

	Boolean saveSearch(); 

}
