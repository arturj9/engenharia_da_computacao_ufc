package model;

import java.io.FileWriter;
import java.io.IOException;

import view.excecoes.EscreverDadosException;

public class Escrever {

	public void escerverDados(String file, String mensagem) throws EscreverDadosException {

		FileWriter arquivo = null;

		try {

			arquivo = new FileWriter(file);
			arquivo.write(mensagem);

		} catch (Exception e) {
			System.out.println("Erro ao escrever arquivo: " + e.getMessage());
			throw new EscreverDadosException("Não foi possível escrever arquivo");
		} finally {
			if (arquivo != null) {
				try {
					arquivo.close();
				} catch (IOException d) {
					d.printStackTrace();
				}
			}
		}
	}

}
