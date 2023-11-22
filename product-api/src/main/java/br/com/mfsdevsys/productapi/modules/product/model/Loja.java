package br.com.mfsdevsys.productapi.modules.product.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="LOJAS")
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="lojas_sequence")
	@SequenceGenerator(name="lojas_sequence", sequenceName="lojas_seq", allocationSize = 1)
	private Integer id;

	@Column(name="NAME", length = 50, nullable = false)
	private String name;
	
	@Column(name="FANTASY", length = 50, nullable = true)
	private String fantasy;
	
	@Column(name="CNPJ", length = 18, nullable = true)
	private String cnpj;
	
	@Column(name="INSC_ESTADUAL", length = 15, nullable = true)
	private String insc_estadual;
	
	@Column(name="EMAIL", length = 60, nullable = true)
	private String email;
	
	@Column(name="PHONE", length = 15, nullable = true)
	private String phone;
	
	@Column(name="PHONE_CELULAR", length = 14, nullable = true)
	private String phone_celular;
	
	@Column(name="CEP", length = 9, nullable = true)
	private String cep;
	
	@Column(name="BAIRRO", length = 2, nullable = true)
	private String bairro;
	
	@Column(name="MUNICIPIO", length = 40, nullable = true)
	private String municipio;
	
	@Column(name="LOGRADOURO", length = 80, nullable = true)
	private String logradouro;
	
	@Column(name="NUMERO", length = 10, nullable = true)
	private String numero;
	
	@Column(name="COMPLEMENTO", length = 50, nullable = true)
	private String complemento;
	
	@Column(name="UF", length = 2, nullable = true)
	private String estado;
	
	private byte active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="CREATED_AT", nullable = false)
	private LocalDateTime created_at ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="MODIFIED_AT", nullable = true)
	private LocalDateTime modified_at;
	
	@Column(name="DELETED_AT", nullable = true)
	private LocalDateTime deleted_at;
	
	public Loja() {
		
	}
	
	public Loja(Integer id, String name, String fantasy, String cnpj) {
		this.id = id;
		this.name = name;
		this.fantasy = fantasy;
		this.cnpj = cnpj;
	}

	public Loja(Integer id, String name, String fantasy, String cnpj, String insc_estadual, String email, String phone,
			String phone_celular, String cep, String bairro, String municipio, String logradouro, String numero,
			String complemento, String estado, byte active) {
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
	
	

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}

	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(id, other.id);
	}	
	
}
