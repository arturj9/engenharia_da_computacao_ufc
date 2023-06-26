package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.Partida;

public class JanelaPrincipal extends Janela {

	private PainelInicial painelInicial;
	private PainelTabuleiro painelTabuleiro;
	private PainelMenu painelMenu;

	public JanelaPrincipal() {
		super("O Regaste dos Alunos na Ilha de Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configurarPaineis();
		setVisible(true);
	}

	public void paineisVisiveis() {
		getPainelTabuleiro().visivel();
		getPainelMenu().visivel();
		painelInicial.nomeEstatico();
	}

	public void configurarPaineis() {
		setPainelInicial(new PainelInicial(new Color(200, 236, 249), this));
		add(painelInicial, BorderLayout.NORTH);
		setPainelTabuleiro(new PainelTabuleiro(new Color(200, 236, 249), this));
		painelTabuleiro.naoVisivel();
		add(painelTabuleiro, BorderLayout.CENTER);
		setPainelMenu(
				new PainelMenu(new Color(200, 236, 249), this, new Partida(painelTabuleiro.getPlano().getRobos())));
		painelMenu.naoVisivel();
		add(painelMenu, BorderLayout.EAST);
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
