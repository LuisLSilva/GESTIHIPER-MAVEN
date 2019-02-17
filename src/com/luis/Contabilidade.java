package com.luis;

public class Contabilidade {
	private Cproduto produto;
	private int vendaMensal;
	

	public Contabilidade() {
		super();
	}

	public Contabilidade(Cproduto produto, int vendaMensal) {
		super();
		this.produto = produto;
		this.vendaMensal = vendaMensal;
	}
	
	public Cproduto getProduto() {
		return produto;
	}
	
	public void setProduto(Cproduto produto) {
		this.produto = produto;
	}
	
	public int getVendaMensal() {
		return vendaMensal;
	}
	
	public void setVendaMensal(int vendaMensal) {
		this.vendaMensal = vendaMensal;
	}
}
