package questao05;

import java.util.ArrayList;

public class Agenda {
	private String nome;
	private String observacao;
	private ArrayList<Contato> contatos;
	
	public Agenda(String nome, String observacao) {
		super();
		this.nome = nome;
		this.observacao = observacao;
		this.contatos = new ArrayList<Contato>();
	}
	
	public void addContato(Contato c) {
		this.contatos.add(c);
	}
	
	public Contato getContato(Contato c) {
		for (Contato contato : contatos) {
			if(contato==c)
				return contato;
		}
		return null;
	}
	
	public String listarContatos() {
		String lista = "";
		for (Contato contato : contatos) {
			lista += contato.getDados()+"\n\n";
		}
		return lista;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public ArrayList<Contato> getContatos() {
		return contatos;
	}
}
