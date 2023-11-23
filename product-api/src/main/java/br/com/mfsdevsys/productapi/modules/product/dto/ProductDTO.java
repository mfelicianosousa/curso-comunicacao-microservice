package br.com.mfsdevsys.productapi.modules.product.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.mfsdevsys.productapi.modules.product.model.Category;
import br.com.mfsdevsys.productapi.modules.product.model.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private String meta_link;
	private String code;
	private byte emphasis ;
	private byte control_stock;
	private Double sale_price;
	private Integer quantityAvailable;
	private String imgURL;
	private byte active;
	private LocalDateTime created_at ;
	private LocalDateTime modified_at;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	
	
	public ProductDTO() {
		
	}
	
	

	public ProductDTO(Integer id, String name, String description, String meta_link, String code, byte emphasis,
			byte control_stock, Double sale_price, Integer quantityAvailable, String imgURL, byte active,
			LocalDateTime created_at, LocalDateTime modified_at) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.meta_link = meta_link;
		this.code = code;
		this.emphasis = emphasis;
		this.control_stock = control_stock;
		this.sale_price = sale_price;
		this.quantityAvailable = quantityAvailable;
		this.imgURL = imgURL;
		this.active = active;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.meta_link = entity.getMeta_link();
		this.code = entity.getCode();
		this.emphasis = entity.getEmphasis();
		this.control_stock = entity.getControl_stock();
		this.sale_price = entity.getSale_price();
		this.quantityAvailable = entity.getQuantityAvailable();
		this.imgURL = entity.getImgURL();
		this.active = entity.getActive();
		this.created_at = entity.getCreated_at();
		this.modified_at = entity.getModified_at();
	}
	
	public ProductDTO(Product entity, Set<Category> categories) {
		this( entity );
		categories.forEach(category -> this.categories.add(new CategoryDTO(category)) );
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



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public byte getEmphasis() {
		return emphasis;
	}



	public void setEmphasis(byte emphasis) {
		this.emphasis = emphasis;
	}



	public byte getControl_stock() {
		return control_stock;
	}



	public void setControl_stock(byte control_stock) {
		this.control_stock = control_stock;
	}



	public Double getSale_price() {
		return sale_price;
	}



	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}



	public Integer getQuantityAvailable() {
		return quantityAvailable;
	}



	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}



	public String getImgURL() {
		return imgURL;
	}



	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
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



	public LocalDateTime getModified_at() {
		return modified_at;
	}



	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}



	public List<CategoryDTO> getCategories() {
		return categories;
	}



	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	
    

	
	
}
