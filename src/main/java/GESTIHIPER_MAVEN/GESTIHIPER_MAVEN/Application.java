package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

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
		
		System.out.println("1. Carregue o ficheiro dos clientes\n2. Carregue o ficheiro dos produtos\n3. Carregue o ficheiro das compras\n4. Consulte as queries\n5. Terminar opera��o.");
				
		do {
			System.out.println("");
			System.out.print("Escolha uma op��o:");
			
	//		choice = sc.nextInt();
			
			System.out.println("");

			String strCurrentLine;
		
			switch (choice) {

			case 1:
				System.out.println("Foi escolhida a op��o 1: \n");
		
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
				System.out.println("Foi escolhida a op��o 2: \n");
		
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("FichProdutos.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {

						if (validador.validacaoProduto(strCurrentLine)) {
							hipermercado.getCatalogoProdutos().getGavetaProdutos().put(strCurrentLine, null);	
						}
					}
					Cproduto.printMapAA(hipermercado.getCatalogoProdutos().getGavetaProdutos());
					objReader.close();

					// arraylist.add(hipermercado);

					System.out.println("O Ficheiro dos produtos foi carregado.");
					choice++;

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Foi escolhida a op��o 3: \n");
	
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
					System.out.print("\n");
					Cproduto.printMapAA(hipermercado.getCatalogoProdutos().getGavetaProdutos());
			//		System.out.println(new PrettyPrintingMap<>(hipermercado.getCatalogoProdutos().getGavetaProdutos()));

					objReader.close();
		//			arraylist.add(hipermercado);
					
					System.out.println("O Ficheiro das compras foi carregado.");
					choice=5;
		
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
				
			case 4:
				System.out.println("Foi escolhida a op��o 4:Queries \n");
				
				System.out.println("Query 01 - N�mero total de compras por m�s.");
				System.out.println("Query 02 - Factura��o total por m�s e o total Global.");
				System.out.println("Query 03 - N�mero distintos clientes que compraram em cada m�s.");
				System.out.println("Query 04 - Total de registos de compras inv�lidos.");
				
				
				do {
					
					System.out.print("\nEscolha uma query:");
					
					queryEst = sc.nextInt();
					
					System.out.println("");

					switch (queryEst) {

					case 1:
						System.out.println("Foi escolhida a query 01 - N�mero Total de Compras por m�s: \n");
						consulta.totalComprasMes();
						break;

					case 2:
						System.out.println("Foi escolhida a query 02 - Valor total das compras/vendas e total global\n");	
						consulta.totalGlobal();
						break;
						
					case 3:
						System.out.println("Foi escolhida a query 03 - N�mero distintos de clientes que compraram cada m�s\n");
						consulta.clientesDistintos();
						break;
					
					case 4:	
						System.out.println("Foi escolhida a query 04 - Total de registos de compras inv�lidas\n");
						consulta.comprasInvalidas();
						break;
						
					
					default:
						System.out.println("\nEscolha uma query de 1 a 15!");
					}
				}while(queryEst<5);	
							
				break;
				
			case 5:	
				
				System.out.println("Query 01 - Lista ordenada com os c�digos dos produtos nunca comprados e respetivo total.");
				System.out.println("Query 02 - Lista Ordenada com os c�digos dos clientes que nunca compraram e seu total.");
				System.out.println("Query 03 - Dado um m�s V�lido, � determinado o n�mero total de compras e o total de clientes distintos que as realizaram.");
				System.out.println("Query 04 - Dado um c�digo de cliente, � determinado, para cada m�s, quantas compras fez, quantos produtos distintos comprou e quanto gastou. � apresentado tamb�m o total anual faturado ao cliente.");
				System.out.println("Query 05 - Dado um c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
				System.out.println("Query 06 - Dado o c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado em modo N e em modo P e respetivas factura��es.");
				System.out.println("Query 07 - Dado o c�digo de um cliente, � determinado a lista de c�digos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfab�tica dos c�digos");
				System.out.println("Query 08 - � determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o n�mero total de distintos clientes que o compraram.");
				System.out.println("Query 09 - � determinado os clientes que compraram um maior n�mero de diferentes produtos indicando quantos.");
				System.out.println("Query 10 - Dado o c�digo de um produto, � determinado o conjunto dos X clientes que mais o compraram e qual o valor gasto."); 
				
				do {

					System.out.print("\nEscolha uma query:");

					queryInt = sc.nextInt();

					System.out.println("");

					switch (queryInt) {

						case 1:
							System.out.println("Foi escolhida a query 01 - Lista Ordenada com os c�digos dos produtos nunca comprados e o respectivo total\n");
						    consulta.produtosNaoComprados();
							break;
							
						case 2:
							System.out.println("Foi escolhida a query 02 - Lista Ordenada com os c�digos dos clientes que nunca compraram e seu total\n");
						    consulta.clientesNuncaCompraram();
						    break;
						
						case 3:
							System.out.println("Foi escolhida a query 03 - Dado um m�s V�lido, � determinado o n�mero total de compras e o total de clientes distintos que as realizaram.");
							consulta.numeroComprasEclientesPorMes();
							break;
						
						case 4:
							System.out.println("Foi escolhida a query 04 - Dado um c�digo de cliente, � determinado, para cada m�s, quantas compras fez, quantos produtos distintos comprou e quanto gastou. � apresentado tamb�m o total anual faturado ao cliente."); 
							consulta.codigoClienteParaMes();
							break;
						
						case 5:	
							System.out.println("Foi escolhida a query 05 - Dado um c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado, por quantos clientes diferentes e o total faturado.");
							consulta.codigoProdutoMesaMes();
							break;
							
						case 6:
							System.out.println("Foi escolhida a query 06 - Dado o c�digo de um produto existente, � determinado, m�s a m�s, quantas vezes foi comprado em modo N e em modo P e respetivas factura��es.");
							consulta.codigoProdutoNP();
							break;
						
						
						case 7:
							System.out.println("Foi escolhida a query 07 - Dado o c�digo de um cliente, � determinado a lista de c�digos que mais comprou, e quantos, ordenada por ordem descrescente de quantidade e para quantidades iguais, por ordem alfab�tica dos c�digos");
							consulta.clienteListaProdutos();
						    break;
						
						case 8:
							System.out.println("Foi escolhida a query 08 - � determinado o conjunto dos produtos mais vendidos em todo o ano, indicando o n�mero total de distintos clientes que o compraram.");
						    consulta.conjuntoXprodutos();
						    break;
						    
						case 9:
							System.out.println("Foi escolhida a query 09 - � determinado os clientes que compraram um maior n�mero de diferentes produtos indicando quantos.");
						    consulta.clientesDiferentesProdutos();
						    break;
						    
						case 10:
							System.out.println("Foi escolhida a query 10 - Dado o c�digo de um produto, � determinado o conjunto dos X clientes que mais o compraram e qual o valor gasto."); 
						    consulta.produtoClientesQueMaisCompraram();
							break;
						
					}
				} while (queryInt < 11);

			case 6:	
				System.out.println("Opera��o terminada");
				sc.close();
				System.exit(0);
					
			default:
				System.out.println("N�o escolheu op��o nenhuma");
			}

		} while (choice < 10);
		
	}
}
	

		
