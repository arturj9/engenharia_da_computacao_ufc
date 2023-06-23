package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BotaoCelula;
import view.JanelaPrincipal;

public class ProximaJogada implements ActionListener {
	private JanelaPrincipal janela;

	public ProximaJogada(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		for (BotaoCelula botaoCelula : janela.getPainelMenu().getBotoesCelula()) {
			botaoCelula.setEnabled(true);
		}
		janela.getPainelMenu().getPartida().addQuantJogadas();

	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
