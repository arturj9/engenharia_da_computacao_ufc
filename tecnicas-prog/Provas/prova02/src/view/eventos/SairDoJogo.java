package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Partidas;
import view.JanelaPrincipal;
import view.JanelaRelatorio;

public class SairDoJogo implements ActionListener {
	private JanelaPrincipal janela;

	public SairDoJogo(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		Partidas partidas = new Partidas();
		partidas.addPartida(janela.getPainelMenu().getPartida());
		new JanelaRelatorio().fecharPrograma();
		janela.dispose();

	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
