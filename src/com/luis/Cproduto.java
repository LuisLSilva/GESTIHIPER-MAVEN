package com.luis;

public class Cproduto {
	private String idProdutos;
	private double preco;
	
	public Cproduto() {
		super();
	}
	
	public Cproduto(String idProdutos) {
		super();
		this.idProdutos = idProdutos;
	}
	
	public Cproduto(double preco) {
		super();
		this.preco = preco;
	}

	public Cproduto(String idProdutos, int preco) {
		super();
		this.idProdutos = idProdutos;
		this.preco = preco;
	}
	
	public String getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(String idProdutos) {
		this.idProdutos = idProdutos;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Cprodutos [idProdutos=" + idProdutos + ", preco=" + preco + "]";
	}


}