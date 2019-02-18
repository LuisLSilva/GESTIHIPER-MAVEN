package com.luis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {

	
	public static void main(String[] args) {
		int choice;
		Validador validador = new Validador();
		Hipermercado hipermercado = new Hipermercado();
		
		List<Hipermercado> arraylist = new ArrayList<Hipermercado>();
		Scanner sc = new Scanner(System.in);
		
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
				System.out.println(" ");

				try {
					BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if (validador.validacao(strCurrentLine) != null) {
							Compra compra = validador.validacao(strCurrentLine);
							if(compra == null){
								continue;
							}
							hipermercado.addCompra(compra);
							hipermercado.hashMapCatalog(strCurrentLine, compra);
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
				System.out.println("Operação terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("Não escolheu opção nenhuma");
			}

		} while (choice != 4);
		
	}
}
