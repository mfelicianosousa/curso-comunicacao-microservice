package br.com.mfsdevsys.productapi.modules.product.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.mfsdevsys.productapi.modules.product.model.Category;

public class CategoryDTO implements Serializable {
	
	private static final Long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String meta_link;
	private byte active;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Integer id, String name, String meta_link, byte active) {
		this.id = id;
		this.name = name;
		this.meta_link = meta_link;
		this.active = active;
	}
	
	public CategoryDTO( Category entity ) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.meta_link = entity.getMeta_link();
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

	public String getMeta_link() {
		return meta_link;
	}

	public void setMeta_link(String meta_link) {
		this.meta_link = meta_link;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
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
		CategoryDTO other = (CategoryDTO) obj;
		return Objects.equals(id, other.id);
	}	
	
}
