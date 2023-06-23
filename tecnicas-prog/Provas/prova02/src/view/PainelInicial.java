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
import controller.Partida;
import view.eventos.Jogar;
import view.eventos.VerRelatorio;

public class PainelInicial extends Painel {

	private Input nome;
	private Botao botaoJogar;

	public PainelInicial(Color color, JanelaPrincipal janela) {
		super(color, janela);

		Dimension dimensionInput = new Dimension(200, 30);

		add(new JLabel("Nome do Jogador:"));
		nome = new Input(dimensionInput);
		add(nome);

		configurarBotoes();

	}

	public void configurarBotoes() {
		Color corBotao = new Color(134, 193, 239);

		setBotaoJogar(new Botao("Jogar", corBotao, new Jogar(getJanela())));
		add(botaoJogar);
		add(new Botao("Relatório De Jogo", corBotao, new VerRelatorio(getJanela())));
	}

	public void nomeEstatico() {
		nome.setEditable(false);
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
