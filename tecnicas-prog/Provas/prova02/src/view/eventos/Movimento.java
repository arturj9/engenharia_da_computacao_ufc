package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.Robo;
import view.BotaoCelula;
import view.JanelaPrincipal;

public class Movimento implements ActionListener {
	private JanelaPrincipal janela;

	public Movimento(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		BotaoCelula botaoCelula = (BotaoCelula) e.getSource();
		Robo robo = janela.getPainelMenu().getRoboSelecionado();
		if (janela.getPainelMenu().verificaRoboSelecionado() && !botaoCelula.getCelula().verificaRobo()
				&& !botaoCelula.getCelula().isVisitado()) {
			if (robo.movimentar(botaoCelula.getCelula())) {
				janela.getPainelTabuleiro().atualizar();
				janela.getPainelMenu().atualizar();
				janela.getPainelMenu().botoesDefault();
			} else {

			}
		} else if (janela.getPainelMenu().addRoboSelecionado(botaoCelula.getCelula().getRobo())) {
		} else {
			JOptionPane.showMessageDialog(getJanela(), "Selecione um robô", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
