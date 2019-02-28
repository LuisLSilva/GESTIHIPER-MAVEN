package com.luis;

import java.util.HashMap;
import java.util.Map;

public class Cproduto {
	private Map<String, DadosProduto> gavetaProdutos;
	private String idProduto;

	
	public Cproduto() {
		super();
		this.gavetaProdutos = new HashMap<String, DadosProduto>();
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Map<String, DadosProduto> getGavetaProdutos() {
		return gavetaProdutos;
	}

	public void setGavetaProdutos(Map<String, DadosProduto> gavetaProdutos) {
		this.gavetaProdutos = gavetaProdutos;
	}

	
	@Override
	public String toString() {
		return "Cproduto [idProduto=" + idProduto + "]";
	}
	
	public void addCompraProduto(Compra compra) {
		//Caso já exista 'values' no HashMap de Cprodutos
		DadosProduto dados = gavetaProdutos.get(compra.getIdProduto());

		if(dados == null) {
			dados = new DadosProduto();
			dados.setTotalFaturado(compra.getPreco()*compra.getQuantidade());
			dados.setNumeroCompras(compra.getQuantidade());
			dados.setIdProduto(compra.getIdProduto());
			dados.setMes(compra.getMes());
			gavetaProdutos.put(compra.getIdProduto(), dados);
			dados.addCompraMensal(dados);
			return;
		}
		
		//Já existem dados neste ponto
		atualizaDadosProduto(compra.getIdProduto(), dados, compra);
		dados.addCompraMensal(dados);
	
		 
	}
	
	private void atualizaDadosProduto(String idProduto, DadosProduto dados, Compra compra) {
		 int numLista = dados.getNumeroCompras();
		 int numLido = compra.getQuantidade();
		 int numAct=numLista+numLido;
		 dados.setNumeroCompras(numAct);
		 
		 
		 
		 gavetaProdutos.put(idProduto, dados);
		 return;
	}
	

	
	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
 	System.out.println(" ");
	}

	
	
}
