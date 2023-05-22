package prova01;

public class Torre extends Robo{

	public Torre(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public void avancar(int numero) {
		if(numero>0&&numero<=2)
			this.movimentar(getPosicaox()+numero, getPosicaoy());
	}

	public void retroceder(int numero) {
		if(numero>0&&numero<=2)
			this.movimentar(getPosicaox()-numero, getPosicaoy());
	}
}
