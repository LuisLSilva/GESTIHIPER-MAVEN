package com.luis;

import java.util.HashMap;
import java.util.Map;

public class Cproduto {
	private Map<String, DadosProduto> catalogoProdutos;
	private String idProduto;
	
	private DadosProduto mensal;
	
	
	public Cproduto() {
		super();
		this.catalogoProdutos = new HashMap<String, DadosProduto>();
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Map<String, DadosProduto> getCatalogoProdutos() {
		return catalogoProdutos;
	}

	public void setCatalogoProdutos(Map<String, DadosProduto> catalogoProdutos) {
		this.catalogoProdutos = catalogoProdutos;
	}

	@Override
	public String toString() {
		return "Cproduto [idProduto=" + idProduto + "]";
	}

	// Put para o Ficheiro de Produto
	public void putCprodutos(Cproduto cproduto) {
		catalogoProdutos.put(cproduto.getIdProduto(), null);
	//	printMapAA(catalogoProdutos);
	}

	public void addCompraProduto(Compra compra) {
		//Caso já exista 'values' no HashMap de Cprodutos
		DadosProduto dados = catalogoProdutos.get(compra.getIdProduto());

		if(dados == null) {
			dados = new DadosProduto();
			dados.setTotalFaturado(compra.getPreco()*compra.getQuantidade(),false);
			dados.setNumeroCompras(compra.getQuantidade(), false);
			dados.setIdProduto(compra.getIdProduto());
			dados.setMes(compra.getMes());
		}
		
	
		if(catalogoProdutos.containsKey(compra.getIdProduto())){
			dados.setNumeroCompras(compra.getQuantidade(), true);	
			dados.setTotalFaturado(compra.getPreco()*compra.getQuantidade(),true);
			
		}
		
		catalogoProdutos.put(compra.getIdProduto(), dados);
			
		//System.out.println(dados.toString());
			
	//	printMapAA(catalogoProdutos);
		
		if(dados!=null) {
			mensal.addCompraMensal(dados);
		}
		
	}
	
	




	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
		System.out.println(" ");
	}

	
	
}
