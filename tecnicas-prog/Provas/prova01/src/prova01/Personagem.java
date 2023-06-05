package prova01;

public abstract class Personagem {
	private String identificador;
	private String nome;
	private int posicaox;
	private int posicaoy;

	public Personagem(String identificador, String nome, int posicaox, int posicaoy) {
		this.identificador = identificador;
		this.nome = nome;
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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

}
