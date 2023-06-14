package view;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton {
	public Botao(String msg, Color color) {
		super(msg);
		this.setBackground(color);
	}
}
