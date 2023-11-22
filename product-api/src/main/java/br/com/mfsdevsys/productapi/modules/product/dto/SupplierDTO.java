package br.com.mfsdevsys.productapi.modules.product.dto;

import java.io.Serializable;

import br.com.mfsdevsys.productapi.modules.product.model.Supplier;

public class SupplierDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private byte active;
	

	public SupplierDTO() {
		
	}   
	public SupplierDTO(Integer id, String name, byte active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}
	
	public SupplierDTO( Supplier entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.active = entity.getActive();
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
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}

	
	
}