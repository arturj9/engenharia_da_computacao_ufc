package questao04;

public class Produto {
	public String nome;
	public float preco;
	public int quantidade;
	
	public Produto(String nome, float preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public String comprarProduto(int quantComprada) {
		if(quantComprada>quantidade||quantComprada<=0)
			return "Informe uma quantidade válida";
		
		quantidade -= quantComprada;
		
		float valorTotal = quantComprada * preco;
		
		if(valorTotal>=100&&valorTotal<200)
			valorTotal = (float) (valorTotal * 0.9);
		else if(valorTotal>=200&&valorTotal<=500)
			valorTotal= (float) (valorTotal * 0.8);
		else if(valorTotal>500)
			valorTotal = (float) (valorTotal * 0.75);
		
		return "Nome do Produto: "+nome+" | Valor total: R$"+valorTotal;
		
	}
	
	
}
