package prova01;

public class Rainha extends Robo {
	
	public Rainha(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public void avancar(int numero) {
		if(numero>0&&numero<=4)
			this.movimentar(getPosicaox()+numero, getPosicaoy()+numero);
	}

	public void retroceder(int numero) {
		if(numero>0&&numero<=4)
			this.movimentar(getPosicaox()-numero, getPosicaoy()+numero);
	}
}
