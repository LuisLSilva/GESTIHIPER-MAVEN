package com.luis;

public class Cprodutos {
	String idProdutos;
	double preco;
	
	public Cprodutos() {
		super();
	}
	
	public Cprodutos(String idProdutos, int preco) {
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
