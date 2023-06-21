package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Janela extends JFrame {

	private Painel painelBotoes;
	private PainelCadastrar painelCadastrar;
	private PainelListar painelListar;
	private PainelAtualizar painelAtualizar;
	private PainelDeletar painelDeletar;
	private Painel painelConteudo;

	private Botao botaoCadastrar;
	private Botao botaoListar;
	private Botao botaoAtualizar;
	private Botao botaoDeletar;

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
		painelBotoes = new Painel(new Color(224, 224, 224), this);
		configurarBotoes(painelBotoes);
		this.add(painelBotoes, BorderLayout.NORTH);

		painelConteudo = new Painel(Color.WHITE, this);
		painelConteudo.setLayout(new FlowLayout());

		painelCadastrar = new PainelCadastrar(Color.WHITE, this);
		painelConteudo.add(painelCadastrar);
		painelCadastrar.naoVisivel();

		painelListar = new PainelListar(Color.WHITE, this);
		painelConteudo.add(painelListar);
		painelListar.naoVisivel();

		painelAtualizar = new PainelAtualizar(Color.WHITE, this);
		painelConteudo.add(painelAtualizar);
		painelAtualizar.naoVisivel();

		painelDeletar = new PainelDeletar(Color.WHITE, this);
		painelConteudo.add(painelDeletar);
		painelDeletar.naoVisivel();

		this.add(painelConteudo, BorderLayout.CENTER);
	}

	public void configurarBotoes(Painel painel) {
		botaoCadastrar = new Botao("Cadastrar", Color.WHITE);
		botaoCadastrar.addActionListener(new VisibleCadastrar());
		painel.add(botaoCadastrar);

		botaoListar = new Botao("Listar", Color.WHITE);
		botaoListar.addActionListener(new VisibleListar(this));
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
				botao.setBackground(new Color(224, 224, 224));
				updateTitle("Cadastrar");
			} else
				setTelaDefault();

		}
	}

	private class VisibleListar implements ActionListener {

		public Janela janela;

		public VisibleListar(Janela janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			JButton botao = (JButton) e.getSource();
			if (!painelListar.isVisible()) {
				setTelaDefault();
				painelCadastrar.naoVisivel();

				painelListar.visivel();

				painelConteudo.remove(painelListar);
				painelListar = new PainelListar(Color.WHITE, janela);
				painelConteudo.add(painelListar);

				painelAtualizar.naoVisivel();
				painelDeletar.naoVisivel();
				painelBotoes.setBackground(Color.WHITE);
				botao.setBackground(new Color(224, 224, 224));
				updateTitle("Listar");
			} else
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
				botao.setBackground(new Color(224, 224, 224));
				updateTitle("Atualizar");
			} else
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
				botao.setBackground(new Color(224, 224, 224));
				updateTitle("Deletar");
			} else
				setTelaDefault();

		}
	}

	public Painel getPainelBotoes() {
		return painelBotoes;
	}

	public void setPainelBotoes(Painel painelBotoes) {
		this.painelBotoes = painelBotoes;
	}

	public PainelCadastrar getPainelCadastrar() {
		return painelCadastrar;
	}

	public void setPainelCadastrar(PainelCadastrar painelCadastrar) {
		this.painelCadastrar = painelCadastrar;
	}

	public PainelListar getPainelListar() {
		return painelListar;
	}

	public void setPainelListar(PainelListar painelListar) {
		this.painelListar = painelListar;
	}

	public PainelAtualizar getPainelAtualizar() {
		return painelAtualizar;
	}

	public void setPainelAtualizar(PainelAtualizar painelAtualizar) {
		this.painelAtualizar = painelAtualizar;
	}

	public PainelDeletar getPainelDeletar() {
		return painelDeletar;
	}

	public void setPainelDeletar(PainelDeletar painelDeletar) {
		this.painelDeletar = painelDeletar;
	}

	public Painel getPainelConteudo() {
		return painelConteudo;
	}

	public void setPainelConteudo(Painel painelConteudo) {
		this.painelConteudo = painelConteudo;
	}

	public Botao getBotaoCadastrar() {
		return botaoCadastrar;
	}

	public void setBotaoCadastrar(Botao botaoCadastrar) {
		this.botaoCadastrar = botaoCadastrar;
	}

	public Botao getBotaoListar() {
		return botaoListar;
	}

	public void setBotaoListar(Botao botaoListar) {
		this.botaoListar = botaoListar;
	}

	public Botao getBotaoAtualizar() {
		return botaoAtualizar;
	}

	public void setBotaoAtualizar(Botao botaoAtualizar) {
		this.botaoAtualizar = botaoAtualizar;
	}

	public Botao getBotaoDeletar() {
		return botaoDeletar;
	}

	public void setBotaoDeletar(Botao botaoDeletar) {
		this.botaoDeletar = botaoDeletar;
	}
	
	
}
