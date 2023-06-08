package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaSegunda extends JFrame {

	public JanelaSegunda() {

		this.setSize(800, 600);

		
		JPanel painel1 = new JPanel();
		JPanel painel2 = new JPanel();
		JButton b = new JButton("Rei");
		b.setPreferredSize(new Dimension(10,10));
		painel2.add(b);
		
       painel1.setLayout(new GridLayout(8,8));
//		JTextField caixa = new JTextField(100);

		 for (int i = 0; i < 8; i++) {
			  for (int j = 0; j < 8; j++) {
				 painel1.add(botao());
			}
		}
		
		
		 this.add(painel1, BorderLayout.CENTER);
		 this.add(painel2, BorderLayout.NORTH);
		 this.add(new JButton("2"), BorderLayout.SOUTH);
		 
		 
		 //	    
//		this.add(texto());
//		this.add(botao());
//		this.add(b2);
//		this.add(caixa);

	
		this.setTitle("Minha primeira Janela- Ola mundo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public JButton botao() {
		ImageIcon icon = new ImageIcon("withdraw.png");

		JButton b1 = new JButton("Clique aqui", icon);
		b1.setBackground(Color.CYAN);
		
		return b1;

	}
	public JLabel texto() {
		return  new JLabel("Oi oi");
	}
}
