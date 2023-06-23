package view.eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BotaoCelula;
import view.JanelaPrincipal;

public class Selecionar implements ActionListener {
	private JanelaPrincipal janela;

	public Selecionar(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		BotaoCelula botaoCelula = (BotaoCelula) e.getSource();
		janela.getPainelMenu().botoesDefault();;
		if (janela.getPainelMenu().addRoboSelecionado(botaoCelula.getCelula().getRobo())) {
			botaoCelula.setBackground(Color.white);
		} else {
			janela.getPainelMenu().retiraRoboSelecionado();
		}

	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
