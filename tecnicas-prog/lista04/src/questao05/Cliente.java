package questao05;

public class Cliente {
	private String nome;
	public Agenda agenda;

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	
}
