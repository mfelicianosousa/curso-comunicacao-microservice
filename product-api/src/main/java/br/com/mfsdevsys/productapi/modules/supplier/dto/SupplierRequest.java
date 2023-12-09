package br.com.mfsdevsys.productapi.modules.supplier.dto;

public class SupplierRequest {
	
	private String name;
	private byte active;
	
	public SupplierRequest () {
		
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
