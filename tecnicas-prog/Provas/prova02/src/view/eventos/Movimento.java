package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Robo;
import view.Alerta;
import view.BotaoCelula;
import view.JanelaPrincipal;
import view.excecoes.OpcaoInvalidaException;

public class Movimento implements ActionListener {

	private JanelaPrincipal janela;

	public Movimento(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		BotaoCelula botaoCelula = (BotaoCelula) e.getSource();
		Robo robo = janela.getPainelMenu().getRoboSelecionado();
		try {
			if (botaoCelula.getCelula().isVisitado())
				throw new OpcaoInvalidaException("Célula já visitada");
			if (!janela.getPainelMenu().verificaRoboSelecionado())
				throw new OpcaoInvalidaException("Selecione um robô");
			if (!botaoCelula.getCelula().verificaRobo()) {
				robo.movimentar(botaoCelula.getCelula());
				janela.getPainelTabuleiro().atualizar();
				janela.getPainelMenu().atualizar();
				janela.getPainelMenu().botoesDefault();
			} else
				janela.getPainelMenu().addRoboSelecionado(botaoCelula.getCelula().getRobo());
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
