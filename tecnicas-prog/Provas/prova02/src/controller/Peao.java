package controller;

public class Peao extends Robo {

	public Peao(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public boolean avancar(int numero) {
		if(numero==1) {
			if(this.movimentar(getPosicaox(), getPosicaoy()+1))
				return true;
		}
		return false;
	}

	public boolean retroceder(int numero) {
		if(numero==1) {
			if(this.movimentar(getPosicaox(), getPosicaoy()-1))
				return true;
		}
		return false;
	}
}
