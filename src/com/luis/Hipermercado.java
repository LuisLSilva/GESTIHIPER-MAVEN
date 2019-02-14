package com.luis;

public class Hipermercado {
	Cclientes cclientes;
	Cprodutos cprodutos;
	Contabilidade contabilidade;
	
	
	public Hipermercado() {
		super();
	}

	public Hipermercado(Cclientes cclientes, Cprodutos cprodutos, Contabilidade contabilidade) {
		super();
		this.cclientes = cclientes;
		this.cprodutos = cprodutos;
		this.contabilidade = contabilidade;
	}

	public Cclientes getCclientes() {
		return cclientes;
	}
	
	public void setCclientes(Cclientes cclientes) {
		this.cclientes = cclientes;
	}
	public Cprodutos getCprodutos() {
		return cprodutos;
	}
	
	public void setCprodutos(Cprodutos cprodutos) {
		this.cprodutos = cprodutos;
	}
	
	public Contabilidade getContabilidade() {
		return contabilidade;
	}
	
	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	@Override
	public String toString() {
		return "Hipermercado [cclientes=" + cclientes + "]";
	}


	
}
