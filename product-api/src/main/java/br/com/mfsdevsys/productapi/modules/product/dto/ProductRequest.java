package br.com.mfsdevsys.productapi.modules.product.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductRequest {

	private String name;
	private String description;
	
	@JsonProperty("meta_link")
	private String metaLink;
	private String code;
	private byte emphasis ;
	
	@JsonProperty("control_stock")
	private byte controlStock;
	
	@JsonProperty("sale_price")
	private Double salePrice;
	
	@JsonProperty("quantity_available")
	private Integer quantityAvailable;
	private String imgURL;
	private byte active;
	
	@JsonProperty("created_at")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss ")
	private LocalDateTime createdAt ;
	private LocalDateTime modifiedAt;
	
	@JsonProperty("category_id")
	private Integer categoryId;
	
	@JsonProperty("supplier_id")
	private Integer supplierId;
	
	public ProductRequest() {
		
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	

}
