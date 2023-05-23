package prova01;

import apresentacao.Terminal;

public class Inteiro {
	private int numero;
	private Terminal terminal;

	public Inteiro(String msg) {
		this.terminal = new Terminal();
		entrada(msg);
	}
	
	public void entrada(String msg) {
		try {
			System.out.print(msg);
			setNumero(terminal.entrada.nextInt());
		}catch (NumberFormatException e) {
			entrada(msg);
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
}
