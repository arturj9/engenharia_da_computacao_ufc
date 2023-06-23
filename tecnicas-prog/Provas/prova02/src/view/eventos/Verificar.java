package view.eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Celula;
import view.JanelaPrincipal;
import view.PainelMenu;

public class Verificar implements ActionListener {
	private JanelaPrincipal janela;

	public Verificar(JanelaPrincipal janela) {
		setJanela(janela);
	}

	public void actionPerformed(ActionEvent e) {
		PainelMenu painelMenu = janela.getPainelMenu(); 
		if (painelMenu.verificaRobos()) {
			for (Celula celula : janela.getPainelTabuleiro().getPlano().getListaCelulas()) {
				if (celula.verificaRobo()) {
					painelMenu.getPartida().retiraCelulaVazias();
					celula.setVisitado();
					celula.calcularPontuacaoRobo(painelMenu.getPartida());
					janela.getPainelTabuleiro().getBotoesCelulas().get(celula.getId() - 1)
							.setBackground(new Color(200, 236, 249));
				}

			}
			painelMenu.atualizaPontuacao();
			painelMenu.atualizaPainelTotal();
			painelMenu.getPainelPontuacao().removeAll();
			painelMenu.getPainelPontuacao().add(painelMenu.getLabelPontuacao());
			painelMenu.getPainelPontuacao().add(new JLabel());
			painelMenu.getPainelPontuacao().add(painelMenu.getPainelTotal());
			painelMenu.getPainelPontuacao().add(new JLabel());
			painelMenu.getPainelPontuacao().add(painelMenu.getPainelRobosPontuacao());
			painelMenu.robosDefault();
			painelMenu.atualizar();
			janela.getPainelTabuleiro().atualizar();
		} else
			JOptionPane.showMessageDialog(getJanela(), "Posicione todos os robos", "Aviso",
					JOptionPane.WARNING_MESSAGE);

	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
