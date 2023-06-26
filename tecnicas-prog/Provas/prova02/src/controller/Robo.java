package controller;

public class Robo extends Personagem {

	private Plano plano;
	private int pontuacao;

	public Robo(String nome, Plano plano, Icon icon) {
		super(icon, nome);
		this.setPlano(plano);
		this.setPontuacao(0);
	}

	public Robo(String nome, Plano plano, Icon icon, int pontuacao) {
		super(icon, nome);
		this.setPlano(plano);
		this.setPontuacao(pontuacao);
	}

	public void movimentar(Celula novaCelula) {
		Celula celulaAtual = plano.retornarCelulaDeRobo(this);
		celulaAtual.retirarRobo();
		novaCelula.addRobo(this);
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

}
