package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import controller.*;
import view.eventos.Movimento;

public class PainelTabuleiro extends Painel {

	private Plano plano;
	private ArrayList<BotaoCelula> botoesCelulas;

	public PainelTabuleiro(Color color, JanelaPrincipal janela) {
		super(color, janela);
		int tamanhoPlano = 8;
		setPlano(new Plano(tamanhoPlano, tamanhoPlano));
		setLayout(new GridLayout(tamanhoPlano, tamanhoPlano));
		setBotoesCelulas(new ArrayList<BotaoCelula>());
		povoar();
	}

	public void povoar() {
		int fator = 0;
		int linha = plano.getTamanhoX();
		for (Celula celula : plano.getListaCelulas()) {
			if (plano.getTamanhoX() * plano.getTamanhoY() == celula.getId() - 1)
				break;
			BotaoCelula botaoCelula = new BotaoCelula(Color.white, celula, new Movimento(getJanela()));
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
			add(botaoCelula);
			botoesCelulas.add(botaoCelula);
		}
	}

	public void atualizar() {
		for (BotaoCelula botaoCelula : botoesCelulas) {
			botaoCelula.atualizaIcon();
		}
	}

	public void verificar() {
		for (Celula celula : getPlano().getListaCelulas()) {
			if (celula.verificaRobo()) {
				celula.setVisitado();
				celula.calcularPontuacao(getJanela().getPainelMenu().getPartida());
				getJanela().getPainelTabuleiro().getBotoesCelulas().get(celula.getId() - 1)
						.setBackground(new Color(200, 236, 249));
				if (!celula.verificaAluno() && !celula.verificaBug())
					getJanela().getPainelMenu().getPartida().addCelulaVazias();
			}

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

}
