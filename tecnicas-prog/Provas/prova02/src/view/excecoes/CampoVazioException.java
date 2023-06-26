package view.excecoes;

public class CampoVazioException extends Exception {

	public CampoVazioException(String msg) {
		super("Campo vazio: " + msg);
	}

}
