package com.luis;

public class Cproduto {
	private String idProduto;
	
	public Cproduto() {
		super();
	}
	
	public Cproduto(String idProduto) {
		super();
		this.idProduto = idProduto;
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public String toString() {
		return "Cproduto [idProduto=" + idProduto + "]";
	}

	


}
