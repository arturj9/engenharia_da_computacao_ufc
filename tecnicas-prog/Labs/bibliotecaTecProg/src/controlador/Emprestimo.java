package controlador;

public class Emprestimo {

	private Cliente cliente;
	private Publicacao publicacao;

	public Emprestimo(Cliente cliente, Publicacao publicacao) {
		this.cliente = cliente;
		this.publicacao = publicacao;
	}

	public String retornarDadosEmprestimo() {

		String saida = "";
		saida = this.cliente.tipo+":" + this.cliente.nome + " - " + publicacao.tipo + ": " + this.publicacao.getTitulo()
				+ " - Dias de emprestimo:" + cliente.verificarDias();
		return saida;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Publicacao getPublicacao() {
		return publicacao;
	}
}
