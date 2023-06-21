package questao10;

public class Empregado extends Pessoa {
	private int codigoSetor;
	private float salarioBase;
	private float imposto;
	
	public Empregado(String nome, int codigoSetor, float salarioBase, float imposto) {
		super(nome);
		this.codigoSetor = codigoSetor;
		this.salarioBase = salarioBase;
		this.imposto = imposto;
	}
	
	public String getDados() {
		return "Nome: " + this.getNome() 
		+ "\nCódigo do Setor: " + this.getCodigoSetor() 
		+ "\nSalário Base: " + this.getSalarioBase() 
		+ "\nImposto: " + this.getImposto() + "%"
		+ "\nSalário com imposto: " + this.calcularSalario();
	}



	public float calcularSalario() {
		return this.getSalarioBase() * (1-(this.getImposto()/100));
	}

	public int getCodigoSetor() {
		return codigoSetor;
	}

	public void setCodigoSetor(int codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}

	public float getImposto() {
		return imposto;
	}

	public void setImposto(float imposto) {
		this.imposto = imposto;
	}
}
