package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Celula;

public class PainelMenu extends Painel {

	private JLabel pontuacao;
	private JLabel alunos;
	private JLabel bugs;

	public PainelMenu(Color color, Janela janela) {
		super(color, janela);
		
		this.setPreferredSize(new Dimension(300,700));

		Dimension dimension = new Dimension(290, 50);
		Color corBotao = new Color(134, 193, 239);
		
		Painel painelPontuacao = new Painel(color, janela);
		painelPontuacao.setLayout(new GridLayout(7	,1));
		JLabel labelPontuacao = new JLabel("Pontuação: ");
		pontuacao = new JLabel("2");
		JLabel labelTotal = new JLabel("Total: ");
		JLabel labelAlunos = new JLabel("Alunos: ");
		alunos = new JLabel("4");
		JLabel labelBugs = new JLabel("Bugs: ");
		bugs = new JLabel("3");
		JLabel robop1 = new JLabel("Robo1");
		JLabel robop2 = new JLabel("Robo2");
		JLabel robop3 = new JLabel("Robo3");
		painelPontuacao.add(labelPontuacao);
		painelPontuacao.add(pontuacao);
		painelPontuacao.add(labelTotal);
		painelPontuacao.add(labelAlunos);
		painelPontuacao.add(alunos);
		painelPontuacao.add(labelBugs);
		painelPontuacao.add(bugs);
		painelPontuacao.add(new JLabel(""));
		painelPontuacao.add(robop1);
		painelPontuacao.add(robop2);
		painelPontuacao.add(robop3);
		
		Painel painelRobos = new Painel(color, janela);
		painelRobos.setLayout(new GridLayout(1,3));
		Botao robo1 = new Botao("Robo1", Color.cyan);
		Botao robo2 = new Botao("Robo2", Color.cyan);
		Botao robo3 = new Botao("Robo3", Color.cyan);
		painelRobos.add(robo1);
		painelRobos.add(robo2);
		painelRobos.add(robo3);

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
					janela.getPainelTabuleiro().getBotoesCelulas().get(celula.getId()-1).setBackground(Color.white);
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

	public JLabel getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(JLabel pontuacao) {
		this.pontuacao = pontuacao;
	}

	public JLabel getAlunos() {
		return alunos;
	}

	public void setAlunos(JLabel alunos) {
		this.alunos = alunos;
	}

	public JLabel getBugs() {
		return bugs;
	}

	public void setBugs(JLabel bugs) {
		this.bugs = bugs;
	}

}
