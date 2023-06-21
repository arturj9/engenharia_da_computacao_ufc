package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ListaAlunos;
import controller.Aluno;

public class PainelCadastrar extends Painel {

	private JTextField nome;
	private JTextField cpf;
	private JTextField matricula;
	private JTextField vertente;

	public PainelCadastrar(Color color, Janela janela) {
		super(color, janela);

		Dimension dimension = new Dimension(300, 30);

		this.setLayout(new GridLayout(11, 2));

		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(new JLabel("Nome:"));
		nome = new JTextField();
		nome.setPreferredSize(dimension);
		this.add(nome);

		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(new JLabel("CPF:"));
		cpf = new JTextField();
		cpf.setPreferredSize(dimension);
		this.add(cpf);

		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(new JLabel("Matricula:"));
		matricula = new JTextField();
		matricula.setPreferredSize(dimension);
		this.add(matricula);

		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(new JLabel("Vertente:"));
		vertente = new JTextField();
		vertente.setPreferredSize(dimension);
		this.add(vertente);

		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(new JLabel(""));
		Botao botao = new Botao("Enviar", new Color(102, 0, 204));
		botao.setForeground(Color.WHITE);
		botao.setPreferredSize(dimension);
		botao.addActionListener(new salvarDados());
		this.add(botao);
	}

	private class salvarDados implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (nome.getText().equals("") || cpf.getText().equals("") || matricula.getText().equals("")
					|| vertente.getText().equals("")) {
				JOptionPane.showMessageDialog(getJanela(), "Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
			} else {
				ListaAlunos alunos = new ListaAlunos();

				try {
					alunos.addAluno(new Aluno(nome.getText(), cpf.getText(), matricula.getText(), vertente.getText()));
					JOptionPane.showMessageDialog(getJanela(), "Aluno cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(getJanela(), "Erro ao tentar cadastrar", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

				nome.setText("");
				cpf.setText("");
				matricula.setText("");
				vertente.setText("");
			}

		}
	}

	public JTextField getNome() {
		return nome;
	}

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public JTextField getCpf() {
		return cpf;
	}

	public void setCpf(JTextField cpf) {
		this.cpf = cpf;
	}

	public JTextField getMatricula() {
		return matricula;
	}

	public void setMatricula(JTextField matricula) {
		this.matricula = matricula;
	}

	public JTextField getVertente() {
		return vertente;
	}

	public void setVertente(JTextField vertente) {
		this.vertente = vertente;
	}
	
	

}
