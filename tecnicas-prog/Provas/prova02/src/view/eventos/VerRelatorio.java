package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JanelaPrincipal;
import view.JanelaRelatorio;

public class VerRelatorio implements ActionListener {
	private JanelaPrincipal janela;

	public VerRelatorio(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		JanelaRelatorio relatorio = new JanelaRelatorio();
	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
