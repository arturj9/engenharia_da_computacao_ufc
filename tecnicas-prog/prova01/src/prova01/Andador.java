package prova01;

public class Andador extends Robo{
	
	public Andador(int id, String nome, int posicaox, int posicaoy, Plano plano, String identificador) {
		super(id, nome, posicaox, posicaoy, plano, identificador);
	}

	public void avancar(int numero) {
		this.movimentar(getPosicaox()+numero, getPosicaoy());
	}

	public void retroceder(int numero) {
		this.movimentar(getPosicaox()-numero, getPosicaoy());
	}
	
}
