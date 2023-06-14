package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PainelInicial extends Painel{
	
	private JTextField nome; 

	public PainelInicial(Color color, Janela janela) {
		super(color, janela);
		
		Dimension dimension = new Dimension(200, 30);
		Color corBotao = new Color(134,193,239);
		
		this.add(new JLabel("Nome do Jogador:"));
		nome = new JTextField();
		nome.setPreferredSize(dimension);
		this.add(nome);
		Botao botaoJogar = new Botao("Jogar",corBotao);
		botaoJogar.addActionListener(new Jogar(janela));
		Botao botaoRelatorio = new Botao("Relatório De Jogo",corBotao);
		this.add(botaoJogar);
		this.add(botaoRelatorio);
	}
	
	private class Jogar implements ActionListener {
		
		private Janela janela;
		
		public Jogar(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			janela.getPainelTabuleiro().visivel();
			janela.getPainelMenu().visivel();

		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}


}
