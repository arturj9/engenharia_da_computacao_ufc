package view;

import java.awt.Color;

public class PainelMenu extends Painel{

	public PainelMenu(Color color, Janela janela) {
		super(color, janela);
		Color corBotao = new Color(134,193,239);
		Botao botaoVerificar = new Botao("Verificar",corBotao );
		Botao botaoProximaJogada = new Botao("Proxima Jogada",corBotao);
		Botao botaoSairDoJogo = new Botao("Sair do Jogo",corBotao);
		this.add(botaoVerificar);
		this.add(botaoProximaJogada);
		this.add(botaoSairDoJogo);
	}

}
