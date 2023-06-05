package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastrar extends Painel {
	
	JTextField nome;
	JTextField cpf;
	JTextField matricula;
	JTextField vertente;

	public PainelCadastrar(Color color) {
		super(color);
		
		Dimension dimension = new Dimension(300, 30);
		
		this.setLayout(new GridLayout(11,2));
		
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
		Botao botao = new Botao("Enviar", new Color(102,0,204));
		botao.setForeground(Color.WHITE);
		botao.setPreferredSize(dimension);
		this.add(botao);
	}

}
