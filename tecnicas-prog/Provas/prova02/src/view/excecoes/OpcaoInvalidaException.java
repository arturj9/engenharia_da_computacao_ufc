package view.excecoes;

public class OpcaoInvalidaException extends Exception {

	public OpcaoInvalidaException(String msg) {
		super("Opção inválida: " + msg);
	}

}
