package questao04;

public class Produto {
//	4) Crie um programa que tenha uma classe produto constituída de nome, preço
//	e quantidade. Implemente um método chamado “comprarProduto”. Este
//	método quando chamado deverá modificar uma variável do produto indicando
//	que o produto foi comprado. Para cada produto informado escreva o nome do
//	produto comprado e o valor total a ser pago, considerando que são
//	oferecidos descontos segundo o valor do produto conforme a tabela abaixo:
//	a. Até R$ 100: sem desconto
//	b. De R$ 100 a R$ 200: 10% de desconto
//	c. De R$ 200 a R$ 500: 20% de desconto
//	d. Acima de R$500: 25% de desconto
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
