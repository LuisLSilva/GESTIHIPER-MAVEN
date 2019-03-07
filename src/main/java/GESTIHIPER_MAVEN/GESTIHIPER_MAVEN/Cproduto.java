package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Cproduto {
	private Map<String, DadosProduto> gavetaProdutos;
	private String idProduto;

	
	public Cproduto() {
		super();
		this.gavetaProdutos = new HashMap<String, DadosProduto>();
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Map<String, DadosProduto> getGavetaProdutos() {
		return gavetaProdutos;
	}

	public void setGavetaProdutos(Map<String, DadosProduto> gavetaProdutos) {
		this.gavetaProdutos = gavetaProdutos;
	}

	
	public void addCompraProduto(Compra compra) {
		//Caso já exista 'values' no HashMap de Cproduto
		DadosProduto dadosP = gavetaProdutos.get(compra.getIdProduto());

		if(dadosP == null) {
			dadosP = new DadosProduto();
			dadosP.setTotalFaturado(compra.getPreco()*compra.getQuantidade());
			dadosP.setNumeroCompras(compra.getQuantidade());
			dadosP.setIdProduto(compra.getIdProduto());
			
			//printMapAA(dadosP.getMensal());
			dadosP.addCompraMensal(compra);
			
			dadosP.getClientesDistintos().add(compra.getIdCliente());
			

			gavetaProdutos.put(compra.getIdProduto(), dadosP);
			return;
		}
		
		//Já existem dados neste ponto
		dadosP.addCompraMensal(compra);
		dadosP.getClientesDistintos().add(compra.getIdCliente());
	
		 
		atualizaNumCompras(compra.getIdProduto(), dadosP, compra);
		atualizaFaturacao(compra.getIdProduto(), dadosP, compra);
	
	}
	
	
	private void atualizaNumCompras(String idProduto, DadosProduto dadosP, Compra compra) {
		 int numLista = dadosP.getNumeroCompras();
		 int numLido = compra.getQuantidade();
		 int numAct=numLista+numLido;
		 dadosP.setNumeroCompras(numAct);
		 
		 gavetaProdutos.put(idProduto, dadosP);
		 return;
	}
	
	private void atualizaFaturacao(String idProduto, DadosProduto dadosP, Compra compra){
		double fatList = dadosP.getTotalFaturado(); 		 
		double fatLido = compra.getQuantidade()*compra.getPreco();
		double fatAct = fatLido+fatList;
		
		dadosP.setTotalFaturado(fatAct);
		
		gavetaProdutos.put(compra.getIdProduto(), dadosP);
		return;
	}
	
	@Override
	public String toString() {
		return "Cproduto [gavetaProdutos=" + gavetaProdutos.toString() + ", idProduto=" + idProduto + "]";
	}

	public static <K, V> void printMapAA(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
				System.out.println("KEY: " + entry.getKey() + "   VALUE: " + entry.getValue());
		}

	}

	
	
}
