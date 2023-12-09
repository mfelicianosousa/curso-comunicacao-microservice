package br.com.mfsdevsys.productapi.modules.category.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mfsdevsys.productapi.modules.category.model.Category;

public class CategoryResponse {

	private Integer id;
	
	private String name;
	
	private String description;
	
	private byte active;
	
	@JsonProperty("meta_link")
	private String metaLink;
	
	@JsonProperty("created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdAt ;
	
	@JsonProperty("CategoryMain")
	private CategoryMainResponse categoryMain;
	
	public CategoryResponse() {
		
	}
	
	public CategoryResponse(Integer id, String name, String description, byte active, String metaLink,
			LocalDateTime createdAt, CategoryMainResponse categoryMain) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
		this.metaLink = metaLink;
		this.createdAt = createdAt;
		this.categoryMain = categoryMain;
	}

	/*
	public static CategoryResponse of(Category category) {
		
		var response = new CategoryResponse();
		
		BeanUtils.copyProperties(category, response);
		
		return response;
		
	}
	*/
	public static CategoryResponse of(Category category) {

		 return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getDescription(),
            category.getActive(),
            category.getMetaLink(),
            category.getCreatedAt(),
            CategoryMainResponse.of( category.getCategoryMain())
      );
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

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getMetaLink() {
		return metaLink;
	}

	public void setMetaLink(String metaLink) {
		this.metaLink = metaLink;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public CategoryMainResponse getCategoryMain() {
		return categoryMain;
	}

	public void setCategoryMain(CategoryMainResponse categoryMain) {
		this.categoryMain = categoryMain;
	}
	

    /*
	public static CategoryResponse of(Category category) {
		
		return new CategoryResponse(
				category.getId(),
				category.getName(),
				category.getDescription(),
				category.getMetaLink(),
				category.getActive(),
				category.getCreatedAt(),
				categoryMain(CategoryMainResponse.of(category.getCategoryMain()));	
				);
		
	}
*/


}
