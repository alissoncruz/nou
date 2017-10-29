package br.com.nou.controller.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.service.INouService;

@Service("nouFacade")
public class NouFacade {

	@Autowired
	private INouService nouService;
	
	public ModelAndView obterPessoaFisica(final String valor) {
		return nouService.obterPessoa(valor);
	}

	public ModelAndView obterPessoaJuridica(final String cnpj) {
		final ModelAndView model = new ModelAndView("lista");
		model.addObject("pessoaFisica", nouService.obterPessoaJuridica(cnpj) );
		model.addObject("user", "master");
		return model;
	}
	
	public ModelAndView obterPessoaFisicaPorCpf(final String cpf) {
		final ModelAndView model = new ModelAndView("lista");
		
		if(nouService.obterPessoaFisicaPorCpf(cpf) == null) {
			model.addObject("mensagem", "Nenhum resultado encontrado!");	
		}
		model.addObject("pessoaFisica", nouService.obterPessoaFisicaPorCpf(cpf) );
		model.addObject("user", "master");
		return model;
	}
	
}
