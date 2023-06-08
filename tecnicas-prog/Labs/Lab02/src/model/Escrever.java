package model;

import java.io.FileWriter;
import java.io.IOException;

public class Escrever {

	public void escerverDados(String file, String mensagem) {
		
		FileWriter arquivo = null;

		try {

			arquivo = new FileWriter(file);
			arquivo.write(mensagem);

		} catch (Exception e) {
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
