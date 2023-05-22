package robo;

import java.util.ArrayList;

public class Plano {

	public ArrayList<Celula> listaCelulas;

	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas = new ArrayList<Celula>();

			int contador = 1;
			for (int i = 1; i <= tamanhoX; i++) {
				for (int j = 1; j <= tamanhoY; j++) {
					Celula celula = new Celula(contador, i, j);
					listaCelulas.add(celula);
					contador++;
				}
			}
	}

	public void verificarSeTemRobo() {
		for (int i = 0; i < listaCelulas.size(); i++) {
			Celula aux = listaCelulas.get(i);
			if (listaCelulas.get(i).robo != null) {
				System.out.println("tem robo" + aux.robo.nome + "  - x: " + aux.posicaoX + "  - y: " + aux.posicaoY);
			}
		}
	}


	public Celula retornarCelula(int x, int y) {

		for (int i = 0; i < listaCelulas.size(); i++) {
			if (listaCelulas.get(i).posicaoX == x && listaCelulas.get(i).posicaoY == y) {
				return listaCelulas.get(i);
			}
		}
		return null;
	}

	public void retornarCelulas() {
		for (int i = 0; i < listaCelulas.size(); i++) {
			System.out.println(listaCelulas.get(i).imprimir());
		}
	}

}
