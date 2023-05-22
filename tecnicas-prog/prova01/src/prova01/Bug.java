package prova01;

public class Bug implements Pontuacao {
	private String simbolo;
	private String nome;
	private int posicaox;
	private int posicaoy;
	private boolean encontrado;

	public Bug(String nome, int posicaox, int posicaoy) {
		this.simbolo = "b";
		this.setNome(nome);
		this.setPosicaox(posicaox);
		this.setPosicaoy(posicaoy);
		this.setEncontrado(false);
	}
	
	public int getPontos() {
		return -15;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosicaox() {
		return posicaox;
	}

	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}

	public int getPosicaoy() {
		return posicaoy;
	}

	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}
}
