package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.Map;
import java.util.Set;

public class DadosCliente {
	private double valorGasto;
	private int numeroCompras;
	private Set<String> produtosDistintos;
	

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

	
	
	
}
