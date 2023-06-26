package controller;

public abstract class Personagem {

	private Icon icon;
	private String nome;

	public Personagem(Icon icon, String nome) {
		this.setIcon(icon);
		this.nome = nome;
	}

	public Personagem(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

}
