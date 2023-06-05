package questao07;

public class Vendedor extends Empregado{
	
	private float comissao;

	public Vendedor(String nome, float salario, float comissao) {
		super(nome, salario);
		setComissao(comissao);
	}
	
	public float calcularSalario() {
		return salario*(1+comissao/100);
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
	public String toString() {
		return "Nome: "+getNome()
		+"\nSalário sem comissão: "+getSalario()
		+"\nSalário com comissão: "+calcularSalario()
		+"\nComissão: "+getComissao()+"%";
	}

}
