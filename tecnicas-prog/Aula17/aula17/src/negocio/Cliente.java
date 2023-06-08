package negocio;

public class Cliente {

	public String nome;
	public int id;
	public String cpf;

	public Cliente(String nome, int id, String cpf) {
		this.nome = nome;
		this.id = id;
		this.cpf = cpf;
	}
	
	public void alterarNome(String nome) {
		this.nome = nome;
	}
	
//	public void Imprimir() {
//		System.out.println(" {{{ id: " + this.id + " nome: "+ this.nome + " CPF: " + this.cpf + " }}}" );
//	}
	
}
