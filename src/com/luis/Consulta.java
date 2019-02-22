package com.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Consulta {

	private Hipermercado hipermercado;
	private Validador validador;
	private HashSet<String> comprasProdutosDistintos = new HashSet<String>();
	private HashSet<String> comprasClientesDistintos = new HashSet<String>();
	private HashSet<String> produtosDistintos = new HashSet<String>();
	private HashSet<String> clientesDistintos = new HashSet<String>();
	private Map<String, Integer> unsortMap = new HashMap<String, Integer>();
	private int quantidadeTotal;
	private Scanner scanner = new Scanner(System.in);
	
	
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

		List<String> codProdutoNC = new ArrayList<String>();
		
		for(int i=0; i<hipermercado.getListCompra().size(); i++){	
			comprasProdutosDistintos.add(hipermercado.getListCompra().get(i).getIdProduto());
 			}
			
		for(int i=0; i<hipermercado.getListCproduto().size(); i++){
			produtosDistintos.add(hipermercado.getListCproduto().get(i).getIdProduto());
			}
		
			System.out.println("Produtos vendidos: "+comprasProdutosDistintos.size());
			System.out.println("Produtos existentes: "+produtosDistintos.size());
			
		for (String produto : produtosDistintos) {
			if(!comprasProdutosDistintos.contains(produto) ){
				codProdutoNC.add(produto);
    		}
		}	
		Collections.sort(codProdutoNC);
		
		for (int i=0; i<codProdutoNC.size(); i++){
			System.out.println(codProdutoNC.get(i));
		}
		System.out.println("\n"+"Existem "+codProdutoNC.size()+" produtos que não foram vendidos");
	}

	public void clientesNuncaCompraram() {
		
		List<String> codClienteNC = new ArrayList<String>();
		
		
		for (Ccliente i : hipermercado.getListCcliente()) {
			clientesDistintos.add(i.getIdCliente());
		}
		
		for (Compra i: hipermercado.getListCompra()){
			comprasClientesDistintos.add(i.getIdCliente());
			
		}
			
		System.out.println("Clientes que compraram:"+comprasClientesDistintos.size());
		System.out.println("Clientes existentes: "+clientesDistintos.size());
		System.out.println("\nLista:");
		
		for (String cliente : comprasClientesDistintos) {
			if(!clientesDistintos.contains(cliente) ){
				codClienteNC.add(cliente);
    		}
		}	
		Collections.sort(codClienteNC);
		
		for (int i=0; i<codClienteNC.size(); i++){
			System.out.println(codClienteNC.get(i));
		}
		System.out.println("\n"+"Existem "+codClienteNC.size()+" compraram mas não lista no Ficheiro de Clientes");
	}
	
	public void numeroComprasEclientesPorMes() {

		int j;

		System.out.print("\nEscolha um mês de 1 a 12:");
		j = scanner.nextInt();
		if (j > 0 && j < 13) {
			for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
				if (j == hipermercado.getListCompra().get(i).getMes()) {
					comprasClientesDistintos.add(hipermercado.getListCompra().get(i).getIdCliente());
					quantidadeTotal = quantidadeTotal + hipermercado.getListCompra().get(i).getQuantidade();
				}
			}
			System.out.println("\nNo mês " + j + " o número de compras feitas foram: " + quantidadeTotal);
			quantidadeTotal = 0;
		} else {
			System.out.println("O número do mês inserido, deverá ser de 1 a 12");
		}
		
		System.out.println("O total de clientes que realizaram compras: " + comprasClientesDistintos.size());		
	}
	    
	public void codigoClienteParaMes(){    
	    		
	    String s;
	    double gastos=0;
	    double gastosTotal=0;
	    double temp=0;
	    int quantidadeTotal=0;
	    
	    
	    System.out.print("\nIntroduza um código de cliente:");
	    s=scanner.nextLine();	
	    
	    System.out.println("\nDados do cliente: "+s+"\n");
	    
	    if(validador.validacaoCliente(s)!=null){
	    	
	    	for(int j=1; j<13; j++){
	    		for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
					if (j == hipermercado.getListCompra().get(i).getMes()) {
						if(s.equals(hipermercado.getListCompra().get(i).getIdCliente())){
							quantidadeTotal += hipermercado.getListCompra().get(i).getQuantidade();
							gastos = gastos+hipermercado.getListCompra().get(i).getPreco() * hipermercado.getListCompra().get(i).getQuantidade();
							comprasProdutosDistintos.add(hipermercado.getListCompra().get(i).getIdProduto());	
						
			//			}else{
			//			    System.out.println("O código de cliente não se encontra no registo da compra.");
			//			    return;
						}
					}
				}	
	    		System.out.println("No Mes: "+j+" tem um número total de compras:"+quantidadeTotal+ " com os gastos de: "+ gastos+" euros" );
	    		temp=gastos;
	    		gastos=0;
	    		gastosTotal+=temp;
	    		quantidadeTotal=0;
	    	} 
	    	
	    	System.out.println("\nO cliente "+s+" comprou "+comprasProdutosDistintos.size()+" produto(s) distinto(s)");
	    	System.out.println("O cliente "+s+ " tem uma faturação anual: "+gastosTotal+" euros");
	    }else{
	    	System.out.println("O código de cliente que inseriu não é válido!");
	    }
	}
	
	
	public void codigoProdutoMesaMes(){
	
		String s;
		double gastos = 0;
		double gastosTotal = 0;
		double temp = 0;
		int quantidadeTotal = 0;

		System.out.print("\nIntroduza um código do produto:");
		s = scanner.nextLine();

		System.out.println("\nDados do produto: " + s + "\n");

		if (validador.validacaoProduto(s) != null) {

			for (int j = 1; j < 13; j++) {
				for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
					if (j == hipermercado.getListCompra().get(i).getMes()) {
						if (s.equals(hipermercado.getListCompra().get(i).getIdProduto())) {
							quantidadeTotal += hipermercado.getListCompra().get(i).getQuantidade();
							gastos = gastos + hipermercado.getListCompra().get(i).getPreco()* hipermercado.getListCompra().get(i).getQuantidade();
							comprasClientesDistintos.add(hipermercado.getListCompra().get(i).getIdCliente());

		//				} else {
		//					System.out.println("O código de produto não se encontra no registo da compra.");
		//					return;
						}
					}
				}
				System.out.println("No Mes: "+j+" tem um número total de compras:"+quantidadeTotal+ " com os gastos de: "+ gastos+" euros" );
	    		temp=gastos;
	    		gastos=0;
	    		gastosTotal+=temp;
	    		quantidadeTotal=0;
			}

			System.out.println("\nO produto "+s+" foi comprado "+comprasClientesDistintos.size()+" cliente(s) distinto(s)");
	    	System.out.println("O produto "+s+ " tem uma faturação anual: "+gastosTotal+" euros");
		} else {
			System.out.println("O código do produto que inseriu não é válido!");
		}
	}
	
	public void codigoProdutoNP(){
		
		String s;
		int countP=0;
		int countN=0;
		int countTotalP=0;
		int countTotalN=0;
		int countTempP=0;
		int countTempN=0;
		double gastosP = 0;
		double gastosN = 0;
		double gastosTotalP = 0;
		double gastosTotalN = 0;
		double tempP = 0;
		double tempN = 0;
	    
		System.out.print("\nIntroduza um código do produto:");
		s = scanner.nextLine();

		System.out.println("\nDados do produto: " + s + "\n");

		if (validador.validacaoProduto(s) != null) {

			for (int j = 1; j < 13; j++) {
				for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
					if (j == hipermercado.getListCompra().get(i).getMes()) {
						if (s.equals(hipermercado.getListCompra().get(i).getIdProduto())) {
							if (hipermercado.getListCompra().get(i).getPromo().equals("N")) {
								countN++;
								gastosN = gastosN + hipermercado.getListCompra().get(i).getPreco()
										* hipermercado.getListCompra().get(i).getQuantidade();
							} else if (hipermercado.getListCompra().get(i).getPromo().equals("P")) {
								countP++;
								gastosP = gastosP + hipermercado.getListCompra().get(i).getPreco()
										* hipermercado.getListCompra().get(i).getQuantidade();
							}

						}
					}
				}
				System.out.println("No Mes: " + j + " tem um número total de compras sem promoções: " + countN
						+ " com promoção: " + countP);
				tempN = gastosN;
				gastosTotalN += tempN;
				countTempN = countN;
				countTotalN += countTempN;

				tempP = gastosP;
				gastosTotalP += tempP;
				countTempP = countP;
				countTotalP += countTempP;

				countN = 0;
				countP = 0;
				gastosN = 0;
				gastosP = 0;
			}

			System.out.println("\nO produto " + s + " durante o ano esteve " + countTotalN
					+ " sem promoção e teve uma faturação anual de: " + gastosTotalN + " euros");
			System.out.println("O produto " + s + " durante o ano esteve " + countTotalP
					+ " em promoção e teve uma faturação anual de: " + gastosTotalP + " euros");

		} else {
			System.out.println("O código do produto que inseriu não é válido!");
		}
	}
	
	public void clienteListaProdutos(){

		String s;

		System.out.print("\nIntroduza um código de cliente:");
		s = scanner.nextLine();

		System.out.println("\nDados do cliente: " + s + "\n");

		if (validador.validacaoCliente(s) != null) {

			for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
				if (s.equals(hipermercado.getListCompra().get(i).getIdCliente())) {
					unsortMap.put(hipermercado.getListCompra().get(i).getIdProduto(),
							hipermercado.getListCompra().get(i).getQuantidade());
				}
			}

			Map<String, Integer> sortedMap = sortByValue(unsortMap);
			printMapPQ(sortedMap);

		} else {
			System.out.println("O código de cliente que inseriu não é válido!");
		}

	}
		
	public static Map<String, Integer> sortByValue(Map<String , Integer> unsortMap){
		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
		 
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }	
	
		return sortedMap;
	}
	
	public static <K,V> void printMapPQ(Map<K,V> map){
		for(Map.Entry<K, V> entry: map.entrySet()){
			System.out.println("Produto comprado: " + entry.getKey() + "  Quantidade: "+entry.getValue());
		}
	}	
	
	public static <K,V> void printMapCQ(Map<K,V> map){
		for(Map.Entry<K, V> entry: map.entrySet()){
			System.out.println("O Cliente que comprou: " + entry.getKey() + "  Quantidade: "+entry.getValue());
		}
	}	
		
	
	public void conjuntoXprodutos() {

		int s;

		System.out.print("\nIntroduza uma quantidade:");
		s = scanner.nextInt();

		System.out.println("\nOs produtos mais vendidos:" + s + "\n");

		if (s > 0) {

			for (int i = 0; i < hipermercado.getListCompra().size(); i++) {
				if (s == (hipermercado.getListCompra().get(i).getQuantidade())) {

					unsortMap.put(hipermercado.getListCompra().get(i).getIdCliente(),
							hipermercado.getListCompra().get(i).getQuantidade());
				}
			}

			printMapCQ(unsortMap);

			System.out.println("\nExistem " + unsortMap.size() + " clientes que compraram " + s);

		} else {
			System.out.println("A quantidade que inseriu é inválida!");
		}
	}
	
	public void clientesDiferentesProdutos(){
		
		
		
		
		
		
		
		
	}
	

	
	
}
	
	
	

	
	
	

	

	
	
	
	
	
	
	

