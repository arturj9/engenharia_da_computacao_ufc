package questao11;

import questao10.Empregado;

public class Operario extends Empregado {
	
	private float valorProducao;
	private float comissao;
	
	
	public Operario(String nome, int codigoSetor, float salarioBase, float imposto, float valorProducao,
			float comissao) {
		super(nome, codigoSetor, salarioBase, imposto);
		this.valorProducao = valorProducao;
		this.comissao = comissao;
	}
	
	public String getDados() {
	return "Nome: " + this.getNome() 
		+ "\nCódigo do Setor: " + this.getCodigoSetor()  
		+ "\nSalário Base: " + this.getSalarioBase() 
		+ "\nImposto: " + this.getImposto() + "%"
		+ "\nValor de Produção: " + this.getValorProducao()
		+ "\nComissão: " + this.getComissao() + "%"
		+ "\nSalário: " + this.calcularSalario();
	}
	
	public float calcularSalario() {
		return (this.getSalarioBase() + (this.getValorProducao() * (this.getComissao()/100))) 
				* (1-(this.getImposto()/100));
	}

	public float getValorProducao() {
		return valorProducao;
	}
	public void setValorProducao(float valorProducao) {
		this.valorProducao = valorProducao;
	}
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
}
