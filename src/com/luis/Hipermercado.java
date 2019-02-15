package com.luis;

import java.util.ArrayList;
import java.util.List;

public class Hipermercado {
	private Ccliente cclientes;
	private Cproduto cprodutos;
	private Contabilidade contabilidade;
	private List<Compra> listCompra = new ArrayList<Compra>();
	
	public Ccliente getCclientes() {
		return cclientes;
	}
	
	public void setCclientes(Ccliente cclientes) {
		this.cclientes = cclientes;
	}
	
	public Cproduto getCprodutos() {
		return cprodutos;
	}
	
	public void setCprodutos(Cproduto cprodutos) {
		this.cprodutos = cprodutos;
	}
	
	public Contabilidade getContabilidade() {
		return contabilidade;
	}
	
	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}
	
	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}

	public void addCompra(Compra compra){
		listCompra.add(compra);
	}

	@Override
	public String toString() {
		return "Hipermercado [cclientes=" + cclientes + ", cprodutos=" + cprodutos + ", contabilidade=" + contabilidade
				+ ", listCompra=" + listCompra + "]";
	}
	
	
	
	
	
	
}
