package controller;

public class Rei extends Robo {

	public Rei(Plano plano) {
		super("Rei", plano, new Icon("src/img/rei.png"));
	}
	
	public Rei(Plano plano, int pontuacao) {
		super("Rei", plano, new Icon("src/img/rei.png"), pontuacao);
	}

}
