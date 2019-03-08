package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

import java.util.HashSet;
import java.util.Set;

public class DadosMesCliente {
		private int totalCompras;
		private double faturacao;
		private Set<String> produtosDistintos;
	
		public DadosMesCliente() {
			super();
			produtosDistintos = new HashSet<String>();
		}

		public int getTotalCompras() {
			return totalCompras;
		}
		
		public void setTotalCompras(int totalCompras) {
			this.totalCompras = totalCompras;
		}
		
		public double getFaturacao() {
			return faturacao;
		}
		
		public void setFaturacao(double faturacao) {
			this.faturacao = faturacao;
		}
		
		public Set<String> getProdutosDistintos() {
			return produtosDistintos;
		}
		
		public void setProdutosDistintos(Set<String> produtosDistintos) {
			this.produtosDistintos = produtosDistintos;
		}
}
