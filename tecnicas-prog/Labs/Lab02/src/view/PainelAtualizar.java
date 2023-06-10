package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Aluno;
import controller.ListaAlunos;

public class PainelAtualizar extends Painel {

	JTextField matricula;
	JTextField vertente;

	public PainelAtualizar(Color color, Janela janela) {
		super(color, janela);

		Dimension dimension = new Dimension(300, 30);

		this.setLayout(new GridLayout(6, 2));

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
			if (matricula.getText().equals("") || vertente.getText().equals("")) {
				JOptionPane.showMessageDialog(janela, "Preencha todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
			} else {
				ListaAlunos alunos = new ListaAlunos();

				try {
					if (alunos.atualizarVertente(matricula.getText(), vertente.getText())) {
						JOptionPane.showMessageDialog(janela, "Vertente atualizada com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(janela, "Matrícula não encontrada", "Aviso",
								JOptionPane.WARNING_MESSAGE);
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(janela, "Erro ao tentar atualizar vertente", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

				matricula.setText("");
				vertente.setText("");
			}

		}
	}

}
