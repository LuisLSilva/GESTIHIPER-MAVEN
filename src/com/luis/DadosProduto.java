package com.luis;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DadosProduto {
	private Map <Integer, DadosMesProduto> mensal;
	private Map <String, DadosClienteProduto> codCliente;
	private int numeroCompras;
	private Set<String> clientesDistintos;
	private double totalFaturado;
	
	
	//Para mim
	private String idProduto;
	
	//Feito Totalmente por mim
	private int mes;
	
	public DadosProduto() {
		super();
		this.mensal = new HashMap<Integer,DadosMesProduto>();
		this.codCliente = new HashMap<String, DadosClienteProduto>();
		
	}
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
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

	public void setNumeroCompras(int numeroCompras, boolean a) {
		if(a){
			this.numeroCompras += numeroCompras;
		}else{
			this.numeroCompras = numeroCompras;
		}
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

	public void setTotalFaturado(double totalFaturado, boolean a) {
		if(a){
			this.totalFaturado += totalFaturado;
		}else{
			this.totalFaturado = totalFaturado;
		}
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	
	@Override
	public String toString() {
		return "DadosProduto [idProduto="+ idProduto + ", numeroCompras=" + numeroCompras + ", totalFaturado=" + new DecimalFormat("0.00").format(totalFaturado) + ", mês=" + mes+ "]"; 
	}

	
	public void addCompraMensal(DadosProduto dadosProduto){
			DadosMesProduto dadosMP = mensal.get(dadosProduto.mes);
			
			if(dadosMP == null) {
				dadosMP = new DadosMesProduto();
				dadosMP.setTotalCompras(dadosProduto.getNumeroCompras());
			//	dadosMP.setComprasModoN();	
			}
			
			
			
			mensal.put(dadosProduto.getMes(), dadosMP);
			printMapAA(mensal);
		
		
	}
	
	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
		System.out.println(" ");
	}
		
			
	
}
