
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame {

	public JLabel resposta;
	public JPanel painel1;
	public JTextField nome;

	public Janela() {
		resposta = new JLabel();

		this.setSize(600, 600);
		this.setTitle("Bem vindo ao eventos no Java Swing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));

		painel1 = criarPainel(Color.gray);
		painel1.add(resposta);
		this.add(painel1);

		JPanel painel2 = criarPainel(Color.LIGHT_GRAY);
		JButton b1 = criarBotao(Color.red, "Botao vermelho");
		b1.addActionListener(new TrocarCor());

		painel2.add(b1);

		JButton b2 = criarBotao(Color.green, "Botao verde");
		b2.addActionListener(new ApresentarMensagem(this));
		
		painel2.add(b2);
		JButton b3 =criarBotao(Color.cyan, "Botao");
		b3.addActionListener(new TrocarCor());
		painel2.add(b3);

		this.add(painel2);
		this.setVisible(true);
	}

	public JPanel criarPainel(Color c) {
		JPanel p = new JPanel();
		p.setBackground(c);
		return p;
	}

	public JButton criarBotao(Color c, String msg) {
		ImageIcon img= new ImageIcon("withdraw.png");
		JButton b = new JButton(msg, img);
		b.setBackground(c);

		return b;
	}

	private class TrocarCor implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			resposta.setText(b.getText());
			painel1.setBackground(b.getBackground());
		}
	}

	private class ApresentarMensagem implements ActionListener {

		public JFrame janela;

		public ApresentarMensagem(JFrame frame) {
			this.janela = frame;
		}

		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(janela, "Registro salva com sucesso para a Letra: ", " Salvando operação...",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}
}
