package br.com.mfsdevsys.productapi.modules.brand.dto;

import java.io.Serializable;

import br.com.mfsdevsys.productapi.modules.brand.model.Brand;

public class BrandDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String metaLink;
	private byte active;
	
	public BrandDTO() {
		
	}
	
	public BrandDTO(Integer id, String name, String metaLink, byte active) {
		this.id = id;
		this.name = name;
		this.metaLink = metaLink;
		this.active = active;
	}
	
	public BrandDTO( Brand entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.metaLink = entity.getMetaLink();
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

	public String getMetaLink() {
		return metaLink;
	}

	public void setMetaLink(String metaLink) {
		this.metaLink = metaLink;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
}
