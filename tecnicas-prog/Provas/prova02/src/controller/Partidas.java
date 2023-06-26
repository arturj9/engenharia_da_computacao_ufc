package controller;

import java.util.ArrayList;

import model.Escrever;
import model.LerDados;
import view.excecoes.EscreverDadosException;
import view.excecoes.LerDadosException;

public class Partidas {

	private ArrayList<Partida> partidas;
	private String caminho;

	public Partidas() throws LerDadosException {
		setCaminho("dados/Partidas.txt");
		buscarDados();
	}

	public void addPartida(Partida partida) throws LerDadosException, EscreverDadosException {
		partidas.add(partida);
		salvar();
	}

	public int quantidadePartidas() {
		return partidas.size();
	}

	public String formatarDados() {
		String saida = "";
		for (Partida partida : partidas) {
			saida += partida.getJogador().getNome() + ";" + partida.getQuantJogadas() + ";" + partida.getCelulaVazias()
					+ ";" + partida.getPontuacao() + ";" + partida.getAlunosSalvos() + ";"
					+ partida.getBugsEncontrados() + ";";
			for (Robo robo : partida.getRobos()) {
				saida += robo.getPontuacao() + ";";
			}
			saida += "\n";
		}
		return saida;
	}

	public void salvar() throws LerDadosException, EscreverDadosException {
		Escrever escrever = new Escrever();
		escrever.escerverDados(caminho, this.formatarDados());
		buscarDados();
	}

	public void buscarDados() throws LerDadosException {
		LerDados ler = new LerDados();
		ler.lerDados(caminho);
		if (ler.getPartidas() == null)
			throw new LerDadosException("Não foi possível ler dados de arquivo");
		setPartidas(ler.getPartidas());
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
