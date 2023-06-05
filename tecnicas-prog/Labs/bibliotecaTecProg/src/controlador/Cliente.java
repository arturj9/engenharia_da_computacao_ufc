package controlador;

public abstract class Cliente implements ValidacaoEmprestimo{

	private  int matricula;
	protected String nome;
	protected float tps;
	protected String tipo;
	
	public Cliente(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.tps=0;
	}

	public int getMatricula() {
		return matricula;
	}
	
}
