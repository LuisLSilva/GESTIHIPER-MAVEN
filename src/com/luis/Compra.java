package com.luis;

public class Compra {
	private Ccliente clientes;
	private Cproduto cprodutos;
	private int quantidade;
	private int mes;
	private String promo;
	
	public Ccliente getClientes() {
		return clientes;
	}
	
	public void setClientes(Ccliente clientes) {
		this.clientes = clientes;
	}
	
	public Cproduto getCprodutos() {
		return cprodutos;
	}
	
	public void setCprodutos(Cproduto cprodutos) {
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
	
	public String getPromo() {
		return promo;
	}
	
	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	@Override
	public String toString() {
		return "Compra [clientes=" + clientes + ", cprodutos=" + cprodutos + ", quantidade=" + quantidade + ", mes="
				+ mes + ", promo=" + promo + "]";
	}
	
	
	
	
}
	
