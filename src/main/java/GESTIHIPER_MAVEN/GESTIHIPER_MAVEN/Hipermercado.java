package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Hipermercado {
	
	private List<Ccliente> listCcliente = new ArrayList<Ccliente>();
	private List<Cproduto> listCproduto = new ArrayList<Cproduto>();
	private List<Compra> listCompra = new ArrayList<Compra>();
	private Ccliente catalogoClientes;
	private Cproduto catalogoProdutos;
	private Validador validador;
	private HashSet<String> clientesDistintos = new HashSet<String>();
	private Map<String, DadosCliente> sortedMap;
	private Map<String, DadosProduto> sortedMapCXP;
	
	public Hipermercado(Validador validador) {
		super();
		catalogoClientes = new Ccliente();
		catalogoProdutos = new Cproduto();
		this.validador = validador;
	}

	public void addCompra(Compra compra){
		listCompra.add(compra);
		catalogoProdutos.addCompraProduto(compra);
		catalogoClientes.addCompraCliente(compra);
	}
	
	public List<Ccliente> getListCcliente() {
		return listCcliente;
	}

	public void setListCcliente(List<Ccliente> listCcliente) {
		this.listCcliente = listCcliente;
	}

	public Ccliente getCatalogoClientes() {
		return catalogoClientes;
	}

	public void setCatalogoClientes(Ccliente catalogoClientes) {
		this.catalogoClientes = catalogoClientes;
	}

	public Cproduto getCatalogoProdutos() {
		return catalogoProdutos;
	}

	public void setCatalogoProdutos(Cproduto catalogoProdutos) {
		this.catalogoProdutos = catalogoProdutos;
	}

	public List<Cproduto> getListCproduto() {
		return listCproduto;
	}

	public void setListCproduto(List<Cproduto> listCproduto) {
		this.listCproduto = listCproduto;
	}

	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}
	
	public void addCcliente(Ccliente ccliente) {
		listCcliente.add(ccliente);
	}
	
	public void addCproduto(Cproduto cproduto) {
		listCproduto.add(cproduto);
	}
	
	@Override
	public String toString() {
		return "Hipermercado [listCcliente=" + listCcliente + ", listCproduto=" + listCproduto + ", listCompra="
				+ listCompra+"]";
	}

	
//Query 1 - Consulta Estatística ---------------------------------------------------------------------------------------------------------------------	
	
	public void totalComprasMes() {

		int quantidadeTotal = 0;

		for (int j = 1; j < 13; j++) {
			for (int i = 0; i < this.getListCompra().size(); i++) {
				if (j == this.getListCompra().get(i).getMes()) {
					quantidadeTotal = quantidadeTotal + this.getListCompra().get(i).getQuantidade();
				}
			}
			System.out.println("O mês:" + j + " foram feitas:" + quantidadeTotal+" compras.");
			quantidadeTotal = 0;
		}
	}
	
//Query 2 - Consulta Estatística -------------------------------------------------------------------------------------------------------------------------------------	
	
	public void totalGlobal() {

		double totalMes = 0;
		double totalGlobal = 0;

		for (int j = 1; j < 13; j++) {
			for (int i = 0; i < this.getListCompra().size(); i++) {
				if (j == this.getListCompra().get(i).getMes()) {
					totalMes = totalMes
							+ this.getListCompra().get(i).getPreco() * this.getListCompra().get(i).getQuantidade();
				}
			}
			System.out.println("O mês:" + j + " totalidade do mes:" + totalMes + " euros");
			double temp = totalMes;
			totalMes = 0;
			totalGlobal += temp;
		}
		System.out.println("\nA faturaçãoo Global: " + totalGlobal + " euros");
	}
	
//Query 3 - Consulta Estatística ---------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void clientesDistintos() {

		for (int j = 1; j < 13; j++) {
			for (Compra i : this.getListCompra()) {
				if (j == i.getMes()) {
					this.clientesDistintos.add(i.getIdCliente());
				}
			}

			System.out.println("\nClientes do mes: " + j);
			for (String temp : clientesDistintos) {
				System.out.println(temp);
			}
			clientesDistintos.clear();
		}
	}
	
//Query 4 - Consulta Estatística ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void comprasInvalidas() {

		System.out.println("Existem " + validador.getComprasInvalidas().size()
				+ " compras inv�lidas\nConsulte o ficheiro ComprasInvalidas.txt");

		try {
			BufferedWriter objWriter = new BufferedWriter(new FileWriter("ComprasInvalidas.txt"));
			String newLine = System.getProperty("line.separator");

			for (int i = 0; i < validador.getComprasInvalidas().size(); i++) {
				objWriter.write(validador.getComprasInvalidas().get(i) + " " + newLine);
			}
			objWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
// Query 1 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void produtosNaoComprados() {
		int cnt=0;
		Map<String, DadosProduto> tMap = new TreeMap<String, DadosProduto>(getCatalogoProdutos().getGavetaProdutos());
		
		System.out.println("Códigos de produtos nunca comprado:");
		for(Entry<String, DadosProduto> entry: tMap.entrySet()){
			if(entry.getValue()== null){
				System.out.println("ID do Produto: " + entry.getKey());
				cnt++;
			}	
		}
		System.out.println("\nO número total de produtos nunca comprados: "+cnt);
	}
	
// Query 2 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void clientesNuncaCompraram(){
		int cnt=0;
		Map<String, DadosCliente> tMap = new TreeMap<String, DadosCliente>(getCatalogoClientes().getGavetaClientes());
		
		System.out.println("Códigos de clientes que nunca compraram:");
		for(Entry<String, DadosCliente> entry: tMap.entrySet()){
			if(entry.getValue()== null){
				System.out.println("ID do Cliente: " + entry.getKey());
				cnt++;
			}	
		}
		System.out.println("\nO número de clientes que nunca compraram: "+cnt);
	}
	
// Query 3 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void numeroComprasEclientesPorMes() {

		System.out.print("Insira um mês de 1 a 12: ");
		Scanner sc = new Scanner(System.in);
		int mes = sc.nextInt();
		
		for (Entry<String, DadosProduto> entry : getCatalogoProdutos().getGavetaProdutos().entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue().getMensal().containsKey(mes)) {
					System.out.println("Produto comprado: " + entry.getKey() + ", Quantidade: "
							+ entry.getValue().getMensal().get(mes).getTotalCompras() + ", Clientes Distintos: "
							+ entry.getValue().getMensal().get(mes).getClientesDistintos());
				}
			}
		}
	}
	
// Query 4 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void codigoClienteParaMes() {
		
		System.out.print("Introduza o código de um cliente:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		System.out.println("\nO cliente "+input+":");
		for (Entry<String, DadosCliente> entry : getCatalogoClientes().getGavetaClientes().entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue().getIdCliente().equals(input)) {
					for (Entry<Integer, DadosMesCliente> entry2 : entry.getValue().getMensalCliente().entrySet()) {
						System.out.println("No Mês:"+entry2.getKey() + ", fez um total número de compras:" + entry2.getValue().getTotalCompras() + ", adquiriu os seguintes produtos:"
								+ entry2.getValue().getProdutosDistintos() + " e gastou na totalidade:" + entry2.getValue().getFaturacao()+" euros");
					}
				}
			}
		}
	}
	
// Query 5 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void codigoProdutoMesaMes() {

		System.out.print("Introduza um código de um produto existente:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		for (Entry<String, DadosProduto> entry : getCatalogoProdutos().getGavetaProdutos().entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue().getIdProduto().equals(input)) {
					for (Entry<Integer, DadosMesProduto> entry2 : entry.getValue().getMensal().entrySet()) {
						System.out.println("No Mês: " + entry2.getKey() + ", Total Número de Compras: "
								+ entry2.getValue().getTotalCompras() + ",  Clientes Distintos: "
								+ entry2.getValue().getClientesDistintos() + ", Total Faturado: "
								+ entry2.getValue().getFaturacao()+" euros.");
					}
				}
			}
		}
	}
	
//Query 6 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void codigoProdutoNP() {
		
		System.out.print("Introduza um código de um produto existente:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		for (Entry<String, DadosProduto> entry : getCatalogoProdutos().getGavetaProdutos().entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue().getIdProduto().equals(input)) {
					for (Entry<Integer, DadosMesProduto> entry2 : entry.getValue().getMensal().entrySet()) {
						System.out.println("No mês: " + entry2.getKey() + ", Total Número de Compras em modo Promoção: "
								+ entry2.getValue().getComprasModoP() + ", Total Número de Compras em Modo Normal: "
								+ entry2.getValue().getComprasModoN() + ", Total Faturado: "
								+ entry2.getValue().getFaturacao());
					}
				}
			}
		}
	}
	
// Query 7 - Consulta Interactiva ------------------------------------------------------------------------------------------------------------------------------------------
	public void clienteListaProdutos() {
		System.out.print("Introduza um código de um cliente:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		System.out.println("\nO cliente " + input + " comprou os seguintes produtos:");
		DadosCliente dadosClienteInput = this.getCatalogoClientes().getGavetaClientes().get(input);
		if (dadosClienteInput == null)
			return;

		Map<String, DadosClienteProduto> tMap = new TreeMap<String, DadosClienteProduto>(dadosClienteInput.getQuantidadeProdutoPorCliente());
		if (tMap == null)
			return;

		Map<String, DadosClienteProduto> sortedMap = sortByValue(tMap);
		printMapPQ(sortedMap);
	}

	public static <K,V> void printMapPQ(Map<K,V> map){
		for(Map.Entry<K, V> entry: map.entrySet()){
			System.out.println("Produto comprado: " + entry.getKey() + " "+entry.getValue());
		}
	}	

	// Ordena por valor descendente, o conte�do do HashMap
	public static Map<String, DadosClienteProduto> sortByValue(Map<String, DadosClienteProduto> unsortMap) {

		List<Map.Entry<String, DadosClienteProduto>> list = new LinkedList<Map.Entry<String, DadosClienteProduto>>(
				unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, DadosClienteProduto>>() {

			public int compare(Map.Entry<String, DadosClienteProduto> o1, Map.Entry<String, DadosClienteProduto> o2) {
				return o2.getValue().getQuantidade().compareTo(o1.getValue().getQuantidade());
			}
		});

		Map<String, DadosClienteProduto> sortedMap = new LinkedHashMap<String, DadosClienteProduto>();
		for (Map.Entry<String, DadosClienteProduto> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
		

// Query 8 - Consulta Interactiva ---------------------------------------------------------------------------------------------------------------------------------------
	public void conjuntoXprodutos() {
		
		Map<String, DadosProduto> tMap = new TreeMap<String, DadosProduto>(this.getCatalogoProdutos().getGavetaProdutos());
		int cnt = -1;
	
		for (Iterator<?> it = tMap.values().iterator(); it.hasNext();) {
			if (it.next() == null) {		
				it.remove();	
			}
		}
		
		System.out.print("Introduza um número que determine o conjunto dos produtos mais vendidos:");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("\nOutput de Dados:");
		
		
		for (Entry<String, DadosProduto> entry : tMap.entrySet()) {
			if (entry.getValue() != null) {
				sortedMapCXP = sortByValueCXP(tMap);	
			}
		}
		
		for(Map.Entry<String, DadosProduto> entry: sortedMapCXP.entrySet()){
			cnt++;
			//System.out.println(cnt++);
			if(cnt != input){
				System.out.println("Produto:" + entry.getKey() + ", Quantidade:" + entry.getValue().getNumeroCompras()+ ", Número de clientes distintos:" + entry.getValue().getClientesDistintos().size());
			}
			else{
				return;
			}
		}
	}
	
	// Ordena por valor descendente, o conteúdo do HashMap
	public static Map<String, DadosProduto> sortByValueCXP(Map<String, DadosProduto> unsortMap) {

		List<Map.Entry<String, DadosProduto>> list = new LinkedList<Map.Entry<String, DadosProduto>>(
				unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, DadosProduto>>() {

			public int compare(Map.Entry<String, DadosProduto> o1, Map.Entry<String, DadosProduto> o2) {
				return o2.getValue().getNumeroCompras().compareTo(o1.getValue().getNumeroCompras());
			}
		});

		Map<String, DadosProduto> sortedMap = new LinkedHashMap<String, DadosProduto>();
		for (Map.Entry<String, DadosProduto> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
		
//Query 9 - Consulta Interactiva -------------------------------------------------------------------------------------------------------------------------------------------
	public void clientesDiferentesProdutos() {
		
		Map<String, DadosCliente> tMap = new TreeMap<String, DadosCliente>(this.getCatalogoClientes().getGavetaClientes());
		int cnt=-1;
		
		for (Iterator<?> it = tMap.values().iterator(); it.hasNext();) {
			if (it.next() == null) {
				it.remove();
			}
		}
			
		System.out.print("Introduza um número que determine o conjunto dos clientes mais que mais compraram:");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("\nOutput de Dados:");
		
		for(Entry<String, DadosCliente> entry: tMap.entrySet()){
			if(entry.getValue() != null){
				sortedMap = sortByValueCDP(tMap);    
			}
		}
		
		for(Map.Entry<String, DadosCliente> entry: sortedMap.entrySet()){
			cnt++;
			if(cnt != input){
				System.out.println("O cliente: "+entry.getKey()+", comprou " +entry.getValue().getProdutosDistintos().size()+" produtos distintos.");
			}
			else{
				return;
			}
		}
	}
	
	public static Map<String, DadosCliente> sortByValueCDP(Map<String, DadosCliente> unsortMap) {

		Set<Entry<String, DadosCliente>> set = unsortMap.entrySet();
		List<Entry<String, DadosCliente>> listOfEntry = new ArrayList<Entry<String, DadosCliente>>(set);
		Collections.sort(listOfEntry, new Comparator<Map.Entry<String, DadosCliente>>() {
			public int compare(Map.Entry<String, DadosCliente> o1, Map.Entry<String, DadosCliente> o2) {
				if(o1.getValue().getClientesDistintos().size()< o2.getValue().getClientesDistintos().size())
					return 1;
				
				if(o1.getValue().getClientesDistintos().size() >  o2.getValue().getClientesDistintos().size())
					return -1;
				
				if(o1.getValue().getClientesDistintos().size() ==  o2.getValue().getClientesDistintos().size())
					return o1.getKey().compareTo(o2.getKey());
				return 0;
			}
		});
		return unsortMap;
	}
	
//Query 10 - Consulta Interactiva -----------------------------------------------------------------------------------------------------------------------------------------
		public void produtoClientesQueMaisCompraram() {
			
		    int cnt=-1;
			
			System.out.print("Introduza o código de um produto:");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			System.out.print("Introduza um número que determine o conjunto dos clientes que mais compraram e o valor que gastaram:");
			int inputInt = sc.nextInt();
			System.out.println("\nOutput de Dados:");
			
			DadosProduto dadosProdutoInput = this.getCatalogoProdutos().getGavetaProdutos().get(input);
			if (dadosProdutoInput == null)
				return;
			
			Map<String, DadosCliente> tMap = new TreeMap<String, DadosCliente>(this.getCatalogoClientes().getGavetaClientes());
			
			for (Iterator<?> it = tMap.values().iterator(); it.hasNext();) {
				if (it.next() == null) {
					it.remove();
				}
			}
		
			for(Map.Entry<String, DadosCliente> entry: tMap.entrySet()){
				if(entry.getValue() !=null){
					sortedMap = sortByValuePC(tMap);    
				}
			}
			
			System.out.println("O produto inserido: "+dadosProdutoInput.getIdProduto()+", "+ "foi vendido aos seguintes clientes: "+ dadosProdutoInput.getClientesDistintos()+", foi comprado: "+dadosProdutoInput.getNumeroCompras()+" vezes, e faturou: "+ dadosProdutoInput.getTotalFaturado()+"\n");
			
			for(Map.Entry<String, DadosCliente> entry: sortedMap.entrySet()){
				cnt++;
				if(cnt!= inputInt){
					System.out.println("Cliente: " + entry.getKey() + ", Número de compras: "+entry.getValue().getNumeroCompras()+ ", Valor Gasto: "+entry.getValue().getValorGasto());
				}
				else{
					return;
				}
			}
		}	
		
	    // Ordena por valor descendente, o conte�do do HashMap
		public static Map<String, DadosCliente> sortByValuePC(Map<String, DadosCliente> unsortMap) {

			List<Map.Entry<String, DadosCliente>> list = new LinkedList<Map.Entry<String, DadosCliente>>(
					unsortMap.entrySet());

			Collections.sort(list, new Comparator<Map.Entry<String, DadosCliente>>() {

				public int compare(Map.Entry<String, DadosCliente> o1, Map.Entry<String, DadosCliente> o2) {
					return o2.getValue().getNumeroCompras().compareTo(o1.getValue().getNumeroCompras());
				}
			});

			Map<String, DadosCliente> sortedMap = new LinkedHashMap<String, DadosCliente>();
			for (Map.Entry<String, DadosCliente> entry : list) {
				sortedMap.put(entry.getKey(), entry.getValue());
			}

			return sortedMap;
		}	
}
