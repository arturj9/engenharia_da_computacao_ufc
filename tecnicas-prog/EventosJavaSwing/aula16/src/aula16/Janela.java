package aula16;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame implements ActionListener {

	public JLabel resposta;
	public JPanel painel1;

	public Janela() {
		resposta = new JLabel();

		this.setSize(600, 600);
		this.setTitle("Bem vindo ao eventos no Java Swing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(1, 2));

		painel1 = criarPainel(Color.gray);
		painel1.add(resposta);

		this.add(painel1);

		JPanel painel2 = criarPainel(Color.BLUE);
		painel2.add(criarBotao(Color.red, "Botao vermelho"));
		painel2.add(criarBotao(Color.green, "Botao verde"));

		this.add(painel2);

		this.setVisible(true);
	}

	public JPanel criarPainel(Color c) {
		JPanel p = new JPanel();
		p.setBackground(c);
		return p;
	}

	public JButton criarBotao(Color c, String msg) {
		JButton b = new JButton(msg);
		b.addActionListener(this);
		b.setBackground(c);

		return b;
	}

	public void actionPerformed(ActionEvent e) {

		JButton b = (JButton) e.getSource();
		resposta.setText(b.getText());
		painel1.setBackground(b.getBackground());

	}

}
