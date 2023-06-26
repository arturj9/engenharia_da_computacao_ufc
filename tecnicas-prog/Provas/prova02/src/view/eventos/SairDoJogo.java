package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Partidas;
import view.Alerta;
import view.JanelaPrincipal;
import view.JanelaRelatorio;
import view.excecoes.EscreverDadosException;
import view.excecoes.LerDadosException;

public class SairDoJogo implements ActionListener {

	private JanelaPrincipal janela;

	public SairDoJogo(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Partidas partidas = new Partidas();
			partidas.addPartida(janela.getPainelMenu().getPartida());
			new JanelaRelatorio().fecharPrograma();
			janela.dispose();
		} catch (LerDadosException ed) {
			new Alerta(janela, ed.getMessage());
		} catch (EscreverDadosException ed) {
			new Alerta(janela, ed.getMessage());
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
