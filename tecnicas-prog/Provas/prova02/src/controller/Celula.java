package controller;

public class Celula {

	private int id;
	private int posicaoX;
	private int posicaoY;
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
		setRobo(null);
		visitado = false;
	}

	public Celula(int id, int x, int y, Robo robo) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		bug = null;
		aluno = null;
		addRobo(robo);
		visitado = true;
	}

	public Celula(Robo robo) {
		addRobo(robo);
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

	public Icon getIcon() {
		if (verificaRobo())
			return robo.getIcon();
		else if (verificaAluno() && visitado)
			return aluno.getIcon();
		else if (verificaBug() && visitado)
			return bug.getIcon();
		return null;
	}

	public void calcularPontuacaoRobo(Partida partida) {
		if (verificaRobo()) {
			if (verificaAluno()) {
				robo.setPontuacao(this.aluno.getPontos());
				robo.addAlunoSalvo(aluno);
				partida.addPontuacao(aluno.getPontos());
				partida.addAluno();
				this.aluno.setEncontrado(true);
			} else if (verificaBug()) {
				robo.setPontuacao(this.bug.getPontos());
				robo.addBugEncontrado(bug);
				partida.addPontuacao(bug.getPontos());
				partida.addBug();
				this.bug.setEncontrado(true);
			}
		}
		this.setVisitado();
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
}
