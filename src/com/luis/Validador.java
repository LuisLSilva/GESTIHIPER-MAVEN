package com.luis;

import java.util.ArrayList;
import java.util.List;

public class Validador {
	
	List<String> listaClientes = new ArrayList<String>();
	List<String> listaPrecos = new ArrayList<String>();
	List<String> listaQuantidade = new ArrayList<String>();
	List<String> listaTipo = new ArrayList<String>();
	List<String> listaProduto = new ArrayList<String>();
	List<String> listaMes = new ArrayList<String>();
	int fields = 6;
	
	List<Cclientes> listaClientela = new ArrayList<Cclientes>();
	List<Compras> listaClientela2 = new ArrayList<Compras>();
	
	public Validador(){
		super();
	}
	
	public void validacao(String lineSplitter[]){
		
		if (lineSplitter.length == fields) {
			listaClientes.add(lineSplitter[0]);
			listaPrecos.add(lineSplitter[1]);
			listaQuantidade.add(lineSplitter[2]);
			listaTipo.add(lineSplitter[3]);
			listaProduto.add(lineSplitter[4]);
			listaMes.add(lineSplitter[5]);
			
			validarClientes();
			validarPreco();
			validarQuantidade();
			validarPN();
			validarProdutos();
			validarMes();
			arraylist();
			arraylist2();

		} else {
			System.out.println("O campo lido é inválido");
			System.out.println(" "); 
		}
	}

	
	public void validarClientes() {
		
		for(int i=0; i<listaClientes.size(); i++){
			String clienteTemp =(listaClientes.get(i));
			
			if(clienteTemp.length()==6){
			
				String sub1 = clienteTemp.substring(0, 2);
				String sub2 = clienteTemp.substring(2);
		
				if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
					System.out.println("O id do cliente "+clienteTemp+" é válido");
					System.out.println(" ");
					
					Cclientes cclientes = new Cclientes();
					cclientes.setIdClientes(clienteTemp);
			
					Compras compras = new Compras();
					compras.setCliente(cclientes);
					
					listaClientela2.add(compras);
					
				}else{
					System.out.println("O id do cliente "+clienteTemp+" é inválido");
					System.out.println(" "); 
				}
			}else{
				System.out.println("O id do cliente "+clienteTemp+" é inválido");
				System.out.println(" ");
			}	
		}
	}
	
	public void validarPreco() {
		
		for(int i=0; i<listaPrecos.size(); i++){
			double preco = Double.valueOf(listaPrecos.get(i));
			
			if(preco>0){
				System.out.println("O preço "+preco+" é válido!!!");
				System.out.println(" "); 
					
			}	
			else{
				System.out.println("O preço "+preco+" é inválido!!!");
				System.out.println(" "); 
			}	
		}
	}
	
	public void validarQuantidade() {
		
		for(int i=0; i<listaQuantidade.size(); i++){
			int quantidade = Integer.valueOf(listaQuantidade.get(i));
			
			if(quantidade>0){
				System.out.println("A quantidade "+quantidade+" é válida!!!");
				System.out.println(" "); 
				
				Compras compras = new Compras();
				compras.setQuantidade(quantidade);
				
				listaClientela2.add(compras);
				
			}	
			else{
				System.out.println("A quantidade "+quantidade+" é inválida!!!");
				System.out.println(" "); 
			}	
		}	
		
	}
	
	private void validarPN() {
		
		for(int i=0; i<listaTipo.size(); i++){
			String tipoTemp =(listaTipo.get(i));
			
			if(tipoTemp.length()==1 && (tipoTemp.equals("N") || tipoTemp.equals("P"))){
				System.out.println("O tipo do produto "+ tipoTemp + " é válido!");
				System.out.println(" "); 
			}else{
				System.out.println("O tipo do produto "+ tipoTemp + " é inválido!");
				System.out.println(" "); 
			}	
		}
	}
	
	public void validarProdutos() {
		
		for(int i=0; i<listaProduto.size(); i++){
			String produtoTemp =(listaProduto.get(i));
		
			if(produtoTemp.length()==5){
			
				String sub1 = produtoTemp.substring(0, 2);
				String sub2 = produtoTemp.substring(2);
		
				if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
					System.out.println("O id do produto "+ produtoTemp + "é válido!");
					System.out.println(" "); 
					
					
					Cprodutos cprodutos = new Cprodutos();
					cprodutos.setIdProdutos(produtoTemp);
			
					Compras compras = new Compras();
					compras.setCprodutos(cprodutos);
					
					listaClientela2.add(compras);
				
				}else{
					System.out.println("O id do produto "+ produtoTemp + "é inválido!");
					System.out.println(" "); 
				}
			}else{
				System.out.println("O id do produto "+ produtoTemp + "é inválido!");
				System.out.println(" "); 
			}
		}
	}

	public void validarMes() {
		
		for(int i=0; i<listaMes.size(); i++){
			int mes = Integer.valueOf(listaMes.get(i));
		
			if(mes>0 && mes<=12){
				System.out.println("O Mês "+mes+" é válido!!!");
				System.out.println(" "); 
				
				Compras compras = new Compras();
				compras.setMes(mes);
				
			}	
			else{
				System.out.println("O Mês "+mes+" é inválido!!!");
				System.out.println(" "); 
			}
		}
	}
	
	public void arraylist(){
		
		for(int i=0; i<listaClientela.size(); i++){
			System.out.println(listaClientela.get(i).idClientes);
			
		}	
	}
	
	public void arraylist2() {
	
		for(int i=0; i<listaClientela2.size(); i++){
			System.out.println("indice:"+i+" "+listaClientela2.get(i).toString());
			
		}
	}
}
	
	
	
	
	
	
	
	


