package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Painel extends JPanel {
	public Janela janela;
	
	public Painel(Color color, Janela janela) {
		this.setBackground(color);
		this.janela=janela;
	}
	
	public void visivel() {
		this.setVisible(true);
	}
	
	public void naoVisivel() {
		this.setVisible(false);
	}
}
