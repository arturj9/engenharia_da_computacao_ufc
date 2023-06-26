package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import controller.FabricaRobos;
import controller.Jogador;
import controller.Partida;
import controller.Plano;
import controller.Robo;
import controller.Robos;

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

		} catch (IOException e) {
			setPartidas(null);
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
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
		FabricaRobos fabrica = new FabricaRobos();
		ArrayList<Robo> robos = new ArrayList<Robo>();
		robos.add(fabrica.criarRobo(Robos.ANDADOR, Integer.parseInt(dados[cont++])));
		robos.add(fabrica.criarRobo(Robos.CAVALO, Integer.parseInt(dados[cont++])));
		robos.add(fabrica.criarRobo(Robos.REI, Integer.parseInt(dados[cont++])));
		return robos;
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

}
