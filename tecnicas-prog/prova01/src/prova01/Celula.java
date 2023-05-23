package prova01;

import java.util.ArrayList;

public class Celula {

	private int id;
	private int posicaoX;
	private int posicaoY;
	private String simbolo = "*";
	private ArrayList<Robo> listaRobos;
	private Bug bug;
	private Aluno aluno;
	private boolean visitado;

	public Celula(int id, int x, int y) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		listaRobos = new ArrayList<Robo>();
		bug = null;
		aluno = null;
		visitado = false;
	}

	public String imprimir() {
		return "Celula:  " + id + " x: " + posicaoX + " y: " + posicaoY + "Tem aluno: " + this.verificaAluno()
				+ "Tem bug: " + this.verificaBug() + "Tem robo: " + this.verificaListaRobos();
	}

	public boolean verificaAluno() {
		if (aluno != null)
			return true;
		return false;
	}

	public boolean verificaBug() {
		if (bug != null)
			return true;
		return false;
	}

	public boolean verificaListaRobos() {
		if (listaRobos.size() != 0)
			return true;
		return false;
	}

	public void addRobo(Robo robo) {
		this.listaRobos.add(robo);
	}

	public void retirarRobo(Robo robo) {
		int indexRetirar = listaRobos.indexOf(robo);
		listaRobos.remove(indexRetirar);
	}

	public void addBug(Bug bug) {
		if (!this.verificaAluno()) {
			this.bug = bug;
		}
	}

	public void addAluno(Aluno aluno) {
		if (!this.verificaBug()) {
			this.aluno = aluno;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public ArrayList<Robo> getListaRobos() {
		return listaRobos;
	}

	public void setListaRobos(ArrayList<Robo> listaRobos) {
		this.listaRobos = listaRobos;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getSimbolo() {
		verificaSimbolo();
		if (this.getPosicaoY() == 1)
			return "\n " + simbolo + " ";
		return " " + simbolo + " ";
	}

	private void verificaSimbolo() {
		if (verificaListaRobos())
			setSimbolo(listaRobos.get(0).getIdentificador());
		else if (verificaAluno() && visitado)
			setSimbolo(aluno.getIdentificador());
		else if (verificaBug() && visitado)
			setSimbolo(bug.getIdentificador());
		else if (visitado)
			setSimbolo("@");
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado() {
		this.visitado = true;
	}

	public void calcularPontuacaoRobos() {
		if (verificaListaRobos() && !visitado) {
			for (Robo robo : listaRobos) {
				if(verificaAluno()) {
					robo.setPontuacao(this.aluno.getPontos());
					robo.addAlunoSalvo(aluno);
					this.aluno.setEncontrado(true);
				}
				else if(verificaBug()) {
					robo.setPontuacao(this.bug.getPontos());
					robo.addBugEncontrado(bug);
					this.bug.setEncontrado(true);
				}
			}
			this.setVisitado();
		}
	}

}
