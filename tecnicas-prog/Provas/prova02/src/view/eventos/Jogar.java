package view.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.Jogador;
import controller.Partida;
import view.JanelaPrincipal;
import view.PainelInicial;

public class Jogar implements ActionListener {
	private JanelaPrincipal janela;

	public Jogar(JanelaPrincipal janela) {
		setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		PainelInicial painelInicial = janela.getPainelInicial();
		if (!painelInicial.getNome().getText().equals("")) {
			janela.getPainelTabuleiro().visivel();
			janela.getPainelMenu().visivel();
			painelInicial.nomeEstatico();
			janela.getPainelMenu()
					.setPartida(new Partida(new Jogador(painelInicial.getNome().getText()),
							janela.getPainelTabuleiro().getPlano().getQuantCelula(),
							janela.getPainelTabuleiro().getPlano().getRobos()));
			painelInicial.getBotaoJogar().setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(getJanela(), "Informe o nome do jogador", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
