package br.com.mfsdevsys.productapi.modules.supplier.model;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	private byte active;

	
	public Supplier() {
		
	}   
	public Supplier(Integer id, String name, byte active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}
	
	 public static Supplier of(SupplierRequest request) {
			
			var supplier = new Supplier();
			
			BeanUtils.copyProperties(request, supplier);
			return supplier;
			
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

	public byte isActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	

	public byte getActive() {
		return active;
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
		Supplier other = (Supplier) obj;
		return Objects.equals(id, other.id);
	}
	
}
