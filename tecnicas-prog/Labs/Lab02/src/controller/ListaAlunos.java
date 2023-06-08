package controller;

import java.util.ArrayList;

import model.Escrever;
import model.LerDados;

public class ListaAlunos {
	private ArrayList<Aluno> listaAlunos;

	public ListaAlunos() {
		buscarDados();
	}

	public void addAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}

	public void deletarAluno(String matricula) {
		for (Aluno aluno : listaAlunos) {
			if (aluno.getMatricula().equals(matricula)) {
				listaAlunos.remove(aluno);
				salvar();
				buscarDados();
				return;
			}
		}

	}

	public void atualizarVertente(String matricula, String novaVertente) {
		for (Aluno aluno : listaAlunos) {
			if (aluno.getMatricula().equals(matricula)) {
				aluno.setVertente(novaVertente);
				salvar();
				buscarDados();
				return;
			}
		}

	}

	public int quantidadeAlunos() {
		return listaAlunos.size();
	}

	public String formatarDados() {

		String saida = "";
		for (Aluno aluno : listaAlunos) {
			saida += aluno.getNome() + ";" + aluno.getCpf() + ";" + aluno.getMatricula() + ";" + aluno.getVertente()
					+ " \n";
		}
		return saida;
	}

	public ArrayList<Aluno> getListaAlunos() {
		buscarDados();
		return listaAlunos;
	}

	public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public void salvar() {
		Escrever escrever = new Escrever();
		escrever.escerverDados("dados/alunos.txt", this.formatarDados());
		buscarDados();
	}

	public void buscarDados() {
		LerDados ler = new LerDados();
		ler.lerDados("dados/alunos.txt");
		setListaAlunos(ler.lista);
	}

}
