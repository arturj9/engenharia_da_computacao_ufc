package questao17;

import java.util.ArrayList;
import java.util.Scanner;

public class JogoDaVelha {
	private String[][] glade = new String[3][3];
	private ArrayList<String> possibilidades;
	private Jogador jogador1 = new Jogador("X");
	private Jogador jogador2 = new Jogador("O");
	
	public JogoDaVelha() {
		String[][] gladeInicial = new String[3][3];
		ArrayList<String> possibilidades = new ArrayList<String>(3);
		
		if(this.jogador1.getSimbolo()!=this.jogador2.getSimbolo()) {
			
			possibilidades.add(" ");
			this.setPossibilidades(possibilidades);
			possibilidades.add(this.jogador1.getSimbolo());
			possibilidades.add(this.jogador2.getSimbolo());
			
			for(int i=0;i<this.gladeTamanho();i++) {
				for(int j=0;j<this.gladeTamanho();j++)
				gladeInicial[i][j]=this.possibilidades.get(0);
			}
			this.setGlade(gladeInicial);
			this.setPossibilidades(possibilidades);
		}
	}

	public ArrayList<String> getPossibilidades() {
		return possibilidades;
	}
	
	public void setPossibilidades(ArrayList<String> possibilidades) {
		this.possibilidades = possibilidades;
	}
	
	public String[][] getGlade() {
		return glade;
	}
	
	public void setGlade(String[][] glade) {
		this.glade = glade;
	}
	
	public String verGlade() {
		String texto="";
		for(int i=0;i<this.gladeTamanho();i++) {
			for(int j=0;j<this.gladeTamanho();j++) {
				texto+=glade[i][j];
				if(j!=this.gladeTamanho()-1)
					texto+=" | ";
				else
					texto+="\n";
			}
			if(i!=this.gladeTamanho()-1)
				texto+="---------\n";
		}
		return texto;
	}
	
	public int gladeTamanho() {
		return this.glade.length;
	}
	
 	public boolean jogada(Jogador jogador, int linha, int coluna) {
 		if(linha<0||linha>this.gladeTamanho()-1||coluna<0||coluna>this.glade[0].length)
 			return false;
 		else if(this.getGlade()[linha][coluna].equals(this.getPossibilidades().get(0))) {
			this.getGlade()[linha][coluna]=jogador.getSimbolo();
			return true;
		}
		else
			return false;	
	}
	
	public Jogador getJogador1() {
		return jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}
	
	public boolean verificaEmpate() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.getGlade()[i][j]==this.getPossibilidades().get(0))
					return false;
			}
		}
		return true;
	}
	
	public boolean verificaVitoriaLinha(String simbolo, int linha) {
		for(int j=0;j<this.gladeTamanho();j++) {
			if(!(this.getGlade()[linha][j].equals(simbolo)))
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaColuna(String simbolo, int coluna) {
		for(int i=0;i<this.gladeTamanho();i++) {
			if(!(this.getGlade()[i][coluna].equals(simbolo)))
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaDiagonalPrincipal(String simbolo) {
		for(int i=0;i<this.gladeTamanho();i++) {
			if(!(this.getGlade()[i][i].equals(simbolo)))
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaDiagonalSecundaria(String simbolo) {
		int cont=(this.gladeTamanho()/2)+1;
		for(int i=0;i<this.gladeTamanho();i++) {
			if(!(this.getGlade()[i][cont--].equals(simbolo)))
				return false;
		}
		return true;
	}
	
	public boolean verificarVitoria(Jogador jogador, int linha, int coluna) {
		String simbolo = jogador.getSimbolo();
		if(this.verificaVitoriaLinha(simbolo, linha)
				||this.verificaVitoriaColuna(simbolo, coluna)
				||this.verificaVitoriaDiagonalPrincipal(simbolo)
				||this.verificaVitoriaDiagonalSecundaria(simbolo))
			return true;
		return false;
	}
	
	public void jogar() {
		int linha=0;
		int coluna=0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n"+this.verGlade());
		
		while(true) {
			
			while(true) {
				
				System.out.println("Jogador 1");
				System.out.print("Linha: ");
				linha=scanner.nextInt();
				System.out.print("Coluna: ");
				coluna=scanner.nextInt();
				
				if(this.jogada(this.getJogador1(), linha-1, coluna-1))
					break;
				else
					System.out.println("\nMovimento inválido, tente novamente");
				System.out.println("\n"+this.verGlade());
			}
			
			System.out.println("\n"+this.verGlade());
			
			if(this.verificarVitoria(this.getJogador1(), linha-1, coluna-1)) {
				System.out.println("Jogador 2 foi derrotado");
				break;
			}else if(verificaEmpate()) {
				System.out.println("Empate");
				break;
			}
			
			while(true) {
				
				System.out.println("Jogador 2");
				System.out.print("Linha: ");
				linha=scanner.nextInt();
				System.out.print("Coluna: ");
				coluna=scanner.nextInt();
				
				if(this.jogada(jogador2, linha-1, coluna-1))
					break;
				else
					System.out.println("\nMovimento inválido, tente novamente");
				System.out.println("\n"+this.verGlade());
			}
			
			System.out.println("\n"+this.verGlade());
			
			if(this.verificarVitoria(this.getJogador2(), linha-1, coluna-1)) {
				System.out.println("Jogador 1 foi derrotado");
				break;
			}else if(verificaEmpate()) {
				System.out.println("Empate");
				break;
			}
		}
		
		
		scanner.close();
	}

}
