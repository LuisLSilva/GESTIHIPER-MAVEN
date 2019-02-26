package com.luis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DadosProduto {
	private Map <Integer, DadosMesProduto> mensal;
	private Map <String, DadosClienteProduto> codCliente;
	private int numeroCompras;
	private Set<String> clientesDistintos;
	private double totalFaturado;
	
	public DadosProduto() {
		super();
		this.mensal = new HashMap<Integer,DadosMesProduto>();
		this.codCliente = new HashMap<String, DadosClienteProduto>();
		
	}

	public Map<Integer, DadosMesProduto> getMensal() {
		return mensal;
	}

	public void setMensal(Map<Integer, DadosMesProduto> mensal) {
		this.mensal = mensal;
	}

	public Map<String, DadosClienteProduto> getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Map<String, DadosClienteProduto> codCliente) {
		this.codCliente = codCliente;
	}

	public int getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}

	public Set<String> getClientesDistintos() {
		return clientesDistintos;
	}

	public void setClientesDistintos(Set<String> clientesDistintos) {
		this.clientesDistintos = clientesDistintos;
	}

	public double getTotalFaturado() {
		return totalFaturado;
	}

	public void setTotalFaturado(double totalFaturado) {
		this.totalFaturado = totalFaturado;
	}
	
	
	
	
}
