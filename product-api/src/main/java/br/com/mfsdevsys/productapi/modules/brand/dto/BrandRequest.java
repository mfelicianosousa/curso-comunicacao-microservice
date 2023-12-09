package br.com.mfsdevsys.productapi.modules.brand.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class BrandRequest {
	
	private String name;
	
	@JsonProperty("meta_link")
    private String metaLink;
	
	private byte active;
	
	public BrandRequest () {
		
	}
	
	

	public BrandRequest(String name, String metaLink, byte active) {
		this.name = name;
		this.metaLink = metaLink;
		this.active = active;
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
