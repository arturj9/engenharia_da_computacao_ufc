package questao07;

public class Empregado {
	private String nome;
	protected float salario;
	
	public Empregado(String nome, float salario) {
		this.nome = nome;
		this.salario = salario;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Nome: "+getNome()+" | Salário: "+getSalario();
	}
}
