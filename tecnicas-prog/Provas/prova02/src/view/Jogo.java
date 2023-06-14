package view;

public class Jogo {
	private Janela janela;
	private PainelInicial painelInicial;
	private PainelTabuleiro painelTabuleiro;
	private PainelMenu painelMenu;
	
	public Jogo() {
		this.setJanela(new Janela());
		this.setPainelInicial(janela.getPainelInicial());
		
	}

	public Janela getJanela() {
		return janela;
	}

	public void setJanela(Janela janela) {
		this.janela = janela;
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
