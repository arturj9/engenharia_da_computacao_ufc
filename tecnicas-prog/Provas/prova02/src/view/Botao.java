package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Botao extends JButton {

	public Botao(String msg, Color color, ActionListener action) {
		super(msg);
		setBackground(color);
		addActionListener(action);
	}

	public void desabilitar() {
		setEnabled(false);
	}

	public void habilitar() {
		setEnabled(true);
	}

}
