package com.luis;

public class Compra {
	private String idProduto;
	private double preco;
	private int quantidade;
	private String promo;
	private String idCliente;
	private int mes;
	
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getPromo() {
		return promo;
	}
	
	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Compra [idProduto=" + idProduto + ", preco=" + preco + ", quantidade=" + quantidade + ", promo=" + promo
				+ ", idCliente=" + idCliente + ", mes=" + mes + "]";
	}
	
	
	
}
	
