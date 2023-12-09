package br.com.mfsdevsys.productapi.modules.product.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.mfsdevsys.productapi.modules.category.model.Category;
import br.com.mfsdevsys.productapi.modules.category.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductRequest;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductResponse;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;
import br.com.mfsdevsys.productapi.modules.supplier.model.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description", columnDefinition="TEXT", nullable = true)
	private String description;
	
	@Column(name="meta_link", nullable = false)
	private String metaLink;
	
	@Column(name="code", nullable = false)
	private String code;
	
	private byte emphasis ;
	
	@Column(name="control_stock", nullable = false)
	private byte controlStock;
	
	@Column(name="sale_price")
	private Double salePrice;
	
	@Column(name="quantity_available")
	private Integer quantityAvailable;
	
	@Column(name="img_url", nullable = false)
	private String imgURL;
	private byte active;
	
	
	/*
	@ManyToOne
	@JoinColumn(name="BRAND_ID", nullable= false)
	private Brand brand;
	
	
	
	@ManyToOne
	@JoinColumn(name="LOJA_ID", nullable= true)
	private Loja loja;
	
	*/
	
	
	//, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")	
	
	@ManyToOne
	@JoinColumn(name="supplier_id", nullable = false,  foreignKey = @ForeignKey(name = "fk_supplier"))
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false,  foreignKey = @ForeignKey(name = "fk_category"))
	private Category category;
	

	@ManyToMany
	@JoinTable(name = "product_category", 
	  joinColumns = {@JoinColumn( 
			            foreignKey = @ForeignKey(name = "fk_product"),
	                    referencedColumnName="id",
	                    name="product_id")},
	  
	  inverseJoinColumns = {@JoinColumn(
			                  foreignKey = @ForeignKey(name = "fk_category"),
                              referencedColumnName="id",
                	           name="category_id")
	  })
	Set<Category> categories = new HashSet<>();	
	

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="modified_at", nullable = true, updatable = true)
	private LocalDateTime modifiedAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, String description, String metaLink, String code, byte emphasis,
			byte controlStock, Double salePrice, Integer quantityAvailable, String imgURL, byte active,
			Supplier supplier, Category category, LocalDateTime createdAt, LocalDateTime modifiedAt) {
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
		this.supplier = supplier;
		this.category = category;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	public static Product of(ProductRequest request,
			Supplier supplier,
			Category category) {
		
		Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setMetaLink(request.getMetaLink());
        product.setCode(request.getCode());
        product.setEmphasis(request.getEmphasis());
        product.setControlStock(request.getControlStock());
        product.setSalePrice(request.getSalePrice());
        product.setQuantityAvailable(request.getQuantityAvailable());
        product.setImgURL(request.getImgURL());
        product.setActive(request.getActive());
        product.setCreatedAt(request.getCreatedAt());
        product.setModifiedAt(request.getModifiedAt());
        product.setSupplier( supplier);
        product.setCategory( category) ;
   
        return product;
		
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	
}
