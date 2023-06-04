package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	public Painel painelBotoes;
	public PainelCadastrar painelCadastrar;
	public PainelListar painelListar;
	public PainelAtualizar painelAtualizar;
	public PainelDeletar painelDeletar;
	
	public Botao botaoCadastrar;
	public Botao botaoListar;
	public Botao botaoAtualizar;
	public Botao botaoDeletar;

	public Janela() {
		this.setSize(700, 700);
		updateTitle("Main");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(320, 40);
		configurarPaineis();
		this.setVisible(true);
	}

	public void configurarPaineis() {
		painelBotoes = new Painel(new Color(224,224,224));
		configurarBotoes(painelBotoes);
		this.add(painelBotoes, BorderLayout.NORTH);
		
		Painel painelConteudo = new Painel(Color.WHITE);
		painelConteudo.setLayout(new FlowLayout());
		
		painelCadastrar = new PainelCadastrar(Color.WHITE);
		painelConteudo.add(painelCadastrar);
		painelCadastrar.naoVisivel();
		
		
		painelListar = new PainelListar(Color.WHITE);
		painelConteudo.add(painelListar);
		painelListar.naoVisivel();
		
		painelAtualizar = new PainelAtualizar(Color.WHITE);
		painelConteudo.add(painelAtualizar);
		painelAtualizar.naoVisivel();
		
		painelDeletar = new PainelDeletar(Color.WHITE);
		painelConteudo.add(painelDeletar);
		painelDeletar.naoVisivel();
		
		this.add(painelConteudo, BorderLayout.CENTER);
	}

	public void configurarBotoes(Painel painel) {
		botaoCadastrar = new Botao("Cadastrar", Color.WHITE);
		botaoCadastrar.addActionListener(new VisibleCadastrar());
		painel.add(botaoCadastrar);
		
		botaoListar = new Botao("Listar", Color.WHITE);
		botaoListar.addActionListener(new VisibleListar());
		painel.add(botaoListar);
		
		botaoAtualizar = new Botao("Atualizar", Color.WHITE);
		botaoAtualizar.addActionListener(new VisibleAtualizar());
		painel.add(botaoAtualizar);
		
		botaoDeletar = new Botao("Deletar", Color.WHITE);
		botaoDeletar.addActionListener(new VisibleDeletar());
		painel.add(botaoDeletar);
	}

	public void updateTitle(String msg) {
		this.setTitle(msg);
	}
	
	public void setTelaDefault() {
		painelCadastrar.naoVisivel();
		painelListar.naoVisivel();
		painelAtualizar.naoVisivel();
		painelDeletar.naoVisivel();
		botaoCadastrar.setBackground(Color.WHITE);
		botaoListar.setBackground(Color.WHITE);
		botaoAtualizar.setBackground(Color.WHITE);
		botaoDeletar.setBackground(Color.WHITE);
		painelBotoes.setBackground(Color.LIGHT_GRAY);
		updateTitle("Main");
	}

	private class VisibleCadastrar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			if (!painelCadastrar.isVisible()) {
				setTelaDefault();
				painelCadastrar.visivel();
				painelListar.naoVisivel();
				painelAtualizar.naoVisivel();
				painelDeletar.naoVisivel();
				painelBotoes.setBackground(Color.WHITE);
				botao.setBackground(new Color(224,224,224));
				updateTitle("Cadastrar");
			}else
				setTelaDefault();
			
		}
	}
	
	private class VisibleListar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			if (!painelListar.isVisible()) {
				setTelaDefault();
				painelCadastrar.naoVisivel();
				painelListar.visivel();
				painelAtualizar.naoVisivel();
				painelDeletar.naoVisivel();
				painelBotoes.setBackground(Color.WHITE);
				botao.setBackground(new Color(224,224,224));
				updateTitle("Listar");
			}else
				setTelaDefault();
			
		}
	}
	
	private class VisibleAtualizar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			if (!painelAtualizar.isVisible()) {
				setTelaDefault();
				painelCadastrar.naoVisivel();
				painelListar.naoVisivel();
				painelAtualizar.visivel();
				painelDeletar.naoVisivel();
				painelBotoes.setBackground(Color.WHITE);
				botao.setBackground(new Color(224,224,224));
				updateTitle("Atualizar");
			}else
				setTelaDefault();
			
		}
	}
	
	private class VisibleDeletar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			if (!painelDeletar.isVisible()) {
				setTelaDefault();
				painelCadastrar.naoVisivel();
				painelListar.naoVisivel();
				painelAtualizar.naoVisivel();
				painelDeletar.visivel();
				painelBotoes.setBackground(Color.WHITE);
				botao.setBackground(new Color(224,224,224));
				updateTitle("Deletar");
			}else
				setTelaDefault();
			
		}
	}
}
