package view;

import java.awt.Color;
import java.awt.GridLayout;

import controller.*;

public class PainelTabuleiro extends Painel{
	
	private Plano plano;

	public PainelTabuleiro(Color color, Janela janela) {
		super(color, janela);
		this.setPlano(new Plano(8,8));
		this.setLayout(new GridLayout(8,8));
		for (Celula celula : plano.getListaCelulas()) {
			this.add(new Botao(celula.getSimbolo(), Color.CYAN));
		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

}
