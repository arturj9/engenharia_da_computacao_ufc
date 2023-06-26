package controller;

public class FabricaRobos {

	private Plano plano;

	public FabricaRobos(Plano plano) {
		setPlano(plano);
	}

	public FabricaRobos() {
		setPlano(null);
	}

	public Robo criarRobo(Robos tipo) {
		switch (tipo) {
		case ANDADOR:
			return new Andador(plano);
		case CAVALO:
			return new Cavalo(plano);
		case REI:
			return new Rei(plano);
		default:
			return null;
		}
	}

	public Robo criarRobo(Robos tipo, int pontuacao) {
		switch (tipo) {
		case ANDADOR:
			return new Andador(plano, pontuacao);
		case CAVALO:
			return new Cavalo(plano, pontuacao);
		case REI:
			return new Rei(plano, pontuacao);
		default:
			return null;
		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

}
