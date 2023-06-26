package view.excecoes;

public class EscreverDadosException extends Exception {

	public EscreverDadosException(String msg) {
		super("Erro ao escrever dados: " + msg);
	}

}
