package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

public class DadosClienteProduto {
	private int quantidade;

	public DadosClienteProduto() {
		super();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return ", Quantidade:"+quantidade;
	}

	
	
}
