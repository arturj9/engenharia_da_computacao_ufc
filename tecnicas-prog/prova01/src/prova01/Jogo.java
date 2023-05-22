package prova01;

import java.util.ArrayList;

import apresentacao.Terminal;

public class Jogo {
	private Plano plano;
	private Jogador jogador;
	private Terminal terminal;
	private ArrayList<Robo> robos;
	private ArrayList<Aluno> alunos;
	private ArrayList<Bug> bugs;
	private boolean jogando;

	public Jogo() {
		this.setTerminal(new Terminal());
		iniciar();
		iniciarRobos();
		setJogando(true);
		povoarPlano();
		mostrarPlano();
		rodada();
		relatorioFinal();
	}

	public void iniciarRobos() {
		int contador = 1;
		int xInicial = 1;
		int yInicial = 1;
		robos = new ArrayList<Robo>();
		this.robos.add(new Andador(contador++, "Andador", xInicial, yInicial, plano, "A"));
		this.robos.add(new Peao(contador++, "Peao", xInicial, yInicial, plano, "P"));
		this.robos.add(new Torre(contador++, "Torre", xInicial, yInicial, plano, "T"));
		this.robos.add(new Bispo(contador++, "Bispo", xInicial, yInicial, plano, "B"));
		this.robos.add(new Cavalo(contador++, "Cavalo", xInicial, yInicial, plano, "C"));
		this.robos.add(new Rei(contador++, "Rei", xInicial, yInicial, plano, "R"));
		this.robos.add(new Rainha(contador++, "Rainha", xInicial, yInicial, plano, "r"));
	}

	public void iniciarAlunos() {
		int quant;
		do {
			quant = terminal.entradaInteiro("Informe as quantidades de alunos: ");
		} while (!(quant < ((this.plano.getTamanhoX() * this.plano.getTamanhoY()) / 2)));
		this.setAlunos(new ArrayList<Aluno>());
		Celula celula;
		Aluno aluno;
		for (int i = 1; i <= quant; i++) {
			celula = plano.sortearCelula();
			aluno = new Aluno("Aluno " + i, celula.getPosicaoX(), celula.getPosicaoY());
			celula.addAluno(aluno);
			alunos.add(aluno);
		}
	}

	public void iniciarBugs() {
		int quant;
		do {
			quant = terminal.entradaInteiro("Informe as quantidades de bugs: ");
		} while (!(quant < ((this.plano.getTamanhoX() * this.plano.getTamanhoY()) / 2)));
		this.setBugs(new ArrayList<Bug>());
		Celula celula;
		Bug bug;
		for (int i = 1; i <= quant; i++) {
			celula = plano.sortearCelula();
			bug = new Bug("Bug " + i, celula.getPosicaoX(), celula.getPosicaoY());
			celula.addBug(bug);
			bugs.add(bug);
		}
	}

	public void iniciar() {
		setJogador(new Jogador(terminal.entradaString("Informe seu nome: ")));
		terminal.mensagem("Informe as quantidades de");
		setPlano(new Plano(terminal.entradaInteiro("Linhas: "), terminal.entradaInteiro("Colunas: ")));
	}

	public void rodada() {
		for (Robo robo : robos) {
			if(!jogando)
				return;
			vez(robo);
		}
		calcularPotuacaoCelulas();
		relatorioRodada();
		if(verificarAlunosSalvos())
			fimDeJogo();
		mostrarPlano();
		rodada();
	}

	private void vez(Robo robo) {
		terminal.mensagem("Vez do robô " + robo.getNome());
		int decisao = terminal.entradaInteiro("Digite 1 para avancar ou 0 para retroceder ou 3 para sair: ");
		if (decisao == 3) {
			fimDeJogo();
		}
		int numero = terminal.entradaInteiro("Informe a quantidade de casas que deseja andar: ");
		if (decisao == 1)
			robo.avancar(numero);
		else if (decisao == 0)
			robo.retroceder(numero);
		mostrarPlano();
	}

	public void fimDeJogo() {
		this.setJogando(false);
	}

	public void relatorioFinal() {
		String texto = "Relatorio";
		for (Robo robo : robos) {
			texto+="\n\n\n";
			if(verificarVencedor(robo))
				texto+=jogador.getNome()+" - ";
			texto+=robo.imprimir();
		}
		terminal.mensagem(texto);
	}
	
	public void relatorioRodada() {
		String texto = "Total de alunos salvos: "+this.getAlunosSalvos()+"\nTotal de bugs ocorridos: "
				+this.getBugsEncontrados()+"\n\nPontuacao";
		for (Robo robo : robos) {
			texto+="\n"+robo.infoPontos();
		}
		terminal.mensagem(texto);
	}

	public void povoarPlano() {
		iniciarAlunos();
		iniciarBugs();
	}
	
	public void calcularPotuacaoCelulas() {
		for (Celula celula : plano.getListaCelulas()) {
			celula.calcularPontuacaoRobos();
		}
	}

	public void mostrarPlano() {
		terminal.mensagem(plano.show());
	}
	
	public boolean verificarVencedor(Robo roboE) {
		for (Robo robo : robos) {
			if(roboE.getPontuacao()<robo.getPontuacao())
				return false;
		}
		return true;
	}
	
	public int getAlunosSalvos() {
		int quant=0;
		for (Aluno aluno : alunos) {
			if(aluno.isEncontrado())
				quant++;
		}
		return quant;
	}
	
	public int getBugsEncontrados() {
		int quant=0;
		for (Bug bug : bugs) {
			if(bug.isEncontrado())
				quant++;
		}
		return quant;
	}
	
	public boolean verificarAlunosSalvos() {
		for (Aluno aluno : alunos) {
			if(!aluno.isEncontrado())
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

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
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

}
