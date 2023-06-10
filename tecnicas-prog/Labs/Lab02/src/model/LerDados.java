package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controller.Aluno;

public class LerDados {
	
	 public ArrayList<Aluno> lista;
	 
	 public LerDados() {
	    lista= new ArrayList<Aluno>();
	}

	public void lerDados(String diretorio) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader(diretorio);
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				lista.add(separarDadosDoAluno(leitura.readLine()));
			}

		} catch (Exception e) {
		}finally {
			if (arquivo != null) {
                try {
                    arquivo.close();
                } catch (IOException d) {
                    d.printStackTrace();
                }
            }
		}
	}

	private Aluno separarDadosDoAluno(String linha) {
		String dados[] = linha.split(";");
		Aluno aluno = new Aluno(dados[0], dados[1], dados[2], dados[3]);
		return aluno;
	}
}
