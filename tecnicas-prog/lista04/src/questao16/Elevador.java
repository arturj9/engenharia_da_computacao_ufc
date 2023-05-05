package questao16;

public class Elevador {
	private int andarAtual = 0;
	private int totalAndares;
	private int capacidadePessoas;
	private int quantPessoasEstao = 0;
	
	public String toString() {
		return "Andar atual: " + this.getAndarAtual() + " | Quant. Pessoas que estão: " +this.getQuantPessoasEstao();
	}

	public void inicializa(int capacidadePessoas, int totalAndares) {
		this.setCapacidadePessoas(capacidadePessoas);
		this.setTotalAndares(totalAndares);
	}
	
	public void entra() {
		if(this.getQuantPessoasEstao()+1<=this.getCapacidadePessoas())
			this.setQuantPessoasEstao(this.getQuantPessoasEstao()+1);
		
	}
	
	public void sai() {
		if(this.getQuantPessoasEstao()-1>=0)
			this.setQuantPessoasEstao(this.getQuantPessoasEstao()-1);
	}
	
	public void sobe() {
		if(this.getAndarAtual()+1<=this.getTotalAndares())
			this.setAndarAtual(this.getAndarAtual()+1);
		
	}
	
	public void desce() {
		if(this.getAndarAtual()-1>=0)
			this.setAndarAtual(this.getAndarAtual()-1);
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public int getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(int capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}

	public int getQuantPessoasEstao() {
		return quantPessoasEstao;
	}

	public void setQuantPessoasEstao(int quantPessoasEstao) {
		this.quantPessoasEstao = quantPessoasEstao;
	}
}
