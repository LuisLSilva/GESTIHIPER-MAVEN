package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DadosProduto {
	private Map <Integer, DadosMesProduto> mensal;
	private Map <Integer, DadosVendasProduto> vendasProduto;
	private Integer numeroCompras;
	private Set<String> clientesDistintos;
	private double totalFaturado;
	
	//Para mim
	private String idProduto;
	
	
	public Map<Integer, DadosVendasProduto> getVendasProduto() {
		return vendasProduto;
	}

	public void setVendasProduto(Map<Integer, DadosVendasProduto> vendasProduto) {
		this.vendasProduto = vendasProduto;
	}

	public DadosProduto() {
		super();
		this.mensal = new HashMap<Integer,DadosMesProduto>();
		this.clientesDistintos = new HashSet<String>();
		this.vendasProduto = new HashMap<Integer, DadosVendasProduto>();
		
	}
		
	public Map<Integer, DadosMesProduto> getMensal() {
		return mensal;
	}

	public void setMensal(Map<Integer, DadosMesProduto> mensal) {
		this.mensal = mensal;
	}

	
	public Integer getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(Integer numeroCompras) {
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
		
		DadosVendasProduto dadosVP = vendasProduto.get(compra.getQuantidade());
		DadosMesProduto dadosMP = mensal.get(compra.getMes());
		
		if(dadosVP == null){
			dadosVP = new DadosVendasProduto();
			dadosVP.setVendas(compra.getQuantidade());
			dadosVP.setIdProduto(compra.getIdProduto());
//			dadosVP.getClientesDistintos().add(compra.getIdCliente());
		
			vendasProduto.put(compra.getQuantidade(), dadosVP);
		
		}
		
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
		
//		dadosVP.getClientesDistintos().add(compra.getIdCliente());
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
