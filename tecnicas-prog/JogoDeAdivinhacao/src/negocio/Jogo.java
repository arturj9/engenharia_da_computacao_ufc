package negocio;

import apresentacao.*;

import java.util.Random;

public class Jogo {

	private Jogador jogador;
	private Tela tela;
	private Terminal terminal;
	private int numeroEscolhido;
	private boolean jogando;

	public Jogo() {
		tela = new Tela();
		terminal = new Terminal();
		jogador = new Jogador();
		numeroEscolhido = gerarNumeroAleatorio();
		jogando = true;
	}

	public void inciarJogoTerminal() {
		jogador.setNome(terminal.entradaNome());
		terminal.mesagem("Seja bem vindo(a): " + jogador.getNome());
	}

	public void inciarJogoGUI() {
		jogador.setNome(tela.entradaDados("Informe seu nome?"));
		tela.mesagem("Seja bem vindo(a): " + jogador.getNome());
		jogadas();
	}

	public void solicitarNumero() {
		try {
			String numero = tela.entradaDados("Informe um numero:");
			jogador.setNumeroAtual(Integer.parseInt(numero));
		}catch (NumberFormatException e) {
			tela.mesagem("Entrada invalida");
			solicitarNumero();
		}
	}

	public void jogadas() {
		do {
			verificarAcerto();
		} while (jogando);

	}

	private void fimDoJogo() {
		String texto = "Parabens voce acertou!\nNumero de tentativas: " + jogador.getNumeroTentativa()
				+ "\nNumeros apostados:";
		for (Integer numero : jogador.getListaNumeros()) {
			texto += " " + numero;
		}
		tela.mesagem(texto);
		jogando = false;
	}

	public boolean verificarMenor(int numero) {
		if (numero < numeroEscolhido)
			return true;
		return false;
	}

	public void verificaErro(int numero, String msg) {
		if (verificarMenor(numero)) {
			tela.mesagem(msg + "Tente um numero maior");
		} else {
			tela.mesagem(msg + "Tente um numero menor");
		}
	}

	public void verificarAcerto() {
		solicitarNumero();
		jogador.setNumeroTentativa();
		if (jogador.getNumeroAtual() == numeroEscolhido)
			fimDoJogo();
		else
			this.verificaErro(jogador.getNumeroAtual(),
					"Deu ruim, voce errou.\nNumero de tentativas: " + jogador.getNumeroTentativa() + "\n");
	}

	public int gerarNumeroAleatorio() {
		int min = 1;
		int max = 100;
		Random random = new Random();
		return random.nextInt((max - min + 1)) + min;
	}

}
