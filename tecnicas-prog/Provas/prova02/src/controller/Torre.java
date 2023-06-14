package controller;

public class Torre extends Robo{

	public Torre(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public boolean avancar(int numero) {
		if(numero>0&&numero<=2) {
			if(this.movimentar(getPosicaox()+numero, getPosicaoy()))
				return true;
		}
		return false;
	}

	public boolean retroceder(int numero) {
		if(numero>0&&numero<=2) {
			if(this.movimentar(getPosicaox()-numero, getPosicaoy()))
				return true;
		}
		return false;
	}
}
