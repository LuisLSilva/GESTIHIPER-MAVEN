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
		int queryEst;
		int queryInt;
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
							ccliente.put(ccliente);
							hipermercado.addCcliente(ccliente);
							hipermercado.setCatalogoClientes(ccliente);
						}
					}
					objReader.close();

		//			arraylist.add(hipermercado);
					
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
				     //		cproduto.put(cproduto);
							hipermercado.addCproduto(cproduto);
							hipermercado.setCatalogoProdutos(cproduto);
						}
					}
					objReader.close();

		//			arraylist.add(hipermercado);
					
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
		//			arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro das compras foi carregado.");
					choice=5;
		
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.println("Foi escolhida a opção 4:Queries \n");
				
				System.out.println("Query 01 - Número total de compras por mês.");
				System.out.println("Query 02 - Facturação total por mês e o total Global.");
				System.out.println("Query 03 - Número distintos clientes que compraram em cada mês.");
				System.out.println("Query 04 - Total de registos de compras inválidos.");
				
				
				do {
					
					System.out.print("\nEscolha uma query:");
					
					queryEst = sc.nextInt();
					
					System.out.println("");

					switch (queryEst) {

					case 1:
						System.out.println("Foi escolhida a query 01 - Número Total de Compras por mês: \n");
						consulta.totalComprasMes();
						break;

					case 2:
						System.out.println("Foi escolhida a query 02 - Valor total das compras/vendas e total global\n");	
						consulta.totalGlobal();
						break;
						
					case 3:
						System.out.println("Foi escolhida a query 03 - Número distintos de clientes que compraram cada mês\n");
						consulta.clientesDistintos();
						break;
					
					case 4:	
						System.out.println("Foi escolhida a query 04 - Total de registos de compras inválidas\n");
						consulta.comprasInvalidas();
						break;
						
					
					default:
						System.out.println("\nEscolha uma query de 1 a 15!");
					}
				}while(queryEst<5);	
							
				break;
				
			case 5:	
				
				System.out.println("Query 01 - Lista ordenada com os códigos dos produtos nunca comprados e respetivo total.");
				System.out.println("Query 02 - Lista Ordenada com os códigos dos clientes que nunca compraram e seu total.");
				System.out.println("Query 03 - Dado um mês Válido, é determinado o número total de compras e o total de clientes distintos que as realizaram.");
				System.out.println("Query 04 - Dado um código de cliente, é determinado, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou. É apresentado também o total anual faturado ao cliente.");
				System.out.println("Query 05 - Dado um código de um produto existente, é determinado, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
				System.out.println("Query 06 - Dado o código de um produto existente, é determinado, mês a mês, quantas vezes foi comprado em modo N e em modo P e respetivas facturações.");
				System.out.println("Query 07 - Dado o código de um cliente, é determinado a lista de códigos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfabética dos códigos");
				System.out.println("Query 08 - É determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o número total de distintos clientes que o compraram.");
				System.out.println("Query 09 - É determinado os clientes que compraram um maior número de diferentes produtos indicando quantos.");
				System.out.println("Query 10 - Dado o código de um produto, é determinado o conjunto dos X clientes que mais o compraram e qual o valor gasto."); 
				
				do {

					System.out.print("\nEscolha uma query:");

					queryInt = sc.nextInt();

					System.out.println("");

					switch (queryInt) {

						case 1:
							System.out.println("Foi escolhida a query 01 - Lista Ordenada com os códigos dos produtos nunca comprados e o respectivo total\n");
						    consulta.produtosNaoComprados();
							break;
							
						case 2:
							System.out.println("Foi escolhida a query 02 - Lista Ordenada com os códigos dos clientes que nunca compraram e seu total\n");
						    consulta.clientesNuncaCompraram();
						    break;
						
						case 3:
							System.out.println("Foi escolhida a query 03 - Dado um mês Válido, é determinado o número total de compras e o total de clientes distintos que as realizaram.");
							consulta.numeroComprasEclientesPorMes();
							break;
						
						case 4:
							System.out.println("Foi escolhida a query 04 - Dado um código de cliente, é determinado, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou. É apresentado também o total anual faturado ao cliente."); 
							consulta.codigoClienteParaMes();
							break;
						
						case 5:	
							System.out.println("Foi escolhida a query 05 - Dado um código de um produto existente, é determinado, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
							consulta.codigoProdutoMesaMes();
							break;
							
						case 6:
							System.out.println("Foi escolhida a query 06 - Dado o código de um produto existente, é determinado, mês a mês, quantas vezes foi comprado em modo N e em modo P e respetivas facturações.");
							consulta.codigoProdutoNP();
							break;
						
						
						case 7:
							System.out.println("Foi escolhida a query 07 - Dado o código de um cliente, é determinado a lista de códigos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfabética dos códigos");
							consulta.clienteListaProdutos();
						    break;
						
						case 8:
							System.out.println("Foi escolhida a query 08 - É determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o número total de distintos clientes que o compraram.");
						    consulta.conjuntoXprodutos();
						    break;
						    
						case 9:
							System.out.println("Foi escolhida a query 09 - É determinado os clientes que compraram um maior número de diferentes produtos indicando quantos.");
						    consulta.clientesDiferentesProdutos();
						    break;
						    
						case 10:
							System.out.println("Foi escolhida a query 10 - Dado o código de um produto, é determinado o conjunto dos X clientes que mais o compraram e qual o valor gasto."); 
						    consulta.produtoClientesQueMaisCompraram();
							break;
						
					}
				} while (queryInt < 11);

			case 6:	
				System.out.println("Operação terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("Não escolheu opção nenhuma");
			}

		} while (choice < 10);
		
	}
}
	

		
