package br.com.mfsdevsys.productapi.modules.product.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mfsdevsys.productapi.modules.category.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.category.model.Category;
import br.com.mfsdevsys.productapi.modules.product.model.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private String metaLink;
	private String code;
	private byte emphasis ;
	private byte controlStock;
	private Double salePrice;
	private Integer quantityAvailable;
	private String imgURL;
	private byte active;
	
	@JsonProperty("created_at")
	@JsonFormat(pattern="dd/MM/YYYY HH:mm:ss")
	private LocalDateTime createdAt ;
	
	private LocalDateTime modifiedAt;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	
	public ProductDTO() {
		
	}
	
	
	public ProductDTO(Integer id, String name, String description, String metaLink, String code, byte emphasis,
			byte controlStock, Double salePrice, Integer quantityAvailable, String imgURL, byte active,
			LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.code = code;
		this.emphasis = emphasis;
		this.controlStock = controlStock;
		this.salePrice = salePrice;
		this.quantityAvailable = quantityAvailable;
		this.imgURL = imgURL;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;

	}


	public ProductDTO(Product entity, Set<Category> categories) {
		//this( entity );
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

	public String getMetaLink() {
		return metaLink;
	}

	public void setMetaLink(String metaLink) {
		this.metaLink = metaLink;
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

	public byte getControlStock() {
		return controlStock;
	}

	public void setControlStock(byte controlStock) {
		this.controlStock = controlStock;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
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

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	
}
