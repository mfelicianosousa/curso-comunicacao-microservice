package br.com.mfsdevsys.productapi.modules.loja.dto;

import jakarta.persistence.Column;

public class LojaRequest {
	
	private String name;
    private String metaLink;
	
	private byte active;
	
	public LojaRequest () {
		
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
