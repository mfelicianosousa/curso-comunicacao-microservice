package br.com.mfsdevsys.productapi.modules.category.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CategoryRequest {
	
	private String name;
	private String description;
	
	@JsonProperty("meta_link")
	private String metaLink;
	
	private byte active;
		
	private LocalDateTime createdAt ;
	
	private LocalDateTime modifiedAt;
	
	@JsonProperty("main_id")
    private Integer mainId;
	
	public CategoryRequest() {
		
	}

	public CategoryRequest(String name, String description, String metaLink, byte active, 
			LocalDateTime createdAt, LocalDateTime modifiedAt, Integer mainId) {
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.mainId = mainId;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAat(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public Integer getMainId() {
		return mainId;
	}
	
	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryRequest other = (CategoryRequest) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
