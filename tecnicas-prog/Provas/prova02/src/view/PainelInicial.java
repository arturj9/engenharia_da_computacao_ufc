package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Jogador;

public class PainelInicial extends Painel {

	private Input nome;
	private Botao botaoJogar;

	public PainelInicial(Color color, Janela janela) {
		super(color, janela);

		Dimension dimensionInput = new Dimension(200, 30);
		
		this.add(new JLabel("Nome do Jogador:"));
		nome = new Input(dimensionInput);
		this.add(nome);
		
		configurarBotoes();
		
	}
	
	public void configurarBotoes() {
		Color corBotao = new Color(134, 193, 239);
		
		setBotaoJogar(new Botao("Jogar", corBotao));
		botaoJogar.addActionListener(new Jogar(getJanela()));
		Botao botaoRelatorio = new Botao("Relatório De Jogo", corBotao);
		
		this.add(botaoJogar);
		this.add(botaoRelatorio);
	}
	
	public void nomeEstatico() {
		nome.setEditable(false);
	}

	private class Jogar implements ActionListener {

		private Janela janela;

		public Jogar(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			if (!nome.getText().equals("")) {
				janela.getPainelTabuleiro().visivel();
				janela.getPainelMenu().visivel();
				nomeEstatico();
				janela.getPainelMenu().setJogador(new Jogador(nome.getText()));
				botaoJogar.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(getJanela(), "Informe o nome do jogador", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}

	public Input getNome() {
		return nome;
	}

	public void setNome(Input nome) {
		this.nome = nome;
	}

	public Botao getBotaoJogar() {
		return botaoJogar;
	}

	public void setBotaoJogar(Botao botaoJogar) {
		this.botaoJogar = botaoJogar;
	}

}
