package br.com.mfsdevsys.productapi.modules.category.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mfsdevsys.productapi.modules.category.model.Category;

public class CategoryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	@JsonProperty("meta_link")
	private String metaLink;
	
	private String description;
	private byte active;
	
	@JsonProperty("main_id")
	private Integer mainId;
	
	@JsonProperty("created_at")
	@JsonFormat(pattern="dd/MM/YYYY HH:mm:ss")
	private LocalDateTime createdAt ;
	
	private LocalDateTime modifiedAt;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Integer id, String name, String metaLink, String description, byte active,
			LocalDateTime createdAt, LocalDateTime modifiedAt) {

		this.id = id;
		this.name = name;
		this.metaLink = metaLink;
		this.description = description;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public CategoryDTO( Category entity ) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.metaLink = entity.getMetaLink();
		this.description = entity.getDescription();
		this.active = entity.getActive();
		this.createdAt = entity.getCreatedAt();
		this.modifiedAt = entity.getModifiedAt();
		
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



	public Integer getMainId() {
		return mainId;
	}



	public void setMainId(Integer mainId) {
		this.mainId = mainId;
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



	public void setModified_at(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
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
