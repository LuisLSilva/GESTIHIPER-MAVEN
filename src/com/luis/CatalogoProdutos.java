package com.luis;

public class CatalogoProdutos {

	private String idProdutos;
	private String prodName;
	
	
	public CatalogoProdutos(String idProdutos, String prodName) {
		super();
		this.idProdutos = idProdutos;
		this.prodName = prodName;
	}
	public String getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(String idProdutos) {
		this.idProdutos = idProdutos;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	

}
