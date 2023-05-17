package apresentacao;

import java.util.Scanner;


public class Terminal {

	public void mesagem(String msg) {
		System.out.println(msg);	
	}
	
	public String entradaNome() {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Qual é o seu nome?");
		String nome= entrada.next();
		return nome;
	}
}
