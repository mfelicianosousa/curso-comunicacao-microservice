package br.com.mfsdevsys.productapi.modules.product.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="DESCRIPTION", columnDefinition="TEXT", nullable = true)
	private String description;
	
	@Column(name="META_LINK", nullable = false)
	private String meta_link;
	
	@Column(name="CODE", nullable = false)
	private String code;
	
	private byte emphasis ;
	
	@Column(name="CONTROL_STOCK", nullable = false)
	private byte control_stock;
	private Double sale_price;
	private Integer quantityAvailable;
	
	@Column(name="IMG_URL", nullable = false)
	private String imgURL;
	private byte active;
	/*
	@ManyToOne
	@JoinColumn(name="BRAND_ID", nullable= false)
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID", nullable= false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="LOJA_ID", nullable= true)
	private Loja loja;
	
	*/
	
	
	//, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")	
	
	@ManyToMany
	@JoinTable(name = "PRODUCT_CATEGORY", 
	  joinColumns = @JoinColumn(name="product_id"),
	  inverseJoinColumns = @JoinColumn(name="category_id"))
	Set<Category> categories = new HashSet<>();	
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="CREATED_AT", nullable = false)
	private LocalDateTime created_at ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="MODIFIED_AT", nullable = true)
	private LocalDateTime modified_at;
	
	@Column(name="DELETED_AT", nullable = true)
	private LocalDateTime deleted_at;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, String description, String meta_link, String code, byte emphasis,
			byte control_stock, Double sale_price, Integer quantityAvailable, byte active,String imgURL , LocalDateTime created_at, LocalDateTime modified_at,
			LocalDateTime deleted_at) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.meta_link = meta_link;
		this.code = code;
		this.emphasis = emphasis;
		this.control_stock = control_stock;
		this.sale_price = sale_price;
		this.quantityAvailable = quantityAvailable;
		this.active = active;
		this.imgURL = imgURL;
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


/*
	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


*/
	
	public Set<Category> getCategories() {
		return categories;
	}

	public byte isActive() {
		return active;
	}



	public void setActive(byte active) {
		this.active = active;
	}
	
	public String getImgURL() {
			return imgURL;
		}
	
		public void setImgURL(String imgURL) {
			this.imgURL = imgURL;
		}

	/*
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
*/
	public byte getActive() {
		return active;
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
