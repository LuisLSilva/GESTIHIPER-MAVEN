package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DadosCliente {
	private Map <Integer, DadosMesCliente> mensalCliente;
	private Map <String, DadosClienteProduto> quantidadeProdutoPorCliente;
	private double valorGasto;
	private int numeroCompras;
	private Set<String> produtosDistintos;
	
	private String idCliente;
	
	public DadosCliente() {
		super();
		this.mensalCliente = new HashMap<Integer,DadosMesCliente>();
		this.produtosDistintos = new HashSet<String>();
		this.quantidadeProdutoPorCliente = new HashMap<String , DadosClienteProduto>();
	}

	public Map<String, DadosClienteProduto> getQuantidadeProdutoPorCliente() {
		return quantidadeProdutoPorCliente;
	}

	public void setQuantidadeProdutoPorCliente(Map<String , DadosClienteProduto> quantidadeProdutoPorCliente) {
		this.quantidadeProdutoPorCliente = quantidadeProdutoPorCliente;
	}

	public double getValorGasto() {
		return valorGasto;
	}
	
	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}
	
	public int getNumeroCompras() {
		return numeroCompras;
	}
	
	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}
	
	public Set<String> getProdutosDistintos() {
		return produtosDistintos;
	}
	
	public void setProdutosDistintos(Set<String> produtosDistintos) {
		this.produtosDistintos = produtosDistintos;
	}
	
	public Map<Integer, DadosMesCliente> getMensalCliente() {
		return mensalCliente;
	}

	public void setMensalCliente(Map<Integer, DadosMesCliente> mensalCliente) {
		this.mensalCliente = mensalCliente;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "DadosCliente [valorGasto=" + valorGasto + ", numeroCompras=" + numeroCompras + ", produtosDistintos="
				+ produtosDistintos + "]";
	}

	

	public <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
	}

	public void addCompraMensal(Compra compra) {
	
		DadosClienteProduto dadosCP = quantidadeProdutoPorCliente.get(compra.getIdProduto());
		DadosMesCliente dadosMC = mensalCliente.get(compra.getMes());
		
		if(dadosCP == null){
			dadosCP = new DadosClienteProduto();
			dadosCP.setQuantidade(compra.getQuantidade());
			
			quantidadeProdutoPorCliente.put(compra.getIdProduto(), dadosCP);
		}
		
		if(dadosMC == null){
		   dadosMC = new DadosMesCliente();
		   dadosMC.setFaturacao(compra.getQuantidade()*compra.getPreco());
		   dadosMC.setTotalCompras(compra.getQuantidade());	
			
		   dadosMC.getProdutosDistintos().add(compra.getIdProduto());
		   mensalCliente.put(compra.getMes(), dadosMC);
			
		   return;
		}
		
     	dadosMC.getProdutosDistintos().add(compra.getIdProduto());
    	atualizaNumComprasMensal(compra.getMes(), dadosMC, compra);
    	atualizaFaturacaoMensal(compra.getMes(), dadosMC, compra);
		mensalCliente.put(compra.getMes(), dadosMC);
	}
	
	private void atualizaNumComprasMensal(int mes, DadosMesCliente dadosMC, Compra compra) {
		 int numLista = dadosMC.getTotalCompras();
		 int numLido = compra.getQuantidade();
		 int numAct=numLista+numLido;
		 
		 dadosMC.setTotalCompras(numAct);
		 
		 mensalCliente.put(compra.getMes(), dadosMC);
		 return;
	}
	
	private void atualizaFaturacaoMensal(int mes, DadosMesCliente dadosMC, Compra compra){
		double fatLido = dadosMC.getTotalCompras()*compra.getPreco();
		dadosMC.setFaturacao(fatLido);
		
	//	gavetaProdutos.put(compra.getIdProduto(), dadosP);
		return;
	}
	
	
	
	
	
	
	
}
