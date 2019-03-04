package GESTIHIPER_MAVEN.GESTIHIPER_MAVEN;

public class Compra {
	private String idProduto;
	private double preco;
	private int quantidade;
	private String idCliente;
	private int mes;
	private int modoP;
	private int modoN;
	
	public Compra() {
		super();
	}
	
	public Compra(String idProduto, double preco, int quantidade, String idCliente, int mes, int modoP, int modoN) {
		super();
		this.idProduto = idProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.idCliente = idCliente;
		this.mes = mes;
		this.modoP = modoP;
		this.modoN = modoN;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getModoP() {
		return modoP;
	}

	public void setModoP(int modoP) {
		this.modoP = modoP;
	}

	public int getModoN() {
		return modoN;
	}

	public void setModoN(int modoN) {
		this.modoN = modoN;
	}

	@Override
	public String toString() {
		return "Compra [idProduto=" + idProduto + ", preco=" + preco + ", quantidade=" + quantidade + ", idCliente="
				+ idCliente + ", mes=" + mes + ", modoP=" + modoP + ", modoN=" + modoN + "]";
	}

	
	
	
}
	
