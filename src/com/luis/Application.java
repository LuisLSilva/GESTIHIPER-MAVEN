package com.luis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;

public class Application {

	public static void main(String[] args) {
		int choice;
		int choiceQuery;
		Validador validador = new Validador();
		Hipermercado hipermercado = new Hipermercado();
		Consulta consulta = new Consulta(hipermercado);

	   		
		List<Hipermercado> arraylist = new ArrayList<Hipermercado>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Carregue o ficheiro dos clientes\n2. Carregue o ficheiro dos produtos\n3. Carregue o ficheiro das compras\n4. Consulte as queries");
				
		do {
			System.out.println("");
			System.out.print("Escolha uma opção:");
			
			choice = sc.nextInt();
			
			System.out.println("");

			String strCurrentLine;
		
			switch (choice) {

			case 1:
				System.out.println("Foi escolhida a opção 1: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichClientes.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						if(validador.validacaoCliente(strCurrentLine)!=null){
							System.out.println("O id do cliente " + strCurrentLine + " é válido!");
							System.out.println(" ");
							Ccliente ccliente = validador.validacaoCliente(strCurrentLine);
							hipermercado.addCcliente(ccliente);
						}
						
					}
					objReader.close();

					arraylist.add(hipermercado);

					System.out.println(arraylist.get(0).toString());

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("Foi escolhida a opção 2: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichProdutos.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if(validador.validacaoProduto(strCurrentLine)!=null){
							System.out.println("O id do produto " + strCurrentLine + " é válido \n");
							Cproduto cproduto = validador.validacaoProduto(strCurrentLine);
							hipermercado.addCproduto(cproduto);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);

					System.out.println(arraylist.get(0).toString());

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Foi escolhida a opção 3: \n");
	
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if (validador.validacao(strCurrentLine) != null) {
							Compra compra = validador.validacao(strCurrentLine);
							if(compra == null){
								continue;
							}
							hipermercado.addCompra(compra);
		        //    		hipermercado.hashMapCatalog(key, compra);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);
				
					System.out.println(arraylist.get(0).toString());

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.println("Foi escolhida a opção 4: \n");
				
				do {
					System.out.print("");
					System.out.print("Escolha uma query:");
					
					choiceQuery = sc.nextInt();
					
					System.out.println("");

					switch (choiceQuery) {

					case 1:
						System.out.println("Foi escolhida a query 1 - Número Total de Compras por mês: \n");

						consulta.totalComprasMes();
						break;

					
					
					case 2:
						System.out.println("Foi escolhida a query 2 - Valor total das compras/vendas e total global\n");
						
						consulta.totalGlobal();
						break;
						
						
					}	
					
				}while(choiceQuery!=4);	
				
						
				break;
	
			case 5:	
				System.out.println("Operação terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("Não escolheu opção nenhuma");
			}

		} while (choice != 4);
		
	}
}
	

		
