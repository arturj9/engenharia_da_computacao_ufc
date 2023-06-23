package view;

public class Jogo {

	private JanelaPrincipal janela;

	public void iniciar() {
		this.setJanela(new JanelaPrincipal());
	}

	public JanelaPrincipal getJanela() {
		return janela;
	}

	public void setJanela(JanelaPrincipal janela) {
		this.janela = janela;
	}
}
