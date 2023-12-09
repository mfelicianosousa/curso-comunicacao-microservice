package br.com.mfsdevsys.productapi.modules.category.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="CATEGORIES")
@SequenceGenerator(name = "sequence_category_id", sequenceName = "sequence_category_id", allocationSize = 1, initialValue = 1)
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_category_id")
	private Integer id;
	
	@Column(name="name", nullable = false, length=50)
	private String name;
	
	@Column(name="description", nullable = true, length=200)
	private String description;
	
	
	@Column(name="meta_link", nullable = true, length=60)
	private String metaLink;

	@Column(name="active", nullable = false)
	private byte active;
	

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
	
	@ManyToOne
	@JoinColumn(name = "main_id", nullable = false, foreignKey = @ForeignKey(name = "fk_categoryMain"))
	private CategoryMain categoryMain;
	
		
	public Category() {
		
	}
	
	
	
	public Category(Integer id, String name, String description, String metaLink, byte active, LocalDateTime createdAt,
			LocalDateTime modifiedAt, CategoryMain categoryMain) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.categoryMain = categoryMain;
	}

	public Category(String name, String description, String metaLink, byte active, LocalDateTime createdAt,
			LocalDateTime modifiedAt, CategoryMain categoryMain) {
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.categoryMain = categoryMain;
	}


/*
	public static Category of(CategoryRequest request) {
			
			var category = new Category();
			
			BeanUtils.copyProperties(request, category);
			return category;
			
	}
	*/
	 
	 public static Category of(CategoryRequest request, CategoryMain categoryMain) {
		 
		 return new Category(
				 request.getName(),
				 request.getDescription(),
				 request.getMetaLink(),
				 request.getActive(),
				 request.getCreatedAt(),
				 request.getModifiedAt(),
				 categoryMain
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

	
	public CategoryMain getCategoryMain() {
		return categoryMain;
	}
	
	public void setCategoryMain(CategoryMain categoryMain) {
		this.categoryMain = categoryMain;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	
}

