package controlador;

public class Revista extends Publicacao {

	public Revista(String titulo, int ano, String autor, int quantidadeDisponivel) {
		super(titulo, ano, autor, quantidadeDisponivel);
		this.tipo="Revista";
	}

}
