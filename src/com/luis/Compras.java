package com.luis;

public class Compras {
	Cclientes cliente;
	Cprodutos cprodutos;
	int quantidade;
	int mes;
	
	
	public Compras() {
		super();
	}

	public Compras(Cclientes cliente, Cprodutos cprodutos, int quantidade, int mes) {
		super();
		this.cliente = cliente;
		this.cprodutos = cprodutos;
		this.quantidade = quantidade;
		this.mes = mes;
	}

	public Cclientes getCliente() {
		return cliente;
	}
	
	public void setCliente(Cclientes cliente) {
		this.cliente = cliente;
	}
	
	public Cprodutos getCprodutos() {
		return cprodutos;
	}
	
	public void setCprodutos(Cprodutos cprodutos) {
		this.cprodutos = cprodutos;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Compras [cliente=" + cliente + ", cprodutos=" + cprodutos + ", quantidade=" + quantidade + ", mes="
				+ mes + "]";
	}
		
}
