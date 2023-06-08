package persistencia;

import java.io.FileWriter;

public class Escrever {

	public void escerverDados(String file, String mensagem) {

		try {

			FileWriter arquivo = new FileWriter(file);
			arquivo.write(mensagem);
			arquivo.close();

		} catch (Exception e) {
		}
	}
}
