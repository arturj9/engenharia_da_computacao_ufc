package prova01;

public class Rei extends Robo {

	public Rei(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public void avancar(int numero) {
		if(numero>0&&numero<=4)
			this.movimentar(getPosicaox()+numero, getPosicaoy()+numero);
	}

	public void retroceder(int numero) {
		if(numero>0&&numero<=4)
			this.movimentar(getPosicaox()-numero, getPosicaoy()-numero);
	}

}
