package view.excecoes;

public class LerDadosException extends Exception {

	public LerDadosException(String msg) {
		super("Erro ao buscar dados:" + msg);
	}

}
