package view;

import javax.swing.JOptionPane;

public class Alerta extends JOptionPane {

	public Alerta(Janela janela, String msg) {
		showMessageDialog(janela, msg, "Aviso", JOptionPane.WARNING_MESSAGE);
	}

}
