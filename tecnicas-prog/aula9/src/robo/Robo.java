package robo;

public class Robo {

	public int id;
	public String nome;
	public int posicaox;
	public int posicaoy;
	public Plano plano;

	public Robo(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		this.id = id;
		this.nome = nome;
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.plano = plano;

		Celula aux = null;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == posicaox && aux.posicaoY == posicaoy) {
				aux.robo = this;
			}
		}
	}

	public void moverEsquerda() {
		for (int i = 0; i < plano.listaCelulas.size(); i++) {

			if (plano.listaCelulas.get(i).robo != null) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i - 1).robo = this;
			}
		}

	}

	public int moverDireita() {
		return posicaox + 1;
	}
}
