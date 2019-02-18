package com.luis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hipermercado {
	private List<Ccliente> listCcliente = new ArrayList<Ccliente>();
	private List<Cproduto> listCproduto = new ArrayList<Cproduto>();
	private List<Compra> listCompra = new ArrayList<Compra>();
	private Contabilidade contabilidade;
	
	private HashMap<String, Compra> catalogoProduto = new HashMap<>();
	
	public List<Ccliente> getListCcliente() {
		return listCcliente;
	}

	public void setListCcliente(List<Ccliente> listCcliente) {
		this.listCcliente = listCcliente;
	}

	public List<Cproduto> getListCproduto() {
		return listCproduto;
	}

	public void setListCproduto(List<Cproduto> listCproduto) {
		this.listCproduto = listCproduto;
	}

	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}
	
	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}
	
	
	public void addCcliente(Ccliente ccliente) {
		listCcliente.add(ccliente);
	}
	
	public void addCproduto(Cproduto cproduto) {
		listCproduto.add(cproduto);
		
	}
	
	public void addCompra(Compra compra){
		listCompra.add(compra);
	}
	
	public void hashMapCatalog(String key, Compra value){
		catalogoProduto.put(key, value);
	}
	
	

	@Override
	public String toString() {
		return "Hipermercado [listCcliente=" + listCcliente + ", listCproduto=" + listCproduto + ", listCompra="
				+ listCompra + ", contabilidade=" + contabilidade + "]";
	}

	
	

	
	
	
	
	
}
