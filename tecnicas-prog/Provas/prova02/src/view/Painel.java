package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Painel extends JPanel {

	private JanelaPrincipal janela;

	public Painel(Color color, JanelaPrincipal janela) {
		this.setBackground(color);
		this.setJanela(janela);
	}

	public void visivel() {
		this.setVisible(true);
	}

	public void naoVisivel() {
		this.setVisible(false);
	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}

}
