package controller;

public class Cavalo extends Robo {

	public Cavalo(Plano plano) {
		super("Cavalo", plano, new Icon("src/img/cavalo.png"));
	}

	public Cavalo(Plano plano, int pontuacao) {
		super("Cavalo", plano, new Icon("src/img/cavalo.png"), pontuacao);
	}
	
}
