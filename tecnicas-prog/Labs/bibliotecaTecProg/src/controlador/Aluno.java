package controlador;

public class Aluno extends Cliente {

	public Aluno(int matricula, String nome) {
		super(matricula, nome);
		this.tipo="Aluno";
	}

	public int verificarDias() {
		return 10;
	}
	
	public int verificarPublicacaos() {
		return 5;
	}

}
