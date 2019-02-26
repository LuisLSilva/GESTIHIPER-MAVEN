package com.luis;

import java.util.HashMap;
import java.util.Map;

public class Ccliente {
	private Map<String, DadosProduto> catalogoClientes;
	private String idCliente;

	public Ccliente() {
		super();
		this.catalogoClientes = new HashMap<String, DadosProduto>();
	}
	
	public Ccliente(String idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public void put(Ccliente ccliente){
		catalogoClientes.put(ccliente.getIdCliente(), null);
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Cclientes [idClientes=" + idCliente + "]";
	}

	
	
	
	
	
}

