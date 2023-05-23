package apresentacao;

import java.util.Scanner;

public class Terminal {
	public Scanner entrada;
	
	public Terminal() {
		entrada = new Scanner (System.in);
	}
	
	public void mensagem(String msg) {
		System.out.println("\n"+msg+"\n");	
	}
	
	public String entradaString(String msg) {
		System.out.print(msg);
		String texto= entrada.next();
		return texto;
	}
	
	public int entradaInteiro(String msg) {
		System.out.print(msg);
		int numero = entrada.nextInt();
		return numero;
	}
}
