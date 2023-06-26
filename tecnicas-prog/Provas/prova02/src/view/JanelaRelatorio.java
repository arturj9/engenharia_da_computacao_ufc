package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.Partida;
import controller.Partidas;
import view.excecoes.LerDadosException;

public class JanelaRelatorio extends Janela {

	private JScrollPane painelRolagem;

	public JanelaRelatorio() throws LerDadosException {
		super("Relatório do jogo");
		setPainelRolagem(new JScrollPane(configurarTabela()));
		add(painelRolagem);
		setVisible(true);
	}

	public void fecharPrograma() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Tabela configurarTabela() throws LerDadosException {
		Partidas partidas = new Partidas();
		String[][] dados = new String[partidas.quantidadePartidas()][9];
		dados = configurarDados(dados, partidas);
		String[] colunas = { "Nome", "Quant. Rodadas", "Células Vazias", "Pontuação", "Alunos resgatados",
				"Bugs encontrados", "Andador", "Cavalo", "Rei" };
		Tabela tabela = new Tabela(dados, colunas);
		tabela.setRowHeight(30);
		return tabela;
	}

	public String[][] configurarDados(String[][] dados, Partidas partidas) {
		int cont = 0;
		for (Partida partida : partidas.getPartidas()) {
			dados[cont][0] = partida.getJogador().getNome();
			dados[cont][1] = "" + partida.getQuantJogadas();
			dados[cont][2] = "" + partida.getCelulaVazias();
			dados[cont][3] = "" + partida.getPontuacao();
			dados[cont][4] = "" + partida.getAlunosSalvos();
			dados[cont][5] = "" + partida.getBugsEncontrados();
			dados[cont][6] = "" + partida.getRobos().get(0).getPontuacao();
			dados[cont][7] = "" + partida.getRobos().get(1).getPontuacao();
			dados[cont++][8] = "" + partida.getRobos().get(2).getPontuacao();
		}
		return dados;
	}

	public JScrollPane getPainelRolagem() {
		return painelRolagem;
	}

	public void setPainelRolagem(JScrollPane painelRolagem) {
		this.painelRolagem = painelRolagem;
	}

}
