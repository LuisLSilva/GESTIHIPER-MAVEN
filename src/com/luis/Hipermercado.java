package com.luis;

import java.util.ArrayList;
import java.util.List;


public class Hipermercado {
	private List<Ccliente> listCcliente = new ArrayList<Ccliente>();
	private List<Cproduto> listCproduto = new ArrayList<Cproduto>();
	private List<Compra> listCompra = new ArrayList<Compra>();
	private Contabilidade contabilidade;
	
	private Ccliente catalogoClientes;
	private Cproduto catalogoProdutos;
	
	
	public Hipermercado() {
		super();
		catalogoClientes = new Ccliente();
		catalogoProdutos = new Cproduto();
		
	}

	public void addCompra(Compra compra){
		listCompra.add(compra);
		catalogoProdutos.addCompraProduto(compra);
	
	}
	
	public List<Ccliente> getListCcliente() {
		return listCcliente;
	}

	public void setListCcliente(List<Ccliente> listCcliente) {
		this.listCcliente = listCcliente;
	}

	public Ccliente getCatalogoClientes() {
		return catalogoClientes;
	}

	public void setCatalogoClientes(Ccliente catalogoClientes) {
		this.catalogoClientes = catalogoClientes;
	}

	public Cproduto getCatalogoProdutos() {
		return catalogoProdutos;
	}

	public void setCatalogoProdutos(Cproduto catalogoProdutos) {
		this.catalogoProdutos = catalogoProdutos;
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
	
	
	@Override
	public String toString() {
		return "Hipermercado [listCcliente=" + listCcliente + ", listCproduto=" + listCproduto + ", listCompra="
				+ listCompra + ", contabilidade=" + contabilidade + "]";
	}

	
	

	
	
	
	
	
}
