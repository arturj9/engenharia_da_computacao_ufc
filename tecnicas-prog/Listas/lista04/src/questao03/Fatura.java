package questao03;

public class Fatura {
	
	private int numero;
	private String descricao;
	private int quantComprada;
	private double precoUnitario;
	
	public Fatura(int numero, String descricao, int quantComprada, double precoUnitario) {
		this.setNumero(numero);
		this.setDescricao(descricao);
		this.setQuantComprada(quantComprada);
		this.setPrecoUnitario(precoUnitario);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantComprada() {
		return quantComprada;
	}

	public void setQuantComprada(int quantComprada) {
		if(quantComprada<0)
			this.quantComprada = 0;
		else
			this.quantComprada = quantComprada;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		if(precoUnitario<0)
			this.precoUnitario = 0;
		else
			this.precoUnitario = precoUnitario;
	}

	public double getValorFatura() {
		return quantComprada*precoUnitario;
	}
	
	public void setDescontoEmPorcentagem(float porcentagem) {
	    double novoPrecoUnitario = this.getPrecoUnitario() * (1-(porcentagem/100));
	    this.setPrecoUnitario(novoPrecoUnitario);
	}
	
}
