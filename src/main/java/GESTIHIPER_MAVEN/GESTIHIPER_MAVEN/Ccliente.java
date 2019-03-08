package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashMap;
import java.util.Map;

public class Ccliente {
	private Map<String, DadosCliente> gavetaClientes;
	private String idCliente;

	public Ccliente() {
		super();
		this.gavetaClientes = new HashMap<String, DadosCliente>();
	}
	
	public Ccliente(String idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public void put(Ccliente ccliente){
		gavetaClientes.put(ccliente.getIdCliente(), null);
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Map<String, DadosCliente> getGavetaClientes() {
		return gavetaClientes;
	}

	public void setGavetaClientes(Map<String, DadosCliente> gavetaClientes) {
		this.gavetaClientes = gavetaClientes;
	}

	public void addCompraCliente(Compra compra){
		//Caso já exista 'values' no HashMap de Ccliente
		DadosCliente dadosC = gavetaClientes.get(compra.getIdCliente());
		
		if(dadosC == null){
			dadosC = new DadosCliente();
			dadosC.setNumeroCompras(compra.getQuantidade());
			dadosC.setValorGasto(compra.getPreco()*compra.getQuantidade());
			dadosC.setIdCliente(compra.getIdCliente());
			dadosC.addCompraMensal(compra);
			dadosC.getProdutosDistintos().add(compra.getIdProduto());
			
			gavetaClientes.put(compra.getIdCliente(), dadosC);
			return;
		}
			
		//Já existem dados neste ponto
		dadosC.addCompraMensal(compra);
		dadosC.getProdutosDistintos().add(compra.getIdProduto());
		dadosC.getClientesDistintos().add(compra.getIdCliente());

		gavetaClientes.put(compra.getIdCliente(), dadosC);
	}
	
	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
	}
	
	@Override
	public String toString() {
		return "Cclientes [idClientes=" + idCliente + "]";
	}
	
}

