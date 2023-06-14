package controller;

public class Andador extends Robo{
	
	public Andador(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public boolean avancar(int numero) {
		if(this.movimentar(getPosicaox()+numero, getPosicaoy()))
			return true;
		return false;
	}

	public boolean retroceder(int numero) {
		if(this.movimentar(getPosicaox()-numero, getPosicaoy()))
				return true;
		return false;
	}
	
}
