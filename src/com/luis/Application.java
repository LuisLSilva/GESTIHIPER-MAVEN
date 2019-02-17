package com.luis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	
	public static void main(String[] args) {
		
		Validador validador = new Validador();
		Hipermercado hipermercado = new Hipermercado();
		
		List<Hipermercado> arraylist = new ArrayList<Hipermercado>();
		
		
		System.out.print("Escolha uma opção:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		System.out.println("");
		
		String strCurrentLine;
	//	int choice=3;
		
		switch (choice) {
		
			case 1:
				System.out.println("Escolheu a opção 1");
				System.out.println(" ");
	
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichClientes.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						
						Ccliente ccliente = validador.validacaoCliente(strCurrentLine);
						hipermercado.addCcliente(ccliente);
						
					}
					objReader.close();
					
					arraylist.add(hipermercado);
					
					for(int i=0; i<arraylist.size(); i++){
						System.out.println(arraylist.get(0).toString());
							
					}
						
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
	
			case 2:
				System.out.println("Escolheu a opção 2");
				System.out.println(" ");
	
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichProdutos.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						
						Cproduto cproduto = validador.validacaoProduto(strCurrentLine);
						hipermercado.addCproduto(cproduto);
						
					}
					objReader.close();
					
					arraylist.add(hipermercado);
								
					for(int i=0; i<arraylist.size(); i++){
						System.out.println(arraylist.get(0).toString());
							
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Escolheu a opção 3");
				
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						String[] lineSplitter = strCurrentLine.split(" ");
	
						Compra compra = validador.validacao(lineSplitter);
						hipermercado.addCompra(compra);
						
					}
					objReader.close();
					
					arraylist.add(hipermercado);
					
					for(int i=0; i<arraylist.size(); i++){
						System.out.println(arraylist.get(0).getListCompra().toString());
							
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			default:
				System.out.println("Não escolheu opção nenhuma");
			}

	}

}
