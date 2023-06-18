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
import controller.Plano;
import controller.Robo;

public class PainelMenu extends Painel {

	private ArrayList<Robo> robos;
	private ArrayList<BotaoCelula> botoesCelula;

	private int pontuacao;
	private int alunos;
	private int bugs;

	public PainelMenu(Color color, Janela janela) {
		super(color, janela);
		int quantRobos = 3;

		setBotoesCelula(new ArrayList<BotaoCelula>());
		setRobos(janela.getPainelTabuleiro().getPlano().getRobos());
		setPontuacao(0);
		setAlunos(0);
		setBugs(0);
		
		this.setPreferredSize(new Dimension(300,700));

		Dimension dimension = new Dimension(290, 50);
		Dimension dRobo = new Dimension(96,70);
		Color corBotao = new Color(134, 193, 239);
		
		Painel painelPontuacao = new Painel(color, janela);
		painelPontuacao.setLayout(new GridLayout(4,1));
		
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
		painelRobos.setLayout(new GridLayout(1,3));
		for (Robo robo: robos) {
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
		botaoProximaJogada.setPreferredSize(dimension);
		Botao botaoSairDoJogo = new Botao("Sair do Jogo", corBotao);
		botaoSairDoJogo.setPreferredSize(dimension);
		painelBotoes.add(botaoVerificar);
		painelBotoes.add(botaoProximaJogada);
		painelBotoes.add(botaoSairDoJogo);

		this.add(painelPontuacao,BorderLayout.NORTH);
		this.add(painelRobos,BorderLayout.CENTER);
		this.add(painelBotoes,BorderLayout.SOUTH);

	}

	private class Verificar implements ActionListener {

		private Janela janela;

		public Verificar(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			for (Celula celula : janela.getPainelTabuleiro().getPlano().getListaCelulas()) {
				if(celula.isVisitado()) {
					janela.getPainelTabuleiro().getBotoesCelulas().get(celula.getId()-1).setBackground(new Color(200,236,249));
				}
					
			}

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
			if(janela.getPainelTabuleiro().getPlano().addRoboSelecionado(botaoCelula.getCelula().getRobo())) {
				botoesDefault();
				botaoCelula.setBackground(Color.white);
			}else {
				botoesDefault();
				janela.getPainelTabuleiro().getPlano().retiraRoboSelecionado();
			}

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}
	
	public void botoesDefault() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			botaoCelula.setBackground(Color.cyan);
		}
	}
	
	public void atualizar(){
		for (BotaoCelula botaoCelula : botoesCelula) {
			botaoCelula.atualizaIcon();
		}
	}
	
	public JLabel getLabelPontuacao() {
		String lPontuacao = "Pontuação: "+getPontuacao();
		return new JLabel(lPontuacao);
	}
	
	public JLabel getLabelTotal() {
		String lTotal = "Total: Alunos: "+getAlunos()+" Bugs: "+getBugs();
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

}
