package controller;

import java.util.ArrayList;

public abstract class Robo extends Personagem implements Movimento {

	private int id;
	private ArrayList<Celula> historico;
	private ArrayList<Aluno> alunosSalvos;
	private ArrayList<Bug> bugsEncontrados;
	private Plano plano;
	private int pontuacao;

	public Robo(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(identificador, nome, posicaox, posicaoy);
		this.setId(id);
		this.setPlano(plano);
		this.setPontuacao(0);
		this.setHistorico(new ArrayList<Celula>());
		this.setAlunosSalvos(new ArrayList<Aluno>());
		this.setBugsEncontrados(new ArrayList<Bug>());
		plano.retornarCelula(posicaox, posicaoy).addRobo(this);
	}

	public void setCoordenada(int x, int y) {
		this.setPosicaox(x);
		this.setPosicaoy(y);
	}

	public boolean verificarMovimento(int x, int y) {
		if (x > 0 && x <= plano.getTamanhoX() && y > 0 && y <= plano.getTamanhoY())
			return true;
		return false;
	}

	public boolean movimentar(int x, int y) {
		if (verificarMovimento(x, y)) {
			plano.retornarCelula(this.getPosicaox(), this.getPosicaoy()).retirarRobo(this);
			plano.retornarCelula(x, y).addRobo(this);
			this.addCelulaVisitada(plano.retornarCelula(x, y));
			this.setCoordenada(x, y);
			return true;
		}
		return false;
	}

	public String infoPontos() {
		return this.getIdentificador() + " - " + this.getNome() + ": " + this.getPontuacao() + " ponto(s)";
	}

	public String imprimir() {
		String texto = this.getIdentificador() + " - " + this.getNome() + "\nPontuacao: " + this.getPontuacao()
				+ "\nHistorico:";
		for (Celula celula : historico) {
			texto += "\nX: " + celula.getPosicaoX() + " Y: " + celula.getPosicaoY();
		}
		texto += "\nAlunos salvos: " + this.getAlunosSalvos().size() + "\nBugs encontrados: "
				+ this.getBugsEncontrados().size();
		return texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

	public ArrayList<Celula> getHistorico() {
		return historico;
	}

	public void setHistorico(ArrayList<Celula> historico) {
		this.historico = historico;
	}

	public void addCelulaVisitada(Celula celula) {
		this.getHistorico().add(celula);
	}

	public ArrayList<Aluno> getAlunosSalvos() {
		return alunosSalvos;
	}

	public void setAlunosSalvos(ArrayList<Aluno> alunosSalvos) {
		this.alunosSalvos = alunosSalvos;
	}

	public void addAlunoSalvo(Aluno aluno) {
		this.getAlunosSalvos().add(aluno);
	}

	public ArrayList<Bug> getBugsEncontrados() {
		return bugsEncontrados;
	}

	public void setBugsEncontrados(ArrayList<Bug> bugsEncontrados) {
		this.bugsEncontrados = bugsEncontrados;
	}

	public void addBugEncontrado(Bug bug) {
		this.getBugsEncontrados().add(bug);
	}

}
