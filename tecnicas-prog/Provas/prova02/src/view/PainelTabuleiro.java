package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import controller.*;

public class PainelTabuleiro extends Painel {

	private Plano plano;
	private ArrayList<BotaoCelula> botoesCelulas;

	public PainelTabuleiro(Color color, Janela janela) {
		super(color, janela);
		this.setPlano(new Plano(8, 8));
		this.setLayout(new GridLayout(8, 8));
		this.setBotoesCelulas(new ArrayList<BotaoCelula>());
		int fator = 0;
		int linha = plano.getTamanhoX();
		for (Celula celula : plano.getListaCelulas()) {
			if (plano.getTamanhoX() * plano.getTamanhoY() == celula.getId() - 1)
				break;
			BotaoCelula botaoCelula = new BotaoCelula(Color.white, celula);
			botaoCelula.addActionListener(new Mover(janela));
			if (celula.getPosicaoX() != linha) {
				linha--;
				if (fator == 0)
					fator = 1;
				else
					fator = 0;
			}
			if (celula.getId() % 2 != fator)
				botaoCelula.setBackground(Color.cyan);
			botaoCelula.setBorder(new BevelBorder(1, Color.cyan, Color.cyan));
			this.add(botaoCelula);
			botoesCelulas.add(botaoCelula);
		}
	}

	public void povoar() {

	}

	private class Mover implements ActionListener {

		private Janela janela;

		public Mover(Janela janela) {
			this.setJanela(janela);
		}

		public void actionPerformed(ActionEvent e) {
			BotaoCelula botaoCelula = (BotaoCelula) e.getSource();
			Robo robo = janela.getPainelMenu().getRoboSelecionado();
			if (janela.getPainelMenu().verificaRoboSelecionado() && !botaoCelula.getCelula().verificaRobo()
					&& !botaoCelula.getCelula().isVisitado()) {
				if (robo.movimentar(botaoCelula.getCelula())) {
					atualizar();
					janela.getPainelMenu().atualizar();
					janela.getPainelMenu().botoesDefault();
				} else {

				}
			} else if (janela.getPainelMenu().addRoboSelecionado(botaoCelula.getCelula().getRobo())) {
			} else {
				JOptionPane.showMessageDialog(getJanela(), "Selecione um robô", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}

		public Janela getJanela() {
			return janela;
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public ArrayList<BotaoCelula> getBotoesCelulas() {
		return botoesCelulas;
	}

	public void setBotoesCelulas(ArrayList<BotaoCelula> botoesCelulas) {
		this.botoesCelulas = botoesCelulas;
	}

	public void atualizar() {
		for (BotaoCelula botaoCelula : botoesCelulas) {
			botaoCelula.atualizaIcon();
		}
	}

}
