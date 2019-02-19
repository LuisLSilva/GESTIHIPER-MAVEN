package com.luis;

import java.util.HashMap;
import java.util.Map;

public class Cproduto {
	private String idProduto;
	private Map<String, DadosProduto> catalogoProdutos;
	
	public Cproduto() {
		super();
		this.catalogoProdutos = new HashMap<>();
	}

	public Map<String, DadosProduto> getCatalogoProdutos() {
		return catalogoProdutos;
	}

	public void setCatalogoProdutos(Map<String, DadosProduto> catalogoProdutos) {
		this.catalogoProdutos = catalogoProdutos;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public String toString() {
		return "Cproduto [catalogoProdutos=" + catalogoProdutos + "]";
	}
}
