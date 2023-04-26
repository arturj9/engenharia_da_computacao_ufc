package questao03;

public class Fatura {
//	3) Crie uma classe chamada Fatura que possa ser utilizada por uma loja de
//	suprimentos de informática para representar uma fatura de um item vendido
//	na loja. Uma fatura deve incluir as seguintes informações como atributos:
//	a. O número do item faturado
//	b. A descrição do item
//	c. A quantidade comprada do item
//	d. O preço unitário do item.
//	e. Preço total da fatura
//	Sua classe deve ter um construtor que inicialize os quatro atributos. Se a quantidade
//	não for positiva, ela deve ser configurada como 0. Se o preço por item não for
//	positivo ele deve ser configurado como 0.0. Forneça um método set e um método
//	get para cada variável de instância. Além disso, forneça um método chamado
//	getValorFatura que calcula o valor da fatura (isso é, multiplicar a quantidade pelo
//	preço por item) e depois retorna o valor como um double. Crie um método que
//	possa dar descontos em todos os itens, o porcentagem de desconto deverá ser
//	informado para o método.
	
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
