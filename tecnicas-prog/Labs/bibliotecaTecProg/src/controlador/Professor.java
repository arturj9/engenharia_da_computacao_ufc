package controlador;

public class Professor extends Cliente {

	public Professor(int matricula, String nome) {
		super(matricula, nome);
		this.tipo="Professor";
	}

	public int verificarDias() {
		return 20;
	}
	
	public int verificarPublicacaos() {
		return 10;
	}

}
