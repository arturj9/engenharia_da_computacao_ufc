package controller;

public class Aluno extends Personagem implements Pontuacao {

	private boolean encontrado;

	public Aluno(String nome) {
		super(new Icon("src/img/aluno.png"), nome);
		this.setEncontrado(false);
	}

	public int getPontos() {
		return 10;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}

}
