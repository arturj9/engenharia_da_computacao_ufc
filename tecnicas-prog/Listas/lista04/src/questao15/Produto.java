package questao15;

public class Produto {
	private String nome;
	private float precoCusto;
	private float precoVenda;
	private float margemLucro;
	private float despesasEmpresa;
	
	public Produto(String nome, float precoCusto, float precoVenda, float despesasEmpresa) {
		this.setNome(nome);
		this.setPrecoCusto(precoCusto);
		this.setPrecoVenda(precoVenda);
		this.setDespesasEmpresa(despesasEmpresa);
	}

	public void calculoMargemLucro() {
		this.setMargemLucro(((this.getPrecoVenda()-(this.getPrecoCusto()+this.getDespesasEmpresa()))
				/this.getPrecoVenda())*100);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}
	public float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public float getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(float margemLucro) {
		this.margemLucro = margemLucro;
	}
	public float getDespesasEmpresa() {
		return despesasEmpresa;
	}
	public void setDespesasEmpresa(float despesasEmpresa) {
		this.despesasEmpresa = despesasEmpresa;
	}
	
}
