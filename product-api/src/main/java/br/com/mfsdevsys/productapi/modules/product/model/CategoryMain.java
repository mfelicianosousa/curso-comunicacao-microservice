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
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIES_MAIN")
public class CategoryMain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="DESCRIPTION", nullable = true)
	private String description;
	
	@Column(name="META_LINK", nullable = true)
	private String meta_link;

	@Column(name="ACTIVE", nullable = false)
	private byte active;
	
	@ManyToOne
	@JoinColumn(name="LOJA_ID", nullable= true)
	private Loja loja;
	
	
	private LocalDateTime created_at ;
	private LocalDateTime modified_at;
	private LocalDateTime deleted_at;
	
	public CategoryMain() {
		
	}
	
	
	
	public CategoryMain(Integer id, String name, String description, String meta_link) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.meta_link = meta_link;	
	}
	



	public CategoryMain(Integer id, String name, String description, String meta_link, byte active, Loja loja,
			LocalDateTime created_at, LocalDateTime modified_at, LocalDateTime deleted_at) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		CategoryMain other = (CategoryMain) obj;
		return Objects.equals(id, other.id);
	}

	
}

