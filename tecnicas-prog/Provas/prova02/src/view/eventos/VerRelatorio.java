package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Alerta;
import view.JanelaPrincipal;
import view.JanelaRelatorio;
import view.excecoes.LerDadosException;

public class VerRelatorio implements ActionListener {

	private JanelaPrincipal janela;

	public VerRelatorio(JanelaPrincipal janela) {
		this.setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			JanelaRelatorio relatorio = new JanelaRelatorio();
		} catch (LerDadosException ed) {
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
