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
		int choice=1;
		int choiceQuery;
		Validador validador = new Validador();
		Hipermercado hipermercado = new Hipermercado();
		Consulta consulta = new Consulta(hipermercado, validador);

	   		
		List<Hipermercado> arraylist = new ArrayList<Hipermercado>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Carregue o ficheiro dos clientes\n2. Carregue o ficheiro dos produtos\n3. Carregue o ficheiro das compras\n4. Consulte as queries\n5. Terminar operação.");
				
		do {
			System.out.println("");
			System.out.print("Escolha uma opção:");
			
	//		choice = sc.nextInt();
			
			System.out.println("");

			String strCurrentLine;
		
			switch (choice) {

			case 1:
				System.out.println("Foi escolhida a opção 1: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichClientes.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						if(validador.validacaoCliente(strCurrentLine)!=null){
							Ccliente ccliente = validador.validacaoCliente(strCurrentLine);
							hipermercado.addCcliente(ccliente);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro de clientes foi carregado.");
					choice++;
					
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
							Cproduto cproduto = validador.validacaoProduto(strCurrentLine);
							hipermercado.addCproduto(cproduto);
						}
					}
					objReader.close();

					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro dos produtos foi carregado.");
					choice++;

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
		   
						}
					}
				
					objReader.close();
					arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro das compras foi carregado.");
					choice++;
		
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.println("Foi escolhida a opção 4:Queries \n");
				
				System.out.println("Query 1 - Número total de compras por mês.");
				System.out.println("Query 2 - Facturação total por mês e o total Global.");
				System.out.println("Query 3 - Número distintos clientes que compraram em cada mês.");
				System.out.println("Query 4 - Total de registos de compras inválidos.");
				System.out.println("Query 5 - Lista ordenada com os códigos dos produtos nunca comprados e respetivo total.");
				System.out.println("Query 6 - Lista Ordenada com os códigos dos clientes que nunca compraram e seu total.");
				System.out.println("Query 7 - Dado um mês Válido, é determinado o número total de compras e o total de clientes distintos que as realizaram.");
				System.out.println("Query 8 - Dado um código de cliente, é determinado, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou. É apresentado também o total anual faturado ao cliente.");
				do {
					
					System.out.print("\nEscolha uma query:");
					
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
						
					case 3:
						System.out.println("Foi escolhida a query 3 - Número distintos de clientes que compraram cada mês\n");
						consulta.clientesDistintos();
						break;
					
					case 4:	
						System.out.println("Foi escolhida a query 4 - Total de registos de compras inválidas\n");
						consulta.comprasInvalidas();
						break;
						
					case 5:
						System.out.println("Foi escolhida a query 5 - Lista Ordenada com os códigos dos produtos nunca comprados e o respectivo total\n");
					    consulta.produtosNaoComprados();
						break;
						
					case 6:
						System.out.println("Foi escolhida a query 6 - Lista Ordenada com os códigos dos clientes que nunca compraram e seu total\n");
					    consulta.clientesNuncaCompraram();
					    break;
					
					case 7:
						System.out.println("Foi escolhida a query 7 - Dado um mês Válido, é determinado o número total de compras e o total de clientes distintos que as realizaram.");
						consulta.numeroComprasEclientesPorMes();
						break;
					
					case 8:
						System.out.println("Foi escolhida a query 8 - Dado um código de cliente, é determinado, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou. É apresentado também o total anual faturado ao cliente."); 
						consulta.codigoClienteParaMes();
						break;
					}
			
				}while(choiceQuery<10);	
							
				break;
	
			case 5:	
				System.out.println("Operação terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("Não escolheu opção nenhuma");
			}

		} while (choice < 10);
		
	}
}
	

		
