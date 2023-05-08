package questao05;

public class Contato {
	private int codigo;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String observacao;

	public Contato(int codigo) {
		this.setCodigo(codigo);
	}

	public Contato(int codigo, String nome, String email) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.email = email;
	}
	
	public Contato(int codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	
	public Contato(String telefone) {
		this.setTelefone(telefone);
	}

	
	public String getDados() {
		return "Código: "+getCodigo()+"\nNome: "+getNome()+"\nEndereço: "+getEndereco()+"\nE-mail: "+getEmail()+"\nTelefone: "+getTelefone()+"\nObservação: "+getObservacao();
	}
	
	public Contato duplicar() {
		Contato c = new Contato(this.getCodigo(), this.getNome(), this.getEmail());
		c.setEndereco(this.getEndereco());
		c.setTelefone(this.getTelefone());
		c.setObservacao(this.getObservacao());
		return c;
	}
	
	public boolean verificarPreenchidoTotal() {
		if(this.getCodigo()==0||this.getNome()==null||this.getEndereco()==null
				||this.getEmail()==null||this.getTelefone()==null||this.getObservacao()==null)
			return false;
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo >= 1000 && codigo <= 9999)
			this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone == null)
			this.telefone = null;
		
		else if (telefone.length()==8)
			this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
