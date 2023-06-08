package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.Cliente;

public class LerDados {
	
	 public ArrayList<Cliente> lista;
	 
	 public LerDados() {
	    lista= new ArrayList<Cliente>();
	}

	public void lerDados(String diretorio) {
		try {
			FileReader arquivo = new FileReader(diretorio);
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				lista.add(separarDadosDoCliente(leitura.readLine()));
			}

		} catch (Exception e) {
		}
	}

	private Cliente separarDadosDoCliente(String linha) {
		String dados[] = linha.split(";");
		Cliente c = new Cliente(dados[1], Integer.parseInt(dados[0]), dados[2]);
		return c;
	}
}
