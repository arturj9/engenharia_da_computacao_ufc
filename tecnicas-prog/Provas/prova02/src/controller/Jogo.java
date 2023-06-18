package controller;

import java.util.ArrayList;
import view.Janela;

public class Jogo {
	private Plano plano;
	private Jogador jogador;
	private Janela janela;
	private ArrayList<Robo> robos;
	private ArrayList<Aluno> alunos;
	private ArrayList<Bug> bugs;
	private boolean jogando;

	public Jogo() {
		this.setJanela(new Janela());
		this.setRobos(new ArrayList<Robo>());
		this.setAlunos(new ArrayList<Aluno>());
		this.setBugs(new ArrayList<Bug>());
		setJogando(true);
	}

	public void iniciar() {
//		setJogador(new Jogador(terminal.entradaString("Informe seu nome: ")));
//		terminal.mensagem("Informe as quantidades de");
//		setPlano(new Plano(terminal.entradaInteiro("Linhas: "), terminal.entradaInteiro("Colunas: ")));
//		povoarPlano();
//		rodada();
	}

	public void mostrarPlano() {
//		terminal.mensagem(plano.show());
	}

	public void povoarPlano() {
		iniciarRobos();
		iniciarAlunos();
		iniciarBugs();
	}

	public void iniciarRobos() {
		int contador = 1;
		int xInicial = 1;
		int yInicial = 1;
	}

	public void iniciarAlunos() {
		int quant;
		Celula celula;
		Aluno aluno;
//		do {
//			quant = terminal.entradaInteiro("Informe as quantidades de alunos: ");
//		} while (!(quant < ((this.plano.getTamanhoX() * this.plano.getTamanhoY()) / 2)));
//		for (int i = 1; i <= quant; i++) {
//			celula = plano.sortearCelula();
////			aluno = new Aluno("Aluno " + i, celula.getPosicaoX(), celula.getPosicaoY());
//			celula.addAluno(aluno);
//			alunos.add(aluno);
//		}
	}

	public void iniciarBugs() {
		int quant;
		Celula celula;
		Bug bug;
//		do {
////			quant = terminal.entradaInteiro("Informe as quantidades de bugs: ");
//		} while (!(quant < ((this.plano.getTamanhoX() * this.plano.getTamanhoY()) / 2)));
//		for (int i = 1; i <= quant; i++) {
//			celula = plano.sortearCelula();
//			bug = new Bug("Bug " + i, celula.getPosicaoX(), celula.getPosicaoY());
//			celula.addBug(bug);
//			bugs.add(bug);
		}
//	}

	public void rodada() {
		for (Robo robo : robos) {
			if (!jogando)
				return;
			mostrarPlano();
			vez(robo);
		}
		relatorioRodada();
		if (verificarAlunosSalvos())
			fimDeJogo();
		rodada();
	}

	public void vez(Robo robo) {
//		terminal.mensagem("Vez do robô " + robo.getNome());
//		int decisao = terminal.entradaInteiro("Digite 1 para avancar ou 0 para retroceder ou 3 para sair: ");
//		if (decisao == 3) {
//			fimDeJogo();
//		}
//		int numero = terminal.entradaInteiro("Informe a quantidade de casas que deseja andar: ");
//		if (decisao == 1) {
//			tentarAvancar(robo, numero);
//		} else if (decisao == 0) {
//			tentarRetroceder(robo, numero);
//		} else {
//			tentarNovamente(robo);
//		}
	}

	public void tentarNovamente(Robo robo) {
//		terminal.mensagem("Entrada inválida, tente novamente");
		vez(robo);
	}


	public void fimDeJogo() {
		relatorioFinal();
		this.setJogando(false);
	}

	public void relatorioFinal() {
		String texto = "Relatorio";
		for (Robo robo : robos) {
			texto += "\n\n\n";
			if (verificarVencedor(robo))
				texto += jogador.getNome() + " - ";
			texto += robo.imprimir();
		}
//		terminal.mensagem(texto);
	}

	public void relatorioRodada() {
		calcularPotuacaoCelulas();
		String texto = "Total de alunos salvos: " + this.getAlunosSalvos() + "\nTotal de bugs ocorridos: "
				+ this.getBugsEncontrados() + "\n\nPontuacao";
		for (Robo robo : robos) {
			texto += "\n" + robo.infoPontos();
		}
//		terminal.mensagem(texto);
	}

	public void calcularPotuacaoCelulas() {
		for (Celula celula : plano.getListaCelulas()) {
			celula.calcularPontuacaoRobos();
		}
	}

	public boolean verificarVencedor(Robo roboE) {
		for (Robo robo : robos) {
			if (roboE.getPontuacao() < robo.getPontuacao())
				return false;
		}
		return true;
	}

	public int getAlunosSalvos() {
		int quant = 0;
		for (Aluno aluno : alunos) {
			if (aluno.isEncontrado())
				quant++;
		}
		return quant;
	}

	public int getBugsEncontrados() {
		int quant = 0;
		for (Bug bug : bugs) {
			if (bug.isEncontrado())
				quant++;
		}
		return quant;
	}

	public boolean verificarAlunosSalvos() {
		for (Aluno aluno : alunos) {
			if (!aluno.isEncontrado())
				return false;
		}
		return true;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public boolean isJogando() {
		return jogando;
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void setRobos(ArrayList<Robo> robos) {
		this.robos = robos;
	}

	public Janela getJanela() {
		return janela;
	}

	public void setJanela(Janela janela) {
		this.janela = janela;
	}

}
