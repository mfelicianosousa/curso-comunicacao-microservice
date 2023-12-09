package br.com.mfsdevsys.productapi.modules.supplier.dto;

import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.supplier.model.Supplier;

public class SupplierResponse {

	private Integer id;
	private String name;
	private byte active;
	
	
	 public SupplierResponse() {
	 }
	
	
    public SupplierResponse(Integer id, String name, byte active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}

    
	public static SupplierResponse of(Supplier supplier) {
		
		var response = new SupplierResponse();
		
		BeanUtils.copyProperties(supplier, response);
		
		return response;
		
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
