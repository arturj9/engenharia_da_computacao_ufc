package prova01;

public class Bug extends Personagem implements Pontuacao {

	private boolean encontrado;

	public Bug(String nome, int posicaox, int posicaoy) {
		super("b", nome, posicaox, posicaoy);
		this.setEncontrado(false);
	}

	public int getPontos() {
		return -15;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}
}
