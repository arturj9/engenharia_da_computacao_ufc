package view;

import java.awt.Color;

import javax.swing.JScrollPane;

import controller.Aluno;
import controller.ListaAlunos;

public class PainelListar extends Painel {

	private ListaAlunos alunos;
	private JScrollPane painelRolagem;

	public PainelListar(Color color, Janela janela) {
		super(color, janela);

		atualizarDados();

		this.add(painelRolagem);

	}

	public void atualizarDados() {
		alunos = new ListaAlunos();

		String[][] dados = new String[alunos.quantidadeAlunos()][4];
		int cont = 0;
		for (Aluno aluno : alunos.getListaAlunos()) {
			dados[cont][0] = aluno.getNome();
			dados[cont][1] = aluno.getCpf();
			dados[cont][2] = aluno.getMatricula();
			dados[cont++][3] = aluno.getVertente();
		}

		String[] colunas = { "Nome", "CPF", "Matrícula", "Vertente" };

		Tabela tabela = new Tabela(dados, colunas);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.setRowHeight(30);
		painelRolagem = new JScrollPane(tabela);
	}

	public void visivel() {
		this.setVisible(true);
	}

	public ListaAlunos getAlunos() {
		return alunos;
	}

	public void setAlunos(ListaAlunos alunos) {
		this.alunos = alunos;
	}

	public JScrollPane getPainelRolagem() {
		return painelRolagem;
	}

	public void setPainelRolagem(JScrollPane painelRolagem) {
		this.painelRolagem = painelRolagem;
	}
	
	

}
