package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashSet;
import java.util.Set;

public class DadosClienteProduto {
	private int quantidade;
	private Set<String> clientesDistintos;
	private Set<String> produtosDistintos;

	public DadosClienteProduto() {
		super();
		this.clientesDistintos = new HashSet<String>();
		this.produtosDistintos = new HashSet<String>();
	}

	public Set<String> getProdutosDistintos() {
		return produtosDistintos;
	}

	public void setProdutosDistintos(Set<String> produtosDistintos) {
		this.produtosDistintos = produtosDistintos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Set<String> getClientesDistintos() {
		return clientesDistintos;
	}

	public void setClientesDistintos(Set<String> clientesDistintos) {
		this.clientesDistintos = clientesDistintos;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return ", Quantidade:"+quantidade;
	}

	
	
}
