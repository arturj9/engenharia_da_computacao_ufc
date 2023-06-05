package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Painel extends JPanel {
	public Painel(Color color) {
		this.setBackground(color);
	}
	
	public void visivel() {
		this.setVisible(true);
	}
	
	public void naoVisivel() {
		this.setVisible(false);
	}
}
