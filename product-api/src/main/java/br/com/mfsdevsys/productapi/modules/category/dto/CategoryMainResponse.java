package br.com.mfsdevsys.productapi.modules.category.dto;

import java.time.LocalDateTime;

import br.com.mfsdevsys.productapi.modules.category.model.CategoryMain;

public class CategoryMainResponse {

	private Integer id;
	private String name;
	private String description;
	private String meta_link;
	private byte active;
	private LocalDateTime created_at ;
	
	//private CategoryMainResponse categoryMain;
	
	public CategoryMainResponse() {
		
	}
	
	
	
    public CategoryMainResponse(Integer id, String name, String description, String meta_link, byte active,
			LocalDateTime created_at) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.meta_link = meta_link;
		this.active = active;
		this.created_at = created_at;
		
	}


    /*

	public static CategoryResponse of(Category category) {
		
		var response = new CategoryResponse();
		
		BeanUtils.copyProperties(category, response);
		
		return response;
		
	}
	*/

	public static CategoryMainResponse of(CategoryMain category) {
		
		return new CategoryMainResponse(
				category.getId(),
				category.getName(),
				category.getDescription(),
				category.getMetaLink(),
				category.getActive(),
				category.getCreatedAt()
					
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

	
	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	

    	
}
