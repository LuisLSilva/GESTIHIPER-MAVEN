package com.luis;

public class Contabilidade {
	Cprodutos produtos;
	int vendasMensais;
	

	public Contabilidade() {
		super();
	}

	public Contabilidade(Cprodutos produtos, int vendasMensais) {
		super();
		this.produtos = produtos;
		this.vendasMensais = vendasMensais;
	}
	
	public Cprodutos getProdutos() {
		return produtos;
	}
	public void setProdutos(Cprodutos produtos) {
		this.produtos = produtos;
	}
	public int getVendasMensais() {
		return vendasMensais;
	}
	public void setVendasMensais(int vendasMensais) {
		this.vendasMensais = vendasMensais;
	}


}
