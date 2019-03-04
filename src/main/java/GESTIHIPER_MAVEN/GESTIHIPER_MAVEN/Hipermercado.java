package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class Hipermercado {
	private List<Ccliente> listCcliente = new ArrayList<Ccliente>();
	private List<Cproduto> listCproduto = new ArrayList<Cproduto>();
	private List<Compra> listCompra = new ArrayList<Compra>();
	private Contabilidade contabilidade;
	
	private Ccliente catalogoClientes;
	private Cproduto catalogoProdutos;
	
	public Hipermercado() {
		super();
		catalogoClientes = new Ccliente();
		catalogoProdutos = new Cproduto();
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
	
	//Query 3 - Consulta Interactiva
	public void numeroComprasEclientesPorMes() {
		
		System.out.print("Insira um mês de 1 a 12: ");
		Scanner sc = new Scanner(System.in);
		int mes=sc.nextInt();
		
		for(Entry<String, DadosProduto> entry: catalogoProdutos.getGavetaProdutos().entrySet()){
				if(entry.getValue()!=null){
					if(entry.getValue().getMensal().containsKey(mes)){
						System.out.println("Produto comprado: " +entry.getKey()+"  Quantidade: "+entry.getValue().getNumeroCompras() + " Clientes Distintos: "+ entry.getValue().getClientesDistintos());
					}
				}
		}
		
	}

	//Query 6 - Consulta Interactiva
	public void codigoProdutoNP() {
		
		System.out.print("Introduza um código de um produto existente:");
		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine();
		
			for(Entry<String, DadosProduto> entryMes: catalogoProdutos.getGavetaProdutos().entrySet()){
				if(entryMes.equals(input)){
					System.out.println(entryMes.getKey() + "   "+ entryMes.getValue().getMensal().entrySet());
				}
					
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
