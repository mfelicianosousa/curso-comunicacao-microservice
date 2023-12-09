package br.com.mfsdevsys.productapi.modules.category.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CategoryMainRequest {
	
	private String name;
	private String description;
	
	@JsonProperty("meta_link")
	private String metaLink;
	
	private byte active;
		
	@JsonProperty("created_at")
	private LocalDateTime createdAat ;
	
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
	
	public CategoryMainRequest() {
		
	}

	public CategoryMainRequest(String name, String description, String metaLink, byte active,
			LocalDateTime createdAat, LocalDateTime modifiedAt) {
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAat = createdAat;
		this.modifiedAt = modifiedAt;
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

	public LocalDateTime getCreatedAat() {
		return createdAat;
	}

	public void setCreatedAat(LocalDateTime createdAat) {
		this.createdAat = createdAat;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
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
		CategoryMainRequest other = (CategoryMainRequest) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
