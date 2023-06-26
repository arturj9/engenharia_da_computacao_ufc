package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.Jogador;
import controller.Partida;
import view.Alerta;
import view.JanelaPrincipal;
import view.PainelInicial;
import view.excecoes.CampoVazioException;

public class Jogar implements ActionListener {

	private JanelaPrincipal janela;

	public Jogar(JanelaPrincipal janela) {
		setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		PainelInicial painelInicial = janela.getPainelInicial();
		try {
			if (painelInicial.getNome().getText().equals(""))
				throw new CampoVazioException("Informe o nome do jogador");
			janela.paineisVisiveis();
			janela.getPainelMenu().setPartida(new Partida(new Jogador(painelInicial.getNome().getText()),
					janela.getPainelTabuleiro().getPlano().getRobos()));
			painelInicial.getBotaoJogar().desabilitar();
		} catch (CampoVazioException cv) {
			new Alerta(janela, cv.getMessage());
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
