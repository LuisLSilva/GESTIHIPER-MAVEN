package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DadosProduto {
	private Map <Integer, DadosMesProduto> mensal;
	
	private int numeroCompras;
	private Set<String> clientesDistintos;
	private double totalFaturado;
	
	
	//Para mim
	private String idProduto;
	
	
	public DadosProduto() {
		super();
		this.mensal = new HashMap<Integer,DadosMesProduto>();
		this.clientesDistintos = new HashSet<String>();
		
	}
		
	public Map<Integer, DadosMesProduto> getMensal() {
		return mensal;
	}

	public void setMensal(Map<Integer, DadosMesProduto> mensal) {
		this.mensal = mensal;
	}

	public int getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(int numeroCompras) {
	    this.numeroCompras = numeroCompras;
	}

	public Set<String> getClientesDistintos() {
		return clientesDistintos;
	}

	public void setClientesDistintos(Set<String> clientesDistintos) {
		this.clientesDistintos = clientesDistintos;
	}

	public double getTotalFaturado() {
		return totalFaturado;
	}

	public void setTotalFaturado(double totalFaturado) {
		this.totalFaturado = totalFaturado;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public void addCompraMensal(Compra compra) {
		
		DadosMesProduto dadosMP = mensal.get(compra.getMes());

		if (dadosMP == null) {
			dadosMP = new DadosMesProduto();
			dadosMP.setTotalCompras(compra.getQuantidade());
			dadosMP.setFaturacao(compra.getPreco()*compra.getQuantidade());
	        
			dadosMP.setComprasModoP(compra.getModoP());
		    dadosMP.setComprasModoN(compra.getModoN());
			
			dadosMP.getClientesDistintos().add(compra.getIdCliente());
			
			mensal.put(compra.getMes(), dadosMP);
			
			//printMapAB(dadosP.getMensal());
			return;
		}
		
		dadosMP.getClientesDistintos().add(compra.getIdCliente());
		atualizaNumComprasMensal(compra.getMes(), dadosMP, compra);
		atualizaFaturacaoMensal(compra.getMes(), dadosMP, compra);
		tipoCompra(compra, dadosMP);
		
	
		//System.out.println(this.getMensal().toString());
	}

	private void atualizaNumComprasMensal(int mes, DadosMesProduto dadosMP, Compra compra) {
		 int numLista = dadosMP.getTotalCompras();
		 int numLido = compra.getQuantidade();
		 int numAct=numLista+numLido;
		 
		 dadosMP.setTotalCompras(numAct);
		 
		 mensal.put(compra.getMes(), dadosMP);
		 return;
	}
	
	private void atualizaFaturacaoMensal(int mes, DadosMesProduto dadosMP, Compra compra){
		double fatLido = dadosMP.getTotalCompras()*compra.getPreco();
		dadosMP.setFaturacao(fatLido);
		
	//	gavetaProdutos.put(compra.getIdProduto(), dadosP);
		return;
	}
	

	private void tipoCompra(Compra compra, DadosMesProduto dadosMP) {
		int compraTotalP= compra.getModoP()+dadosMP.getComprasModoP();
		int compraTotalN= compra.getModoN()+dadosMP.getComprasModoP();
		
		dadosMP.setComprasModoP(compraTotalP);
		dadosMP.setComprasModoN(compraTotalN);
		
	}
	
	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}
	}
		
	@Override
	public String toString() {
		PrettyPrintingMap<Integer, DadosMesProduto> s = new PrettyPrintingMap<Integer, DadosMesProduto>(this.getMensal());
		return s.toString();
	}
	

		
			
	
}
