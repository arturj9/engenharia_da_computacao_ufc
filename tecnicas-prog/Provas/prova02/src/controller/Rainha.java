package controller;

public class Rainha extends Robo {
	
	public Rainha(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public boolean avancar(int numero) {
		if(numero>0&&numero<=4) {
			if(this.movimentar(getPosicaox()+numero, getPosicaoy()+numero))
				return true;
		}
		return false;
	}

	public boolean retroceder(int numero) {
		if(numero>0&&numero<=4) {
			if(this.movimentar(getPosicaox()-numero, getPosicaoy()+numero))
				return true;
		}
		return false;
	}
}
