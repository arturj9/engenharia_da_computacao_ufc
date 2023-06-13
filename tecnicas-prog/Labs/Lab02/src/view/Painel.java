package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Painel extends JPanel {
	private Janela janela;

	public Painel(Color color, Janela janela) {
		this.setBackground(color);
		this.setJanela(janela);
	}

	public void visivel() {
		this.setVisible(true);
	}

	public void naoVisivel() {
		this.setVisible(false);
	}

	public Janela getJanela() {
		return janela;
	}

	public void setJanela(Janela janela) {
		this.janela = janela;
	}
	
	
}
