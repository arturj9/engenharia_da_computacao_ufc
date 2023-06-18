package controller;

public class Jogador {
	private String nome;
	private int pontuacao;

	public Jogador(String nome) {
		setNome(nome);;
		setPontuacao(0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public void addPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}
}
