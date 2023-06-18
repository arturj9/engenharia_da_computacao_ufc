package controller;

public class Bug extends Personagem implements Pontuacao {

	private boolean encontrado;

	public Bug(String nome) {
		super(new Icon("src/img/bug.png"), nome);
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
