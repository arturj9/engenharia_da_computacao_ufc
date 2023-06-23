package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import controller.Jogador;
import controller.Partida;
import controller.Robo;

public class LerDados {

	private ArrayList<Partida> partidas;

	public LerDados() {
		setPartidas(new ArrayList<Partida>());
	}

	public void lerDados(String diretorio) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader(diretorio);
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				partidas.add(separarDados(leitura.readLine()));
			}

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

	private Partida separarDados(String linha) {
		String dados[] = linha.split(";");
		int cont = 0;
		Partida partida = new Partida(new Jogador(dados[cont++]), Integer.parseInt(dados[cont++]),
				Integer.parseInt(dados[cont++]), Integer.parseInt(dados[cont++]), Integer.parseInt(dados[cont++]),
				Integer.parseInt(dados[cont++]));
		partida.setRobos(definirRobos(dados, cont));
		return partida;
	}

	public ArrayList<Robo> definirRobos(String[] dados, int cont) {
		String[] nomes = { "Andador", "Cavalo", "Rei" };
		ArrayList<Robo> robos = new ArrayList<Robo>();
		for (int i = 0; i < nomes.length; i++) {
			Robo robo = new Robo(nomes[i], Integer.parseInt(dados[cont++]));
			robos.add(robo);
		}
		return robos;
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

}
