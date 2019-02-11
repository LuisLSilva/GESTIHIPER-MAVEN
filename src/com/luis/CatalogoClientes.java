package com.luis;

public class CatalogoClientes {

	private String id_clientes;
	private String nome;
	
	
	public CatalogoClientes(String id_clientes, String nome) {
		super();
		this.id_clientes = id_clientes;
		this.nome = nome;
	}
	public String getId_clientes() {
		return id_clientes;
	}
	public void setId_clientes(String id_clientes) {
		this.id_clientes = id_clientes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
