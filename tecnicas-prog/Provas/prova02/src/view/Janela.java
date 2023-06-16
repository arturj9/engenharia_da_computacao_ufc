package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Janela extends JFrame{
	private PainelInicial painelInicial;
	private PainelTabuleiro painelTabuleiro;
	private PainelMenu painelMenu;
	
	public Janela() {
		this.setSize(1200, 700);
		this.setTitle("O Regaste dos Alunos na Ilha de Java");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(100, 40);
		
		this.configurarPaineis();
		
		this.setVisible(true);
	}
	
	public void configurarPaineis() {
		this.setPainelInicial(new PainelInicial(new Color(200,236,249), this));
		this.add(painelInicial,BorderLayout.NORTH);
		this.setPainelTabuleiro(new PainelTabuleiro(new Color(200,236,249), this));
		painelTabuleiro.naoVisivel();
		this.add(painelTabuleiro,BorderLayout.CENTER);
		this.setPainelMenu(new PainelMenu(new Color(200,236,249), this));
		painelMenu.naoVisivel();
		this.add(painelMenu,BorderLayout.EAST);
	}

	public PainelInicial getPainelInicial() {
		return painelInicial;
	}

	public void setPainelInicial(PainelInicial painelInicial) {
		this.painelInicial = painelInicial;
	}

	public PainelTabuleiro getPainelTabuleiro() {
		return painelTabuleiro;
	}

	public void setPainelTabuleiro(PainelTabuleiro painelTabuleiro) {
		this.painelTabuleiro = painelTabuleiro;
	}

	public PainelMenu getPainelMenu() {
		return painelMenu;
	}

	public void setPainelMenu(PainelMenu painelMenu) {
		this.painelMenu = painelMenu;
	}
	
}
