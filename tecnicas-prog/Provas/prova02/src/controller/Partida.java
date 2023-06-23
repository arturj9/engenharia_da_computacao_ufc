package controller;

import java.util.ArrayList;

public class Partida {

	private Jogador jogador;
	private int quantJogadas;
	private int celulaVazias;
	private int pontuacao;
	private int alunosSalvos;
	private int bugsEncontrados;
	private ArrayList<Robo> robos;
	
	public Partida(int celulaVazias, ArrayList<Robo> robos) {
		setQuantJogadas(0);
		setPontuacao(0);
		setAlunosSalvos(0);
		setBugsEncontrados(0);
		setCelulaVazias(celulaVazias);
		setRobos(robos);
	}

	public Partida(Jogador jogador, int celulaVazias, ArrayList<Robo> robos) {
		setJogador(jogador);
		setQuantJogadas(0);
		setPontuacao(0);
		setAlunosSalvos(0);
		setBugsEncontrados(0);
		setCelulaVazias(celulaVazias);
		setRobos(robos);
	}

	public Partida(Jogador jogador, int quantJogadas, int celulaVazias, int pontuacao, int alunosSalvos,
			int bugsEncontrados) {
		setJogador(jogador);
		setQuantJogadas(quantJogadas);
		setCelulaVazias(celulaVazias);
		setPontuacao(pontuacao);
		setAlunosSalvos(alunosSalvos);
		setBugsEncontrados(bugsEncontrados);

	}

	public int getQuantJogadas() {
		return quantJogadas;
	}

	public void setQuantJogadas(int quantJogadas) {
		this.quantJogadas = quantJogadas;
	}

	public void addQuantJogadas() {
		this.quantJogadas++;
	}

	public int getAlunosSalvos() {
		return alunosSalvos;
	}

	public void setAlunosSalvos(int alunosSalvos) {
		this.alunosSalvos = alunosSalvos;
	}

	public void addAluno() {
		this.alunosSalvos++;
	}

	public int getBugsEncontrados() {
		return bugsEncontrados;
	}

	public void setBugsEncontrados(int bugsEncontrados) {
		this.bugsEncontrados = bugsEncontrados;
	}

	public void addBug() {
		this.bugsEncontrados++;
	}

	public int getCelulaVazias() {
		return celulaVazias;
	}

	public void setCelulaVazias(int celulaVazias) {
		this.celulaVazias = celulaVazias;
	}

	public void retiraCelulaVazias() {
		this.celulaVazias--;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void setRobos(ArrayList<Robo> robos) {
		this.robos = robos;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
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
