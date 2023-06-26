package controller;

import java.util.ArrayList;
import java.util.Random;

public class Plano {

	private ArrayList<Celula> listaCelulas;
	private ArrayList<Aluno> alunos;
	private ArrayList<Bug> bugs;
	private ArrayList<Robo> robos;
	private int tamanhoX;
	private int tamanhoY;

	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas = new ArrayList<Celula>();
		alunos = new ArrayList<Aluno>();
		bugs = new ArrayList<Bug>();
		robos = new ArrayList<Robo>();
		setTamanhoX(tamanhoX);
		setTamanhoY(tamanhoY);
		definirCelulas();
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
			if (celula.getRobo() == robo)
				return celula;
		}
		return null;
	}

	public void definirCelulas() {
		int contador = 1;
		for (int i = tamanhoX; i >= 1; i--) {
			for (int j = 1; j <= tamanhoY; j++) {
				Celula celula = new Celula(contador, i, j);
				listaCelulas.add(celula);
				contador++;
			}
		}
	}

	public Celula sortearCelula() {
		int min = 1;
		int maxX = this.getTamanhoX();
		int maxY = this.getTamanhoY();
		Random random = new Random();
		Celula celula = this.retornarCelula(random.nextInt((maxX - min + 1)) + min,
				random.nextInt((maxY - min + 1)) + min);
		if (celula.verifica())
			return celula;
		return sortearCelula();
	}

	public void povoar() {
		iniciarRobos();
		iniciarAlunos(21);
		iniciarBugs(21);
	}

	public void iniciarRobos() {
		FabricaRobos fabrica = new FabricaRobos(this);
		robos.add(fabrica.criarRobo(Robos.ANDADOR));
		robos.add(fabrica.criarRobo(Robos.CAVALO));
		robos.add(fabrica.criarRobo(Robos.REI));
	}

	public void iniciarAlunos(int quant) {
		for (int i = 1; i <= quant; i++) {
			Celula celula = this.sortearCelula();
			Aluno aluno = new Aluno();
			celula.addAluno(aluno);
			alunos.add(aluno);
		}
	}

	public void iniciarBugs(int quant) {
		for (int i = 1; i <= quant; i++) {
			Celula celula = this.sortearCelula();
			Bug bug = new Bug();
			celula.addBug(bug);
			bugs.add(bug);
		}
	}

	public void retirarRobos() {
		for (Robo robo : robos) {
			retornarCelulaDeRobo(robo).retirarRobo();
		}
	}

	public int getQuantCelula() {
		return tamanhoX * tamanhoY;
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

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void setRobos(ArrayList<Robo> robos) {
		this.robos = robos;
	}

}
