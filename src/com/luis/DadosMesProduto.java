package com.luis;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class DadosMesProduto {
	private int totalCompras;
	private double faturacao;
	private Set<String> clientesDistintos;
	private String comprasModo;
	private DecimalFormat formatter = new DecimalFormat("#0.00");
	
	public DadosMesProduto() {
		super();
		clientesDistintos = new HashSet<String>();
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
	 
	public String getComprasModo() {
		return comprasModo;
	}

	public void setComprasModo(String comprasModo) {
		this.comprasModo = comprasModo;
	}

	@Override
	public String toString() {
		return "DadosMesProduto [totalCompras=" + totalCompras + ", faturacao=" + formatter.format(faturacao) + ", clientesDistintos="
				+ clientesDistintos + ", comprasModo=" + comprasModo+ "]";
	}
	
	
	
	
	
	
}
