package br.com.mfsdevsys.productapi.modules.brand.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mfsdevsys.productapi.modules.brand.model.Brand;

public class BrandResponse {

	private Integer id;
	private String name;
	
	@JsonProperty("meta_link")
	private String metaLink;
	private byte active;
	
	
	 public BrandResponse() {
	 }
	
	
    public BrandResponse(Integer id, String name, byte active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}

    
	public static BrandResponse of(Brand brand) {
		
		var response = new BrandResponse();
		
		BeanUtils.copyProperties(brand, response);
		
		return response;
		
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
