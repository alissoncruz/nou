package br.com.nou.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Alisson
 */
@Entity
@Table(name="pessoa_juridica")
public class PessoaJuridicaEntity implements Serializable{
	

	
	private static final long serialVersionUID = 8249298985678075957L;

	@Id
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="ie")
	private String ie;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	
	

}
