package controlador;

public abstract class Publicacao {

	private String titulo;
	protected int ano;
	protected String autor;
	private int quantidadeDisponivel;

	protected String tipo;
	
	public Publicacao(String titulo, int ano, String autor, int quantidadeDisponivel) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
}
