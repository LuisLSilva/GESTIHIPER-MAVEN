package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashSet;
import java.util.Set;

public class DadosVendasProduto {
	private Integer vendas;
	private Set<String> clientesDistintos;
	private String idProduto;
	
	public DadosVendasProduto() {
		super();
		this.clientesDistintos = new HashSet<String>();
	}
	
	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public int getVendas() {
		return vendas;
	}
	
	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	
	public Set<String> getClientesDistintos() {
		return clientesDistintos;
	}
	
	public void setClientesDistintos(Set<String> clientesDistintos) {
		this.clientesDistintos = clientesDistintos;
	}

	@Override
	public String toString() {
		return "DadosVendasProduto [vendas=" + vendas + ", clientesDistintos=" + clientesDistintos + "]";
	}
}
