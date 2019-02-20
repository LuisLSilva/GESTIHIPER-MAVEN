package com.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Consulta {

	Hipermercado hipermercado;
	Validador validador;
	
	public Consulta(Hipermercado hipermercado, Validador validador) {
		super();
		this.hipermercado = hipermercado;
		this.validador = validador;
	}

	public void totalComprasMes(){
		
		int quantidadeTotal=0;
		
		    for(int j=1; j<13; j++){
		    	for(int i=0; i<hipermercado.getListCompra().size(); i++){
			    	if(j == hipermercado.getListCompra().get(i).getMes()){
			    		quantidadeTotal=quantidadeTotal+ hipermercado.getListCompra().get(i).getQuantidade();
			    	}
		    	}
		    	System.out.println("O mês:"+j+" quantidade:"+ quantidadeTotal);
		     	quantidadeTotal = 0;
		    }
	}

	public void totalGlobal() {
		
		 double totalMes=0;
		 double totalGlobal=0;
		
		 	for(int j=1; j<13; j++){
		 		for(int i=0; i<hipermercado.getListCompra().size(); i++){
		 			if(j == hipermercado.getListCompra().get(i).getMes()){
		 		         totalMes = totalMes+hipermercado.getListCompra().get(i).getPreco() * hipermercado.getListCompra().get(i).getQuantidade();
		 			}
		 		}
		 		System.out.println("O mês:"+j+" totalidade do mes:"+totalMes+" euros");
		 		double temp = totalMes;
		        totalMes=0;
		        totalGlobal+=temp;
		 	}
		 	
		 	System.out.println("\nA faturação Global: "+totalGlobal+" euros");
	}

	public void clientesDistintos() {
	
		HashSet<String> clientesDistintos = new HashSet<String>();
	
		for (int j = 1; j < 13; j++) {
			for (Compra i : hipermercado.getListCompra()) {
				if (j == i.getMes()) {
					clientesDistintos.add(i.getIdCliente());
				}
			}

			System.out.println("\nClientes do mes: " + j);
			// System.out.println(clientesDistintos.size());
			for (String temp : clientesDistintos) {
				System.out.println(temp);
			}
			clientesDistintos.clear();
		}
	}

	public void comprasInvalidas() {
	
		System.out.println("Existem " +validador.comprasInvalidas.size()+ " compras inválidas\nConsulte o ficheiro ComprasInvalidas.txt");
		
			 try {
				 BufferedWriter objWriter = new BufferedWriter(new FileWriter("ComprasInvalidas.txt"));
				 String newLine = System.getProperty("line.separator");
				 
				 for(int i=0; i<validador.comprasInvalidas.size(); i++){ 
					 objWriter.write(validador.comprasInvalidas.get(i)+" "+newLine);
				 }
				 objWriter.close();
				 
			} catch (IOException e) {
				e.printStackTrace();
			}   
		}

	
	public void produtosNaoComprados() {

		HashSet<String> comprasProdutosDistintos = new HashSet<String>();
		HashSet<String> ProdutosDistintos = new HashSet<String>();
		List<String> codProdutoNB = new ArrayList();
		
		for(int i=0; i<hipermercado.getListCompra().size(); i++){	
			comprasProdutosDistintos.add(hipermercado.getListCompra().get(i).getIdProduto());
 			}
			
		for(int i=0; i<hipermercado.getListCproduto().size(); i++){
			ProdutosDistintos.add(hipermercado.getListCproduto().get(i).getIdProduto());
			}
		
			System.out.println("Produtos vendidos: "+comprasProdutosDistintos.size());
			System.out.println("Produtos existentes: "+ProdutosDistintos.size());
			
		for (String produto : ProdutosDistintos) {
			if(comprasProdutosDistintos.contains(produto) ){
    			codProdutoNB.add(produto);
    		}
		}	
	    
		System.out.println();
		
		for (int i=0; i<codProdutoNB.size(); i++){
			System.out.println(codProdutoNB.get(i));
			
		}	
	}

	public void clientesNuncaCompraram() {
		
		
		
		
	}
	
	
	
	
	
	
	
}
	
	
	

	

	
	
	
	
	
	
	

