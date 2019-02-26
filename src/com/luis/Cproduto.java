package com.luis;

import java.util.HashMap;
import java.util.Map;

public class Cproduto {
	private Map<String, DadosProduto> catalogoProdutos;
	private String idProduto;
	
	public Cproduto() {
		super();
		this.catalogoProdutos = new HashMap<String, DadosProduto>();
	}

	public void put(Cproduto cproduto){
		catalogoProdutos.put(cproduto.getIdProduto(), null);
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
	
	public void addCompra(Compra compra) {
		DadosProduto dados = catalogoProdutos.get(compra.getIdCliente());
		
		if(dados == null) {
			dados = new DadosProduto();
			dados.setTotalFaturado(compra.getPreco()*compra.getQuantidade());
			
		}
		catalogoProdutos.put(compra.getIdProduto(), dados);
		
	
	}


	
	
	
	
}
