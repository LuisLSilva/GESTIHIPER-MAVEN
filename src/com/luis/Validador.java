package com.luis;

import java.util.ArrayList;
import java.util.List;

public class Validador {
	private Compra compra;
	private static int fields = 6;
	
	
	List<Compra> listaClientela2 = new ArrayList<Compra>();
	
	public Validador(){
		super();
	}
	
	public Compra validacao(String lineSplitter[]){
		
		if (lineSplitter.length == fields) {
			
			compra = new Compra();
			
			String valCliente = ValidarCliente(lineSplitter[0]);
			double valPreco = ValidarPreco(lineSplitter[1]);
			int valQuantidade = ValidarQuantidade(lineSplitter[2]);
			String valPromo = ValidarPromo(lineSplitter[3]);
			String valProduto = ValidarProduto(lineSplitter[4]);
			int valMes = ValidarMes(lineSplitter[5]);
		
			SetCliente(valCliente);
			SetPreco(valPreco);
			SetQuantidade(valQuantidade);
			SetPromo(valPromo);
			SetProduto(valProduto);
			SetMes(valMes);
		
		    arraylist();
		    
		    return compra;
			
		} else {
			System.out.println("O campo lido é inválido");
			System.out.println(" "); 
			return null;
		}
	}	


	public String ValidarCliente(String string) {

		if (string.length() == 6) {

			String sub1 = string.substring(0, 2);
			String sub2 = string.substring(2);

			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
				System.out.println("O id do cliente " + string + " é válido");
				System.out.println(" ");

				return string;
				
			} else {
				System.out.println("O id do cliente " + string + " é inválido");
				System.out.println(" ");
				
				return null;
			}
		} else {
			System.out.println("O id do cliente " + string + " é inválido");
			System.out.println(" ");
			
			return null;
		}
	}
	
	public double ValidarPreco(String string) {

		double preco = Double.valueOf(string);
		
		if (preco>0) {
			System.out.println("O preço " + preco + " é válido!!!");
			System.out.println(" ");
			
			return preco;

		} else {
			System.out.println("O preço " + preco + " é inválido!!!");
			System.out.println(" ");
			
			return 0;
		}
	}
	
	public int ValidarQuantidade(String string) {
		
		int quantidade = Integer.valueOf(string);
		
		if(quantidade>0){
			System.out.println("A quantidade "+quantidade+" é válida!!!");
			System.out.println(" "); 
			
			return quantidade;	
		}	
		else{
			System.out.println("A quantidade "+quantidade+" é inválida!!!");
			System.out.println(" "); 
			
			return 0;
		}	
	}
	
	private String ValidarPromo(String string) {

		if(string.length()==1 && (string.equals("N") || string.equals("P"))){
			System.out.println("O tipo do produto "+ string + " é válido!");
			System.out.println(" ");
			
			return string;
			
		}else{
			System.out.println("O tipo do produto "+ string + " é inválido!");
			System.out.println(" "); 
			
			return null;
		}		
	}

	public String ValidarProduto(String string) {

		if(string.length()==5){
			
			String sub1 = string.substring(0, 2);
			String sub2 = string.substring(2);
	
			if (sub1.matches("[A-Z]+") && sub2.matches("[0-9]+")) {
				System.out.println("O id do produto "+ string + "é válido!");
				System.out.println(" "); 
				
				return string;
				
			}else{
				System.out.println("O id do produto "+ string + "é inválido!");
				System.out.println(" "); 
				
				return null;
			}
		}else{
				
			System.out.println("O id do produto "+ string + "é inválido!");
			System.out.println(" "); 
			
			return null;
		}
	}
	
	private int ValidarMes(String string) {

		int mes = Integer.valueOf(string);

		if (mes > 0 && mes <= 12) {
			System.out.println("O Mês " + mes + " é válido!!!");
			System.out.println(" ");

			return mes;
		} else {
			System.out.println("O Mês " + mes + " é inválido!!!");
			System.out.println(" ");

			return 0;
		}
	}
	
	public void SetCliente(String valCliente) {

		if (valCliente != null) {
			compra.setClientes(new Ccliente(valCliente));
			listaClientela2.add(compra);
		}
	}
	
	public void SetPreco(double valPreco) {

		if (valPreco != 0) {
			compra.setCprodutos(new Cproduto(valPreco));
		}

	}
	
	public void SetQuantidade(int valQuantidade) {

		if (valQuantidade != 0) {
			compra.setQuantidade(valQuantidade);
		}
	}
	
	public void SetPromo(String valPromo) {
		
		if (valPromo != null) {
			compra.setPromo(valPromo);
		}
	}

	public void SetProduto(String valProduto) {

		if (valProduto != null) {
			compra.setCprodutos(new Cproduto(valProduto));
		}
	}
	
	public void SetMes(int valMes) {
		
		if(valMes!=0){
			compra.setMes(valMes);
		}
	
	}

	public void arraylist() {
	
		for(int i=0; i<listaClientela2.size(); i++){
			System.out.println("indice:"+i+" "+listaClientela2.get(i).toString());
			System.out.println(" "); 	
		}
	}
}
	
	
	
	
	
	
	
	


