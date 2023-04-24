package classes;

public class Empregado {
//	2) A fim de representar empregados em uma firma, você deverá criar uma
//	classe chamada Empregado. Esta classe deverá possuir as três informações
//	a seguir:
//	a. Um primeiro nome,
//	b. Um sobrenome,
//	c. Um salário mensal.
//	Sua classe deve ter um construtor que inicializa os três atributos. Forneça um
//	método set e get para cada atributo. Se o salário mensal não for positivo,
//	configure-o como 0.0. 
	
	private String primeiroNome;
	private String sobrenome;
	private double salarioMensal;
	
	public Empregado(String primeiroNome, String sobrenome, double salarioMensal) {
		this.setPrimeiroNome(primeiroNome);
		this.setSobrenome(sobrenome);
		this.setSalarioMensal(salarioMensal);
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		if(salarioMensal<0)
			this.salarioMensal = 0;
		else
			this.salarioMensal = salarioMensal;
	}
	
	public void setSalarioMensalEmPorcentagem(double porcentagem) {
	    double novoSalario = this.getSalarioMensal() * (1+(porcentagem/100));
	    this.setSalarioMensal(novoSalario);
	}
	
	public double getSalarioAnual() {
		return 12*getSalarioMensal();
	}
}
