package aula16;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaEventoMouse extends JFrame implements MouseListener {

	public JLabel resposta;
	public JPanel painel1;

	public JanelaEventoMouse() {
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
//		b.addActionListener(this);
		b.addMouseListener(this);
		b.setBackground(c);

		return b;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("botao foi clicado");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouse em cima do botao");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouse sair do botao");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse ");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("soltar");		
	}

	
//	public void actionPerformed(ActionEvent e) {
//
//		JButton b = (JButton) e.getSource();
//		resposta.setText(b.getText());
//		painel1.setBackground(b.getBackground());
//
//	}

}
