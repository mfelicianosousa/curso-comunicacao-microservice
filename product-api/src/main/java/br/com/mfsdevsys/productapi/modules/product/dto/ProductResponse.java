package br.com.mfsdevsys.productapi.modules.product.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.product.model.Product;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;


public class ProductResponse {

	private Integer id;
	private String name;
	private String description;
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
		
	private SupplierResponse supplier;
	private CategoryResponse category;
	
	public ProductResponse() {
		
	}
	
	
    public ProductResponse(Integer id, String name, String description, String metaLink, String code, byte emphasis,
			byte controlStock, Double salePrice, Integer quantityAvailable, String imgURL, byte active,
			LocalDateTime createdAt, LocalDateTime modifiedAt, SupplierResponse supplier, CategoryResponse category) {
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
		this.supplier = supplier;
		this.category = category;
	}



	public static ProductResponse of(Product product) {

		 return new ProductResponse(
             product.getId(),
             product.getName(),
             product.getDescription(),
             product.getMetaLink(),
             product.getCode(),
             product.getEmphasis(),
             product.getControlStock(),
             product.getSalePrice(),
             product.getQuantityAvailable(),
             product.getImgURL(),
             product.getActive(),
             product.getCreatedAt(),
             product.getModifiedAt(),
             SupplierResponse.of( product.getSupplier()),
             CategoryResponse.of( product.getCategory())

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

	public SupplierResponse getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierResponse supplier) {
		this.supplier = supplier;
	}

	public CategoryResponse getCategory() {
		return category;
	}

	public void setCategory(CategoryResponse category) {
		this.category = category;
	}

	
	
	

	
    	
}
