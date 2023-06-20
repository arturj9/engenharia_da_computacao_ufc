package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Celula;
import controller.Jogador;
import controller.Plano;
import controller.Robo;

public class PainelMenu extends Painel {

	private Jogador jogador;
	private ArrayList<Robo> robos;
	private ArrayList<BotaoCelula> botoesCelula;
	private Robo roboSelecionado;

	private int quantJogadas;
	private int pontuacao;
	private int alunos;
	private int bugs;

	public PainelMenu(Color color, Janela janela) {
		super(color, janela);

		setBotoesCelula(new ArrayList<BotaoCelula>());
		setRobos(janela.getPainelTabuleiro().getPlano().getRobos());
		setPontuacao(0);
		setAlunos(0);
		setBugs(0);

		this.setPreferredSize(new Dimension(300, 700));

		Dimension dimension = new Dimension(290, 50);
		Dimension dRobo = new Dimension(96, 70);
		Color corBotao = new Color(134, 193, 239);

		Painel painelPontuacao = new Painel(color, janela);
		painelPontuacao.setLayout(new GridLayout(4, 1));

		JLabel labelPontuacao = getLabelPontuacao();
		JLabel labelTotal = getLabelTotal();
		JLabel robop1 = new JLabel("Robo1");
		JLabel robop2 = new JLabel("Robo2");
		JLabel robop3 = new JLabel("Robo3");

		painelPontuacao.add(labelPontuacao);
		painelPontuacao.add(labelTotal);
		painelPontuacao.add(robop1);
		painelPontuacao.add(robop2);
		painelPontuacao.add(robop3);

		Painel painelRobos = new Painel(color, janela);
		ArrayList<Celula> celulas = janela.getPainelTabuleiro().getPlano().getListaCelulas();
		painelRobos.setLayout(new GridLayout(1, 3));
		for (Robo robo : robos) {
			Celula celula = new Celula(robo);
			celulas.add(celula);
			BotaoCelula botaoCelula = new BotaoCelula(Color.cyan, celula);
			botaoCelula.setPreferredSize(dRobo);
			botaoCelula.addActionListener(new Selecionar(janela));
			botoesCelula.add(botaoCelula);
			painelRobos.add(botaoCelula);
		}

		Painel painelBotoes = new Painel(color, janela);
		painelBotoes.setLayout(new GridLayout(3, 1));
		Botao botaoVerificar = new Botao("Verificar", corBotao);
		botaoVerificar.setPreferredSize(dimension);
		botaoVerificar.addActionListener(new Verificar(janela));
		Botao botaoProximaJogada = new Botao("Proxima Jogada", corBotao);
		botaoProximaJogada.addActionListener(new ProximaRodada(janela));
		botaoProximaJogada.setPreferredSize(dimension);
		Botao botaoSairDoJogo = new Botao("Sair do Jogo", corBotao);
		botaoSairDoJogo.setPreferredSize(dimension);
		painelBotoes.add(botaoVerificar);
		painelBotoes.add(botaoProximaJogada);
		painelBotoes.add(botaoSairDoJogo);

		this.add(painelPontuacao, BorderLayout.NORTH);
		this.add(painelRobos, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);

	}

	private class Verificar implements ActionListener {

		private Janela janela;

		public Verificar(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			if (verificaRobos()) {
				for (Celula celula : janela.getPainelTabuleiro().getPlano().getListaCelulas()) {
					if (celula.verificaRobo()) {
						celula.setVisitado();
						janela.getPainelTabuleiro().getBotoesCelulas().get(celula.getId() - 1)
								.setBackground(new Color(200, 236, 249));
					}

				}
				robosDefault();
				atualizar();
				janela.getPainelTabuleiro().atualizar();
			} else
				JOptionPane.showMessageDialog(getJanela(), "Posicione todos os robos", "Aviso",
						JOptionPane.WARNING_MESSAGE);

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}

	private class Selecionar implements ActionListener {

		private Janela janela;

		public Selecionar(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			BotaoCelula botaoCelula = (BotaoCelula) e.getSource();
			botoesDefault();
			if (janela.getPainelMenu().addRoboSelecionado(botaoCelula.getCelula().getRobo())) {
				botaoCelula.setBackground(Color.white);
			} else {
				janela.getPainelMenu().retiraRoboSelecionado();
			}

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}

	private class ProximaRodada implements ActionListener {

		private Janela janela;

		public ProximaRodada(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			for (BotaoCelula botaoCelula : botoesCelula) {
				botaoCelula.setEnabled(true);
			}

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}

	public boolean verificaRobos() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (botaoCelula.getCelula().verificaRobo())
				return false;
		}
		return true;
	}

	public void botoesDefault() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			botaoCelula.setBackground(Color.cyan);
		}
	}

	public void robosDefault() {
		getJanela().getPainelTabuleiro().getPlano().retirarRobos();
		int index = 0;
		for (Robo robo : robos) {
			botoesCelula.get(index++).getCelula().addRobo(robo);
		}
	}

	public void atualizar() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (!botaoCelula.getCelula().verificaRobo())
				botaoCelula.setEnabled(false);
			botaoCelula.atualizaIcon();
		}
	}

	public JLabel getLabelPontuacao() {
		String lPontuacao = "Pontuação: " + getPontuacao();
		return new JLabel(lPontuacao);
	}

	public JLabel getLabelTotal() {
		String lTotal = "Total: Alunos: " + getAlunos() + " Bugs: " + getBugs();
		return new JLabel(lTotal);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}

	public int getBugs() {
		return bugs;
	}

	public void setBugs(int bugs) {
		this.bugs = bugs;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void setRobos(ArrayList<Robo> robos) {
		this.robos = robos;
	}

	public ArrayList<BotaoCelula> getBotoesCelula() {
		return botoesCelula;
	}

	public void setBotoesCelula(ArrayList<BotaoCelula> botoesCelula) {
		this.botoesCelula = botoesCelula;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getQuantJogadas() {
		return quantJogadas;
	}

	public void setQuantJogadas() {
		this.quantJogadas++;
	}

	public boolean verificaRoboSelecionado() {
		if (roboSelecionado != null)
			return true;
		return false;
	}

	public boolean addRoboSelecionado(Robo roboSelecionado) {
		if (roboSelecionado != null) {
			retiraRoboSelecionado();
			setRoboSelecionado(roboSelecionado);
			return true;
		}
		return false;
	}

	public void retiraRoboSelecionado() {
		setRoboSelecionado(null);
	}

	public Robo getRoboSelecionado() {
		return roboSelecionado;
	}

	public void setRoboSelecionado(Robo roboSelecionado) {
		this.roboSelecionado = roboSelecionado;
	}

}
