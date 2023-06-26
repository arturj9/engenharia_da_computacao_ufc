package controller;

public class Andador extends Robo {

	public Andador(Plano plano) {
		super("Andador", plano, new Icon("src/img/andador.png"));
	}

	public Andador(Plano plano, int pontuacao) {
		super("Andador", plano, new Icon("src/img/andador.png"), pontuacao);
	}

}
