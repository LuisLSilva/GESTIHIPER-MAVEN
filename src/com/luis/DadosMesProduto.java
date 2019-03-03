package com.luis;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class DadosMesProduto {
	private int totalCompras;
	private double faturacao;
	private Set<String> clientesDistintos;
	private int comprasModoP;
	private int comprasModoN;
	
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
	 
	public int getComprasModoP() {
		return comprasModoP;
	}

	public void setComprasModoP(int comprasModoP) {
		this.comprasModoP = comprasModoP;
	}

	public int getComprasModoN() {
		return comprasModoN;
	}

	public void setComprasModoN(int comprasModoN) {
		this.comprasModoN = comprasModoN;
	}

	@Override
	public String toString() {
		return "DadosMesProduto [totalCompras=" + totalCompras + ", faturacao=" + formatter.format(faturacao) + ", clientesDistintos="
				+ clientesDistintos + ", comprasModoP=" + comprasModoP+ ", comprasModoN=" + comprasModoN+"]";
	}
	
	
	
	
	
	
}
