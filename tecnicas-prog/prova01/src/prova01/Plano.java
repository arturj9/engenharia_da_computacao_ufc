package prova01;

import java.util.ArrayList;
import java.util.Random;

public class Plano {

	private ArrayList<Celula> listaCelulas;

	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}

	public void setListaCelulas(ArrayList<Celula> listaCelulas) {
		this.listaCelulas = listaCelulas;
	}

	private int tamanhoX;
	private int tamanhoY;

	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas = new ArrayList<Celula>();

		int contador = 1;
		for (int i = tamanhoX; i >= 1; i--) {
			for (int j = 1; j <= tamanhoY; j++) {
				Celula celula = new Celula(contador, i, j);
				listaCelulas.add(celula);
				contador++;
			}
		}

		this.setTamanhoX(tamanhoX);
		this.setTamanhoY(tamanhoY);
	}

	public Celula retornarCelula(int x, int y) {
		for (Celula celula : listaCelulas) {
			if (celula.getPosicaoX() == x && celula.getPosicaoY() == y)
				return celula;
		}
		return null;
	}

	public Celula retornarCelulaDeRobo(Robo robo) {
		for (Celula celula : listaCelulas) {
			if (celula.getPosicaoX() == robo.getPosicaox() && celula.getPosicaoY() == robo.getPosicaoy())
				return celula;
		}
		return null;
	}

	public String show() {
		String texto = "";
		for (Celula celula : listaCelulas) {
			texto += celula.getSimbolo();
		}
		return texto;
	}

	public Celula sortearCelula() {
		int min = 1;
		int maxX = this.getTamanhoX();
		int maxY = this.getTamanhoY();
		Random random = new Random();
		Celula celula = this.retornarCelula(random.nextInt((maxX - min + 1)) + min,
				random.nextInt((maxY - min + 1)) + min);
		if (verificaCelula(celula))
			return celula;
		return sortearCelula();
	}

	public boolean verificaCelula(Celula celula) {
		if(celula.verificaListaRobos()||celula.verificaAluno()||celula.verificaBug())
			return false;
		return true;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public void setTamanhoX(int tamanhoX) {
		this.tamanhoX = tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}

}
