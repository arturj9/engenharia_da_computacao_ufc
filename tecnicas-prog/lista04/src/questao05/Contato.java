package questao05;

public class Contato {
//	5) Um contato é constituído de código, nome da pessoa, endereço, e-mail,
//	telefone e observação.
//	a. Crie 4 construtores e atribua o valores por meio dos construtores. Os
//	construtores devem receber os seguintes parâmetros:
//
//	I. Código.
//	II. Código e nome.
//	III. Código, nome e e-mail.
//	IV. Telefone.
//	b. O atributo e-mail não poderá ser modificado fora da classe contato, mas
//	poderá ser acessado por outras classes.
//	c. Faça um método para imprimir o código, nome, endereço, e-mail, telefone
//	e observação dos contatos cadastrados.
//	d. Faça um validador do código do contato. Um código válido é maior
//	igual a 1000 e menor igual a 9999. Não permita que seja cadastrado
//	um código inválido para nenhum contato.
//	e. Faça um validador para o telefone. O telefone sempre deverá ter 8 dígitos.
//	Não permita que seja cadastrado um telefone inválido para nenhum contato.
//	f. Crie um método que possa duplicar um contato. Desta forma, um novo
//	contato terá os mesmos dados do contato que for requerido a duplicação.
//	g. Faça um método para verificar se o contato está totalmente preenchido.
//	Ou seja, tenha valores diferentes do padrão para: código, nome, endereço, e-mail,
//	telefone e observação.
//	h. Crie uma classe agenda que é composta de uma lista de contatos, nome
//	da agenda e uma descrição.
//	i. Crie uma classe cliente que poderá usar uma agenda.
//	j. Faça uma classe main para testar seu sistema criado.

	private int codigo;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String observacao;

	public Contato(int codigo) {
		this.codigo = codigo;
	}

	public Contato(int codigo, String nome, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}
	
	public Contato(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Contato(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public String getContato() {
		return "Código: "+getCodigo()+"\nNome: "+getNome()+"\nEndereço: "+getEndereco()+"\nE-mail: "+getEmail()+"\nTelefone: "+getTelefone()+"\nObservação: "+getObservacao();
	}
	
}
