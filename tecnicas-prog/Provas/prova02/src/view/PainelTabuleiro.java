package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import controller.*;

public class PainelTabuleiro extends Painel{
	
	private Plano plano;
	private ArrayList<Botao> botoesCelulas;

	public PainelTabuleiro(Color color, Janela janela) {
		super(color, janela);
		this.setPlano(new Plano(8,8));
		this.setLayout(new GridLayout(8,8));
		this.setBotoesCelulas(new ArrayList<Botao>());
		for (Celula celula : plano.getListaCelulas()) {
			Botao botao = new Botao(celula.getSimbolo(), Color.CYAN);
			this.add(botao);
			botoesCelulas.add(botao);
		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public ArrayList<Botao> getBotoesCelulas() {
		return botoesCelulas;
	}

	public void setBotoesCelulas(ArrayList<Botao> botoesCelulas) {
		this.botoesCelulas = botoesCelulas;
	}

}
