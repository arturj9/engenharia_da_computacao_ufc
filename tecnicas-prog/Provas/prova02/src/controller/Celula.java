package controller;

public class Celula {

	private int id;
	private int posicaoX;
	private int posicaoY;
	private String simbolo = "";
	private Robo robo;
	private Bug bug;
	private Aluno aluno;
	private boolean visitado;

	public Celula(int id, int x, int y) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		bug = null;
		aluno = null;
		visitado = true;
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

	public boolean verificaRobo() {
		if (robo != null)
			return true;
		return false;
	}

	public void addRobo(Robo robo) {
		this.setRobo(robo);
	}

	public void retirarRobo() {
		this.setRobo(null);
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
		if (verificaRobo())
			setSimbolo(robo.getIdentificador());
		else if (verificaAluno() && visitado)
			setSimbolo(aluno.getIdentificador());
		else if (verificaBug() && visitado)
			setSimbolo(bug.getIdentificador());
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

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}

	public void calcularPontuacaoRobos() {
		if (verificaRobo() && !visitado) {
			if (verificaAluno()) {
				robo.setPontuacao(this.aluno.getPontos());
				robo.addAlunoSalvo(aluno);
				this.aluno.setEncontrado(true);
			} else if (verificaBug()) {
				robo.setPontuacao(this.bug.getPontos());
				robo.addBugEncontrado(bug);
				this.bug.setEncontrado(true);
			}
		}
		this.setVisitado();
	}

}
