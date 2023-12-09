package br.com.mfsdevsys.productapi.modules.loja.dto;

import org.springframework.beans.BeanUtils;

import br.com.mfsdevsys.productapi.modules.loja.model.Loja;

public class LojaResponse {

	private Integer id;
	private String name;
	private byte active;
	
	
	 public LojaResponse() {
	 }
	
	
    public LojaResponse(Integer id, String name, byte active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}

    
	public static LojaResponse of(Loja loja) {
		
		var response = new LojaResponse();
		
		BeanUtils.copyProperties(loja, response);
		
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
