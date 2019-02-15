package com.luis;

public class Ccliente {
	private String idClientes;
	
	
	public Ccliente() {
		super();
	}
	
	public Ccliente(String idClientes) {
		super();
		this.idClientes = idClientes;
	}

	public String getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(String idClientes) {
		this.idClientes = idClientes;
	}

	@Override
	public String toString() {
		return "Cclientes [idClientes=" + idClientes + "]";
	}

}

