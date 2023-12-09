package br.com.mfsdevsys.productapi.modules.category.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.category.dto.CategoryMainRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="categories_main")
@SequenceGenerator(name = "sequence_categories_main_id", sequenceName = "sequence_categories_main_id", allocationSize = 1, initialValue = 1)
public class CategoryMain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categories_main_id")
	private Integer id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description", nullable = true)
	private String description;
	
	@Column(name="meta_link", nullable = true)
	private String metaLink;

	@Column(name="ACTIVE", nullable = false)
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
	
	public CategoryMain() {
		
	}
	

	public CategoryMain(Integer id, String name, String description, String metaLink, byte active,
			LocalDateTime createdAt, LocalDateTime modifiedAt) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public static CategoryMain of(CategoryMainRequest request) {
		
		var categoryMain = new CategoryMain();
		
		BeanUtils.copyProperties(request, categoryMain);
		return categoryMain;
		
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
		CategoryMain other = (CategoryMain) obj;
		return Objects.equals(id, other.id);
	}

	
}

