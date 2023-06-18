package controller;

import java.util.ArrayList;

public class Robo extends Personagem{

	private int id;
	private ArrayList<Celula> historico;
	private ArrayList<Aluno> alunosSalvos;
	private ArrayList<Bug> bugsEncontrados;
	private Plano plano;
	private int pontuacao;

	public Robo(int id, String nome, Plano plano, Icon icon) {
		super(icon, nome);
		this.setId(id);
		this.setPlano(plano);
		this.setPontuacao(0);
		this.setHistorico(new ArrayList<Celula>());
		this.setAlunosSalvos(new ArrayList<Aluno>());
		this.setBugsEncontrados(new ArrayList<Bug>());
	}

	public boolean verificarMovimento(Celula celula) {
		if (!celula.verificaRobo())
			return true;
		return false;
	}

	public boolean movimentar(Celula novaCelula) {
		if (verificarMovimento(novaCelula)) {
			Celula celulaAtual = plano.retornarCelulaDeRobo(this);
			celulaAtual.retirarRobo();
			novaCelula.addRobo(this);
			this.addCelulaVisitada(novaCelula);
			return true;
		}
		return false;
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
