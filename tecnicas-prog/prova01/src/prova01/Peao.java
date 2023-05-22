package prova01;

public class Peao extends Robo {

	public Peao(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public void avancar(int numero) {
		if(numero==1)
			this.movimentar(getPosicaox(), getPosicaoy()+1);
	}

	public void retroceder(int numero) {
		if(numero==1)
			this.movimentar(getPosicaox(), getPosicaoy()-1);
	}
}
