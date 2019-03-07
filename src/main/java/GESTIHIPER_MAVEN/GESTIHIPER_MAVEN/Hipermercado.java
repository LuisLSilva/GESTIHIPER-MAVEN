package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class Hipermercado {
	private List<Ccliente> listCcliente = new ArrayList<Ccliente>();
	private List<Cproduto> listCproduto = new ArrayList<Cproduto>();
	private List<Compra> listCompra = new ArrayList<Compra>();
	private Contabilidade contabilidade;
	
	private Ccliente catalogoClientes;
	private Cproduto catalogoProdutos;
	private Validador validador;
	
	
	
	public Hipermercado(Validador validador) {
		super();
		catalogoClientes = new Ccliente();
		catalogoProdutos = new Cproduto();
	    this.validador = new Validador();	
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

	public Contabilidade getContabilidade() {
		return contabilidade;
	}
	
	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
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
				+ listCompra + ", contabilidade=" + contabilidade + "]";
	}

	// Query 1 - Consulta Interactiva
	public void produtosNaoComprados() {
		int cnt=0;
		TreeMap<String, DadosProduto> tMap = new TreeMap<String, DadosProduto>(getCatalogoProdutos().getGavetaProdutos());
		
		System.out.println("Códigos de produtos nunca comprado:");
		for(Entry<String, DadosProduto> entry: tMap.entrySet()){
			if(entry.getValue()== null){
				System.out.println("ID do Produto: " + entry.getKey());
				cnt++;
			}	
		}
		System.out.println("\nO número total de produtos nunca comprados: "+cnt);
	}
	
	// Query 2 - Consulta Interactiva
	public void clientesNuncaCompraram(){
		int cnt=0;
		TreeMap<String, DadosCliente> tMap = new TreeMap<String, DadosCliente>(getCatalogoClientes().getGavetaClientes());
		
		System.out.println("Códigos de clientes que nunca compraram:");
		for(Entry<String, DadosCliente> entry: tMap.entrySet()){
			if(entry.getValue()== null){
				System.out.println("ID do Cliente: " + entry.getKey());
				cnt++;
			}	
		}
		System.out.println("\nO número de clientes que nunca compraram: "+cnt);
	}
	
	// Query 3 - Consulta Interactiva
	public void numeroComprasEclientesPorMes() {

		System.out.print("Insira um mês de 1 a 12: ");
		Scanner sc = new Scanner(System.in);
		int mes = sc.nextInt();
		
		
//TODO: BUG FIX -> VALIDADOR		
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
	
	// Query 4 - Consulta Interactiva
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
	
	// Query 5 - Consulta Interactiva
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
	
	//Query 6 - Consulta Interactiva
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

	
//TODO -> BUG FIX -> A quantidade não atualiza pois ainda falta os métodos	
	// Query 7 - Consulta Interactiva
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
		
//TODO: SORTING AND LIMITING BY NUMBER	
	// Query 8 - Consulta Interactiva
	public void conjuntoXprodutos() {
		
		
		System.out.print("Introduza um número que determine o conjunto dos produtos mais vendidos: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for (Entry<String, DadosProduto> entry : getCatalogoProdutos().getGavetaProdutos().entrySet()) {
			if (entry.getValue() != null) {
			
				System.out.println("Produto:" + entry.getKey() + ", Quantidade:" + entry.getValue().getNumeroCompras()
						+ ", Número de clientes distintos:" + entry.getValue().getClientesDistintos().size());
			}
		}
	}
	
//TODO:SORTING AND LIMITING BY NUMBER	
	//Query 9 - Consulta Interactiva
	public void clientesDiferentesProdutos() {
			
		for(Entry<String, DadosCliente> entry: getCatalogoClientes().getGavetaClientes().entrySet()){
			if(entry.getValue() != null){
				System.out.println("O cliente: "+entry.getKey()+", comprou " +entry.getValue().getProdutosDistintos().size()+" distintos.");
				
			}
		}
	}

//TODO:SORTING AND LIMITING BY NUMBER
	//Query 10 - Consulta Interactiva
	public void produtoClientesQueMaisCompraram() {
//		Map<String, DadosProduto> tMap = new TreeMap<String, DadosProduto>(getCatalogoProdutos().getGavetaProdutos());
		
		System.out.print("Introduza o código de um produto:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		DadosProduto dadosProdutoInput = this.getCatalogoProdutos().getGavetaProdutos().get(input);
		if (dadosProdutoInput == null)
			return;
		
		Map<String, DadosCliente> tMap = new TreeMap<String, DadosCliente>(this.getCatalogoClientes().getGavetaClientes());
	
		for(Map.Entry<String, DadosCliente> entry: tMap.entrySet()){
			if(entry.getValue() !=null){
			//    System.out.println(entry.getKey()+", "+entry.getValue().getNumeroCompras()+", "+ entry.getValue().getTotalFaturado()+" euros");
			    Map<String, DadosCliente> temp = new HashMap<String, DadosCliente>();
			    temp.put(entry.getKey(), entry.getValue());
			    Map<String, DadosCliente> sortedMap = sortByValue2(temp);
			    printMapZZ(sortedMap);
			}
		}
	}
		
		public static <String, DadosCliente> void printMapZZ(Map<String, DadosCliente> map){
			for(Map.Entry<String, DadosCliente> entry: map.entrySet()){
				System.out.println("Produto: " + entry.getKey() + " "+entry.getValue());
			}
		}	
		
	
	
	
	
	// Ordena por valor descendente, o conte�do do HashMap
		public static Map<String, DadosCliente> sortByValue2(Map<String, DadosCliente> unsortMap) {

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
