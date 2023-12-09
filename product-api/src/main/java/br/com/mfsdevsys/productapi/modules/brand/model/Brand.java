package br.com.mfsdevsys.productapi.modules.brand.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.brand.dto.BrandRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="BRANDS")
@SequenceGenerator(name = "sequence_brand_id", sequenceName = "sequence_brand_id", allocationSize = 1, initialValue = 1)
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_brand_id")
	private Integer id;

	@Column(name="NAME", length = 50, nullable = false)
	private String name;
	
	@Column(name="meta_link", length = 60,nullable = false)
	private String metaLink;
	
	@Column(name="active", nullable = false)
	private byte active;
	
	//@ManyToOne
	//@JoinColumn(name="LOJA_ID", nullable= true)
	//private Loja loja;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="create_at", nullable = false)
	private LocalDateTime createdAt ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="modified_at", nullable = true)
	private LocalDateTime modifiedAt;
	
		
	public Brand() {
		
	}
	
	public Brand(Integer id, String name, String metaLink, byte active) {
		this.id = id;
		this.name = name;
		this.metaLink = metaLink;
		this.active = active;
	}

	public Brand(Integer id, String name, String metaLink, byte active, LocalDateTime createdAt,
			LocalDateTime modifiedAt) {
		super();
		this.id = id;
		this.name = name;
		this.metaLink = metaLink;
		this.active = active;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;

	}
	public static Brand of(BrandRequest request) {
		
		var brand = new Brand();
		
		BeanUtils.copyProperties(request, brand);
		return brand;
		
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

	public String getMetaLink() {
		return metaLink;
	}

	public void setMetaLink(String metaLink) {
		this.metaLink = metaLink;
	}

	public byte isActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	public byte getActive() {
		return active;
	}

	
/*
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

*/
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(id, other.id);
	}

	
}

