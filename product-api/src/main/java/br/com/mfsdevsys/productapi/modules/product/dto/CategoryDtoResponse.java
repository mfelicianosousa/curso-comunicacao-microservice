package br.com.mfsdevsys.productapi.modules.product.dto;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.product.model.Category;
import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.model.Loja;

public class CategoryDtoResponse {

	private Integer id;
	private String name;
	private String description;
	private String meta_link;
	private byte active;
	private CategoryMain categoryMain;
	private Loja loja;
	private LocalDateTime created_at ;
	private LocalDateTime modified_at;
	private LocalDateTime deleted_at;
	
    public static CategoryDtoResponse of(Category category) {
		
		var response = new CategoryDtoResponse();
		
		BeanUtils.copyProperties(category, response);
		
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
	public CategoryMain getCategoryMain() {
		return categoryMain;
	}
	public void setCategoryMain(CategoryMain categoryMain) {
		this.categoryMain = categoryMain;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getModified_at() {
		return modified_at;
	}
	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}
	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}
}
