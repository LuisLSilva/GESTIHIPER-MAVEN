package com.luis;

public class Contabilidade {
	private Cproduto produtos;
	private int vendasMensais;
	

	public Contabilidade() {
		super();
	}

	public Contabilidade(Cproduto produtos, int vendasMensais) {
		super();
		this.produtos = produtos;
		this.vendasMensais = vendasMensais;
	}
	
	public Cproduto getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Cproduto produtos) {
		this.produtos = produtos;
	}
	
	public int getVendasMensais() {
		return vendasMensais;
	}
	
	public void setVendasMensais(int vendasMensais) {
		this.vendasMensais = vendasMensais;
	}


}
