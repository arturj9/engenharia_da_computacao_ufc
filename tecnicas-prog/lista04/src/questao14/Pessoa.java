package questao14;

public class Pessoa {
	private String nome;
	private int idade;
	private int dia;
	private int mes;
	private int ano;
	
	
	public Pessoa(String nome, int dia, int mes, int ano) {
		this.setNome(nome);
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
	}

	public void calculaIdade(int diaAtual, int mesAtual, int anoAtual) {
		idade = anoAtual - ano;
		if(mes<=mesAtual) {
			if(diaAtual<=dia)
				this.setIdade(idade);
			else
				this.setIdade(idade-1);
		}else
			this.setIdade(idade-1);
	}
	
	public String informaIdade() {
		return "Idade: "+this.getIdade();
	}
	
	public String informaNome() {
		return "Nome: "+this.getNome();
	}
	
	public void ajustaDataDeNascimento(int dia, int mes, int ano) {
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		if(dia>0&&dia<=31)
			this.dia = dia;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		if(mes>0&&mes<=12)
			this.mes = mes;
	}

}
