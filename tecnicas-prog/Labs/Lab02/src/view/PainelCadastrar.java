package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListaAlunos;
import controller.Aluno;

public class PainelCadastrar extends Painel {

	public JTextField nome;
	public JTextField cpf;
	public JTextField matricula;
	public JTextField vertente;

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
				JOptionPane.showMessageDialog(janela, "Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
			} else {
				ListaAlunos alunos = new ListaAlunos();

				try {
					alunos.addAluno(new Aluno(nome.getText(), cpf.getText(), matricula.getText(), vertente.getText()));
					JOptionPane.showMessageDialog(janela, "Aluno cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(janela, "Erro ao tentar cadastrar", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

				nome.setText("");
				cpf.setText("");
				matricula.setText("");
				vertente.setText("");
			}

		}
	}

}
