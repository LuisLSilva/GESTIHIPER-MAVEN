package com.luis;

public class Cclientes {
	String idClientes;
	
	
	public Cclientes() {
		super();
	}
	
	public Cclientes(String idClientes) {
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

