package com.luis;

import java.util.Set;

public class DadosMesProduto {
	private int totalCompras;
	private double faturacao;
	private Set<String> clientesDistintos;
	private int comprasModoN;
	private int comprasModoP;
	
	
	public DadosMesProduto() {
		super();
	}
	
	public int getTotalCompras() {
		return totalCompras;
	}
	
	public void setTotalCompras(int totalCompras) {
		this.totalCompras = totalCompras;
	}
	
	public double getFaturacao() {
		return faturacao;
	}
	
	public void setFaturacao(double faturacao) {
		this.faturacao = faturacao;
	}
	
	public Set<String> getClientesDistintos() {
		return clientesDistintos;
	}
	
	public void setClientesDistintos(Set<String> clientesDistintos) {
		this.clientesDistintos = clientesDistintos;
	}
	
	public int getComprasModoN() {
		return comprasModoN;
	}
	
	public void setComprasModoN(int comprasModoN) {
		this.comprasModoN = comprasModoN;
	}
	
	public int getComprasModoP() {
		return comprasModoP;
	}
	
	public void setComprasModoP(int comprasModoP) {
		this.comprasModoP = comprasModoP;
	}
	
	
	
	
	
	
}
