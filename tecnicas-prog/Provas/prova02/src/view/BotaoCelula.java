package view;

import java.awt.Color;

import controller.Celula;

public class BotaoCelula extends Botao {
	
	private Celula celula;

	public BotaoCelula(Color color, Celula celula) {
		super("", color);
		setCelula(celula);
		atualizaIcon();
	}

	public Celula getCelula() {
		return celula;
	}

	public void setCelula(Celula celula) {
		this.celula = celula;
	}
	
	public void atualizaIcon() {
		if(celula.getIcon()!=null)
			setIcon(celula.getIcon().getIcon(50, 50));
		else
			setIcon(null);
	}

}
