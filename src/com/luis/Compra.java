package com.luis;

public class Compra {
	private Ccliente cliente;
	private Cproduto cproduto;
	private int quantidade;
	private int mes;
	private String promo;
	
	public Ccliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Ccliente cliente) {
		this.cliente = cliente;
	}
	
	public Cproduto getCproduto() {
		return cproduto;
	}
	
	public void setCproduto(Cproduto cproduto) {
		this.cproduto = cproduto;
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
		return "Compra [cliente=" + cliente + ", cprodutos=" + cproduto + ", quantidade=" + quantidade + ", mes="
				+ mes + ", promo=" + promo + "]";
	}
	
	
	
	
}
	
