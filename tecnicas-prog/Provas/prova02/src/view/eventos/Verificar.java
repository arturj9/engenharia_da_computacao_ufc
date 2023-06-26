package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import view.Alerta;
import view.JanelaPrincipal;
import view.PainelMenu;
import view.excecoes.OpcaoInvalidaException;

public class Verificar implements ActionListener {

	private JanelaPrincipal janela;

	public Verificar(JanelaPrincipal janela) {
		setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		PainelMenu painelMenu = janela.getPainelMenu();
		try {
			if (painelMenu.isVerificado())
				throw new OpcaoInvalidaException("Avance para a próxima jogada");
			if (painelMenu.umRoboEstaDefault())
				throw new OpcaoInvalidaException("Posicione todos os robôs");

			janela.getPainelTabuleiro().verificar();
			painelMenu.robosDefault();
			painelMenu.atualizar();
			painelMenu.setVerificado(true);
			janela.getPainelMenu().retiraRoboSelecionado();
			janela.getPainelTabuleiro().atualizar();
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
