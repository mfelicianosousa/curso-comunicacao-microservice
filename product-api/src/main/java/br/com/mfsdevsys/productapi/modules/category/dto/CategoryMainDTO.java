package br.com.mfsdevsys.productapi.modules.category.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.mfsdevsys.productapi.modules.category.model.CategoryMain;

public class CategoryMainDTO implements Serializable {
	
	private static final Long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String metaLink;
	private String description;
	private byte active;
	private LocalDateTime createdAt ;
	private LocalDateTime modifiedAt;
	
	
	public CategoryMainDTO() {
		
	}
	
	public CategoryMainDTO(Integer id, String name, String metaLink, String description,byte active,
			LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.id = id;
		this.name = name;
		this.metaLink = metaLink;
		this.description = description;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	public CategoryMainDTO( CategoryMain entity ) {
		
		id = entity.getId();
		name = entity.getName();
		metaLink = entity.getMetaLink();
		description = entity.getDescription();
		active = entity.getActive();
		createdAt = entity.getCreatedAt();
		modifiedAt = entity.getModifiedAt();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	
}
