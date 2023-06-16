package controller;

import java.util.ArrayList;
import java.util.Random;

public class Plano {

	private ArrayList<Celula> listaCelulas;
	private ArrayList<Aluno> alunos;
	private ArrayList<Bug> bugs;
	private int tamanhoX;
	private int tamanhoY;


	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas = new ArrayList<Celula>();
		alunos = new ArrayList<Aluno>();
		bugs = new ArrayList<Bug>();
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
		povoar();
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
		if(celula.verificaRobo()||celula.verificaAluno()||celula.verificaBug())
			return false;
		return true;
	}
	
	public void povoar() {
		iniciarRobos();
		iniciarAlunos(8);
		iniciarBugs(12);
	}

	public void iniciarRobos() {
//		int contador = 1;
//		int xInicial = 1;
//		int yInicial = 1;
//		this.robos.add(new Andador(contador++, "Andador", xInicial, yInicial, plano, "A"));
//		this.robos.add(new Peao(contador++, "Peao", xInicial, yInicial, plano, "P"));
//		this.robos.add(new Torre(contador++, "Torre", xInicial, yInicial, plano, "T"));
//		this.robos.add(new Bispo(contador++, "Bispo", xInicial, yInicial, plano, "B"));
//		this.robos.add(new Cavalo(contador++, "Cavalo", xInicial, yInicial, plano, "C"));
//		this.robos.add(new Rei(contador++, "Rei", xInicial, yInicial, plano, "R"));
//		this.robos.add(new Rainha(contador++, "Rainha", xInicial, yInicial, plano, "r"));
	}

	public void iniciarAlunos(int quant) {
		Celula celula;
		Aluno aluno;
		
		for (int i = 1; i <= quant; i++) {
			celula = this.sortearCelula();
			aluno = new Aluno("Aluno " + i, celula.getPosicaoX(), celula.getPosicaoY());
			celula.addAluno(aluno);
			alunos.add(aluno);
		}
	}

	public void iniciarBugs(int quant) {
		Celula celula;
		Bug bug;
		for (int i = 1; i <= quant; i++) {
			celula = this.sortearCelula();
			bug = new Bug("Bug " + i, celula.getPosicaoX(), celula.getPosicaoY());
			celula.addBug(bug);
			bugs.add(bug);
		}
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
	
	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}

	public void setListaCelulas(ArrayList<Celula> listaCelulas) {
		this.listaCelulas = listaCelulas;
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}

}
