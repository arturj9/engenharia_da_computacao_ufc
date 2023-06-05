package questao07;

public class Gerente extends Empregado{
	
	private String departamento;
	
	public Gerente(String nome, float salario, String departamento) {
		super(nome, salario);
		setDepartamento(departamento);
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String toString() {
		return "Nome: "+getNome()+" | Salário: "+getSalario()
		+" | Departamento: "+getDepartamento();
	}

}
