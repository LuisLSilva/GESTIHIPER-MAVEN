package com.luis;

public class Cproduto {
	private String idProduto;
	private double preco;
	
	public Cproduto() {
		super();
	}
	
	public Cproduto(String idProduto) {
		super();
		this.idProduto = idProduto;
	}
	
	public Cproduto(double preco) {
		super();
		this.preco = preco;
	}

	public Cproduto(String idProduto, int preco) {
		super();
		this.idProduto = idProduto;
		this.preco = preco;
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Cprodutos [idProduto=" + idProduto + ", preco=" + preco + "]";
	}


}
