package br.com.mfsdevsys.productapi.modules.product.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="BRANDS")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="brands_sequence")
	@SequenceGenerator(name="brands_sequence", sequenceName="brands_seq", allocationSize = 1)
	private Integer id;

	@Column(name="NAME", length = 50, nullable = false)
	private String name;
	
	@Column(name="META_LINK", length = 60,nullable = false)
	private String meta_link;
	
	@Column(name="ACTIVE", nullable = false)
	private byte active;
	
	@ManyToOne
	@JoinColumn(name="LOJA_ID", nullable= true)
	private Loja loja;
	
	@Column(name="CREATED_AT", nullable = true)
	private LocalDateTime created_at ;
	
	@Column(name="MODIFIED_AT", nullable = true)
	private LocalDateTime modified_at;
	
	@Column(name="DELETED_AT", nullable = true)
	private LocalDateTime deleted_at;
	
	public Brand() {
		
	}
	
	public Brand(Integer id, String name, String meta_link, byte active) {
		this.id = id;
		this.name = name;
		this.meta_link = meta_link;
		this.active = active;
	}
	

	public Brand(Integer id, String name, String meta_link, byte active, Loja loja, LocalDateTime created_at,
			LocalDateTime modified_at, LocalDateTime deleted_at) {

		this.id = id;
		this.name = name;
		this.meta_link = meta_link;
		this.active = active;
		this.loja = loja;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.deleted_at = deleted_at;
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

	public String getMeta_link() {
		return meta_link;
	}

	public void setMeta_link(String meta_link) {
		this.meta_link = meta_link;
	}

	public byte isActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	public byte getActive() {
		return active;
	}

	

	public Loja getLoja() {
		return loja;
	}



	public void setLoja(Loja loja) {
		this.loja = loja;
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
		Brand other = (Brand) obj;
		return Objects.equals(id, other.id);
	}

	
}

