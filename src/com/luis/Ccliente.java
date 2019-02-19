package com.luis;

import java.util.Map;

public class Ccliente {
	private String idCliente;
	private Map <String, DadosCliente> catalogoCliente;
	
	
	public Ccliente() {
		super();
	}
	
	public Ccliente(String idCliente) {
		super();
		this.idCliente = idCliente;
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

