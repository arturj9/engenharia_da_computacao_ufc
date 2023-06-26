package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Alerta;
import view.BotaoCelula;
import view.JanelaPrincipal;
import view.excecoes.OpcaoInvalidaException;

public class ProximaJogada implements ActionListener {

	private JanelaPrincipal janela;

	public ProximaJogada(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (!janela.getPainelMenu().isVerificado())
				throw new OpcaoInvalidaException("Verifique antes de avançar");
			for (BotaoCelula botaoCelula : janela.getPainelMenu().getBotoesCelula()) {
				botaoCelula.habilitar();
			}
			janela.getPainelMenu().getPartida().addQuantJogadas();
			janela.getPainelMenu().setVerificado(false);
		} catch (OpcaoInvalidaException oi) {
			new Alerta(getJanela(), oi.getMessage());
		} catch (Exception ed) {
			new Alerta(janela, "Erro: " + ed.getMessage());
		}
	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}

}
