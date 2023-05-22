package prova01;

import java.util.ArrayList;

public abstract class Robo implements Movimento {

	private int id;
	private String nome;
	private ArrayList<Celula> historico;
	private ArrayList<Aluno> alunosSalvos;
	private ArrayList<Bug> bugsEncontrados;
	private int posicaox;
	private int posicaoy;
	private Plano plano;
	private String identificador;
	private int pontuacao;

	public Robo(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		this.setId(id);
		this.setNome(nome);
		this.setPosicaox(posicaox);
		this.setPosicaoy(posicaoy);
		this.setPlano(plano);
		this.setIdentificador(identificador);
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
		if(x>0&&x<=plano.getTamanhoX()&&y>0&&y<=plano.getTamanhoY())
			return true;
		return false;
	}
	
	public boolean movimentar(int x, int y) {
		if(verificarMovimento(x, y)) {
			plano.retornarCelula(this.getPosicaox(), this.getPosicaoy()).retirarRobo(this);
			plano.retornarCelula(x, y).addRobo(this);
			this.addCelulaVisitada(plano.retornarCelula(x, y));
			this.setCoordenada(x, y);
			return true;
		}
		return false;
	}
	
	public String infoPontos() {
		return this.getIdentificador()+" - "+this.getNome()+": "+this.getPontuacao()+" ponto(s)";
	}
	
	public String imprimir() {
		String texto = this.getIdentificador()+" - "+this.getNome()+"\nPontuacao: "+this.getPontuacao()+"\nHistorico:";
		for (Celula celula : historico) {
			texto+="\nX: "+celula.getPosicaoX()+" Y: "+celula.getPosicaoY();
		}
		texto+="\nAlunos salvos: "+this.getAlunosSalvos().size()+"\nBugs encontrados: "+this.getBugsEncontrados().size();
		return texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosicaoy() {
		return posicaoy;
	}

	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}

	public int getPosicaox() {
		return posicaox;
	}

	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String simbolo) {
		this.identificador = simbolo;
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

