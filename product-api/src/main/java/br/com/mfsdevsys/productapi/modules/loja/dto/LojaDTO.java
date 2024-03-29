package br.com.mfsdevsys.productapi.modules.loja.dto;

import java.io.Serializable;

import br.com.mfsdevsys.productapi.modules.loja.model.Loja;

public class LojaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String name;
	private String fantasy;
	private String cnpj;
	private String insc_estadual;
	private String email;
	private String phone;
	private String phone_celular;
	private String cep;
	private String bairro;
	private String municipio;
	private String logradouro;
	private String numero;
	private String complemento;
	private String estado;
	private byte active;
	
	
	public LojaDTO() {
		
	}
	
	
	public LojaDTO(Integer id, String name, String fantasy, String cnpj, String insc_estadual, String email,
			String phone, String phone_celular, String cep, String bairro, String municipio, String logradouro,
			String numero, String complemento, String estado, byte active) {
		super();
		this.id = id;
		this.name = name;
		this.fantasy = fantasy;
		this.cnpj = cnpj;
		this.insc_estadual = insc_estadual;
		this.email = email;
		this.phone = phone;
		this.phone_celular = phone_celular;
		this.cep = cep;
		this.bairro = bairro;
		this.municipio = municipio;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.estado = estado;
		this.active = active;
	}


	public LojaDTO(Loja entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.fantasy = entity.getFantasy();
		this.cnpj = entity.getCnpj();
		this.insc_estadual = entity.getInsc_estadual();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.phone_celular = entity.getPhone_celular();
		this.cep = entity.getCep();
		this.bairro = entity.getBairro();
		this.municipio = entity.getMunicipio();
		this.logradouro = entity.getLogradouro();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();
		this.estado = entity.getEstado();
		this.active = entity.getActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFantasy() {
		return fantasy;
	}

	public void setFantasy(String fantasy) {
		this.fantasy = fantasy;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInsc_estadual() {
		return insc_estadual;
	}

	public void setInsc_estadual(String insc_estadual) {
		this.insc_estadual = insc_estadual;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone_celular() {
		return phone_celular;
	}

	public void setPhone_celular(String phone_celular) {
		this.phone_celular = phone_celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

}
