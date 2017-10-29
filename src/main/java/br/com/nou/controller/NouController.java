package br.com.nou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nou.controller.facade.NouFacade;

@Controller
@RequestMapping("/consulta")
public class NouController {

	@Autowired
	private NouFacade nouFacade;
	
	@RequestMapping("/pessoaFisica/{cpf}")
	public ModelAndView obterPessoaFisica(@PathVariable("cpf") final String cpf) {
		return nouFacade.obterPessoaFisica(cpf);
	}
	
	@RequestMapping("/pessoaJuridica/{cnpj}")
	public ModelAndView obterPessoaJuridica(@PathVariable("cnpj") final String cnpj) {
		return nouFacade.obterPessoaJuridica(cnpj);
	}
	
	@RequestMapping("/pessoaFisicaNome/{nome}")
	public ModelAndView obterPessoaFisicaPorNome(@PathVariable("nome") final String cpf) {
		return nouFacade.obterPessoaFisica(cpf);
	}
	
	
	@RequestMapping("/pessoaFisicaPorCpf/{cpf}")
	public ModelAndView obterPessoaFisicaPorCpf(@PathVariable("cpf") final String cpf) {
		return nouFacade.obterPessoaFisicaPorCpf(cpf);
	}
}
