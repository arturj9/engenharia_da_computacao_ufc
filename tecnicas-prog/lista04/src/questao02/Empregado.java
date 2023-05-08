package questao02;

public class Empregado {
	
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
