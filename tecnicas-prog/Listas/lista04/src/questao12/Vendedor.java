package questao12;

import questao10.Empregado;

public class Vendedor extends Empregado {
	private float valorVenda;
	private float comissao;
	
	public Vendedor(String nome, int codigoSetor, float salarioBase, float imposto, float valorVenda,
			float comissao) {
		super(nome, codigoSetor, salarioBase, imposto);
		this.setValorVenda(valorVenda);
		this.setComissao(comissao);
	}
	
	public String getDados() {
		return "Nome: " + this.getNome() 
		+ "\nCódigo do Setor: " + this.getCodigoSetor()  
		+ "\nSalário Base: " + this.getSalarioBase() 
		+ "\nImposto: " + this.getImposto() + "%"
		+ "\nValor de Venda: " + this.getValorVenda()
		+ "\nComissão: " + this.getComissao() + "%"
		+ "\nSalário: " + this.calcularSalario();
	}
	
	public float calcularSalario() {
		return (this.getSalarioBase() + (this.getValorVenda() * (this.getComissao()/100))) 
				* (1-(this.getImposto()/100));
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

}
