package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import controller.Celula;
import controller.Partida;
import controller.Robo;
import view.eventos.ProximaJogada;
import view.eventos.SairDoJogo;
import view.eventos.Selecionar;
import view.eventos.Verificar;
import controller.Icon;

public class PainelMenu extends Painel {

	Dimension dimension = new Dimension(290, 50);
	Dimension dRobo = new Dimension(96, 70);
	Color corBotao = new Color(134, 193, 239);
	private Partida partida;
	private ArrayList<BotaoCelula> botoesCelula;
	private Robo roboSelecionado;
	private Painel painelPontuacao;
	private Painel painelTotal;
	private Painel painelRobosPontuacao;
	private JLabel labelPontuacao;
	private int pontuacao;
	private int alunosSalvos;
	private int bugsEncontrados;
	private boolean verificado;

	public PainelMenu(Color color, JanelaPrincipal janela, Partida partida) {
		super(color, janela);
		setInicial(partida);
		configurarPainelPontuacao(color);
		Painel painelRobos = configurarPainelRobos(color);
		Painel painelBotoes = configurarPainelBotoes(color);
		add(painelPontuacao);
		add(painelRobos);
		add(painelBotoes);
	}

	public void setInicial(Partida partida) {
		setPartida(partida);
		setBotoesCelula(new ArrayList<BotaoCelula>());
		partida.setRobos(getJanela().getPainelTabuleiro().getPlano().getRobos());
		setPontuacao(0);
		setAlunosSalvos(0);
		setBugsEncontrados(0);
		setPreferredSize(new Dimension(300, 700));
	}

	public void configurarPainelPontuacao(Color color) {
		painelPontuacao = new Painel(color, getJanela());
		painelPontuacao.setLayout(new GridLayout(6, 1));
		painelTotal = getPainelTotal();
		labelPontuacao = getLabelPontuacao();
		painelPontuacao.add(labelPontuacao);
		painelPontuacao.add(new JLabel());
		painelPontuacao.add(painelTotal);
		painelPontuacao.add(new JLabel());
		setPainelRobosPontuacao(getPainelRobosPontuacao());
		painelPontuacao.add(painelRobosPontuacao);
	}

	public Painel configurarPainelRobos(Color color) {
		Painel painelRobos = new Painel(color, getJanela());
		ArrayList<Celula> celulas = getJanela().getPainelTabuleiro().getPlano().getListaCelulas();
		painelRobos.setLayout(new GridLayout(1, 3));
		for (Robo robo : partida.getRobos()) {
			Celula celula = new Celula(robo);
			celulas.add(celula);
			BotaoCelula botaoCelula = new BotaoCelula(Color.cyan, celula, new Selecionar(getJanela()));
			botaoCelula.setPreferredSize(dRobo);
			botoesCelula.add(botaoCelula);
			painelRobos.add(botaoCelula);
		}
		return painelRobos;
	}

	public Painel configurarPainelBotoes(Color color) {
		Painel painelBotoes = new Painel(color, getJanela());
		painelBotoes.setLayout(new GridLayout(3, 1));
		Botao botaoVerificar = new Botao("Verificar", corBotao, new Verificar(getJanela()));
		botaoVerificar.setPreferredSize(dimension);
		Botao botaoProximaJogada = new Botao("Proxima Jogada", corBotao, new ProximaJogada(getJanela()));
		botaoProximaJogada.setPreferredSize(dimension);
		Botao botaoSairDoJogo = new Botao("Sair do Jogo", corBotao, new SairDoJogo(getJanela()));
		botaoSairDoJogo.setPreferredSize(dimension);
		painelBotoes.add(botaoVerificar);
		painelBotoes.add(botaoProximaJogada);
		painelBotoes.add(botaoSairDoJogo);
		return painelBotoes;
	}

	public boolean verificaRobos() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (botaoCelula.getCelula().verificaRobo())
				return false;
		}
		return true;
	}

	public boolean robosEstaoDefault() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (!botaoCelula.getCelula().verificaRobo())
				return false;
		}
		return true;
	}

	public boolean umRoboEstaDefault() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (botaoCelula.getCelula().verificaRobo())
				return true;
		}
		return false;
	}

	public void botoesDefault() {
		for (BotaoCelula botaoCelula : botoesCelula) {
			botaoCelula.setBackground(Color.cyan);
		}
	}

	public void robosDefault() {
		getJanela().getPainelTabuleiro().getPlano().retirarRobos();
		int index = 0;
		for (Robo robo : partida.getRobos()) {
			botoesCelula.get(index++).getCelula().addRobo(robo);
		}
	}

	public void atualizar() {
		atualizarPainelPontuacao();
		for (BotaoCelula botaoCelula : botoesCelula) {
			if (!botaoCelula.getCelula().verificaRobo())
				botaoCelula.setEnabled(false);
			botaoCelula.atualizaIcon();
		}
	}

	public void atualizarPainelPontuacao() {
		setAlunosSalvos();
		setBugsEncontrados();
		setPontuacao();
		painelPontuacao.removeAll();
		painelPontuacao.add(getLabelPontuacao());
		painelPontuacao.add(new JLabel());
		painelPontuacao.add(getPainelTotal());
		painelPontuacao.add(new JLabel());
		painelPontuacao.add(getPainelRobosPontuacao());
	}

	public JLabel getLabelPontuacao() {
		String lPontuacao = "Pontuação: " + getPontuacao();
		return new JLabel(lPontuacao);
	}

	public void setLabelPontuacao(JLabel labelPontuacao) {
		this.labelPontuacao = labelPontuacao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void setPontuacao() {
		this.pontuacao = partida.getPontuacao();
	}

	public ArrayList<BotaoCelula> getBotoesCelula() {
		return botoesCelula;
	}

	public void setBotoesCelula(ArrayList<BotaoCelula> botoesCelula) {
		this.botoesCelula = botoesCelula;
	}

	public boolean verificaRoboSelecionado() {
		if (roboSelecionado != null)
			return true;
		return false;
	}

	public boolean addRoboSelecionado(Robo roboSelecionado) {
		if (roboSelecionado != null) {
			retiraRoboSelecionado();
			setRoboSelecionado(roboSelecionado);
			return true;
		}
		return false;
	}

	public void retiraRoboSelecionado() {
		setRoboSelecionado(null);
	}

	public Robo getRoboSelecionado() {
		return roboSelecionado;
	}

	public void setRoboSelecionado(Robo roboSelecionado) {
		this.roboSelecionado = roboSelecionado;
	}

	public Painel getPainelTotal() {
		Painel painelTotal = new Painel(getBackground(), getJanela());
		painelTotal.setLayout(new GridLayout(1, 5));
		painelTotal.add(new JLabel("Total: "));
		painelTotal.add(new JLabel("", new Icon("src/img/aluno.png").getIcon30(), JLabel.CENTER));
		String alunos = "" + getAlunosSalvos();
		painelTotal.add(new JLabel(alunos));
		painelTotal.add(new JLabel("", new Icon("src/img/bug.png").getIcon30(), JLabel.CENTER));
		String bugs = "" + getBugsEncontrados();
		painelTotal.add(new JLabel(bugs));
		return painelTotal;
	}

	public void setPainelTotal(Painel painelTotal) {
		this.painelTotal = painelTotal;
	}

	public Painel getPainelRobosPontuacao() {
		Painel painelRobosPontuacao = new Painel(getBackground(), getJanela());
		painelRobosPontuacao.setLayout(new GridLayout(1, partida.getRobos().size() * 2));
		for (Robo robo : partida.getRobos()) {
			painelRobosPontuacao.add(new JLabel("", robo.getIcon().getIcon30(), JLabel.CENTER));
			String pontuacao = "" + robo.getPontuacao();
			painelRobosPontuacao.add(new JLabel(pontuacao));
		}
		return painelRobosPontuacao;
	}

	public void setPainelRobosPontuacao(Painel painelRobosPontuacao) {
		this.painelRobosPontuacao = painelRobosPontuacao;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public int getAlunosSalvos() {
		return alunosSalvos;
	}

	public void setAlunosSalvos(int alunosSalvos) {
		this.alunosSalvos = alunosSalvos;
	}

	public void setAlunosSalvos() {
		this.alunosSalvos = partida.getAlunosSalvos();
	}

	public int getBugsEncontrados() {
		return bugsEncontrados;
	}

	public void setBugsEncontrados(int bugsEncontrados) {
		this.bugsEncontrados = bugsEncontrados;
	}

	public void setBugsEncontrados() {
		this.bugsEncontrados = partida.getBugsEncontrados();
	}

	public Painel getPainelPontuacao() {
		return painelPontuacao;
	}

	public void setPainelPontuacao(Painel painelPontuacao) {
		this.painelPontuacao = painelPontuacao;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

}
