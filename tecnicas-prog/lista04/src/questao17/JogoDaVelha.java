package questao17;

import java.util.Scanner;

public class JogoDaVelha {
	private String[][] glade = new String[3][3];
	private String[] possibilidades = {"*","X","O"};
	
	public JogoDaVelha() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++)
			glade[i][j]=this.getPossibilidades()[0];
		}
			
	}

	public String verGlade() {
		String texto="";
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				texto+=glade[i][j]+" ";
				if(j==2)
					texto+="\n";
			}
		}
		return texto;
	}

	public String[] getPossibilidades() {
		return possibilidades;
	}
	
	public String[][] getGlade() {
		return glade;
	}
	
	public void setGlade(String[][] glade) {
		this.glade = glade;
	}
	
	public boolean jogada(int possibilidadePosicao, int x, int y) {
		x--;
		y--;
		String[][] novaGlade = this.getGlade();
		if(this.getGlade()[x][y]==this.getPossibilidades()[0]) {
			novaGlade[x][y]=this.getPossibilidades()[possibilidadePosicao];
			this.setGlade(novaGlade);
			return true;
		}
		else
			return false;
			
	}
	
	public boolean vezJogador1(int x, int y) {
		return jogada(1,x,y);
	}
	
	public boolean vezJogador2(int x, int y) {
		return jogada(2,x,y);
	}
	
	public boolean verificaEmpate() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.getGlade()[i][j]==this.getPossibilidades()[0])
					return false;
			}
		}
		return true;
	}
	
	public boolean verificaVitoriaLinha(int possibilidadePosicao, int x) {
		x--;
		for(int i=0;i<3;i++) {
			if(this.getGlade()[x][i]!=this.getPossibilidades()[possibilidadePosicao])
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaColuna(int possibilidadePosicao, int y) {
		y--;
		for(int i=0;i<3;i++) {
			if(this.getGlade()[i][y]!=this.getPossibilidades()[possibilidadePosicao])
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaDiagonalPrincipal(int possibilidadePosicao) {
		for(int i=0;i<3;i++) {
			if(this.getGlade()[i][i]!=this.getPossibilidades()[possibilidadePosicao])
				return false;
		}
		return true;
	}
	
	public boolean verificaVitoriaDiagonalSecundaria(int possibilidadePosicao) {
		int cont=2;
		for(int i=0;i<3;i++) {
			if(this.getGlade()[i][cont--]!=this.getPossibilidades()[possibilidadePosicao])
				return false;
		}
		return true;
	}
	
	public boolean verificarVitoria(int possibilidadePosicao, int x, int y) {
		if(this.verificaVitoriaLinha(possibilidadePosicao, x)||this.verificaVitoriaColuna(possibilidadePosicao, y)
				||this.verificaVitoriaDiagonalPrincipal(possibilidadePosicao)
				||this.verificaVitoriaDiagonalSecundaria(possibilidadePosicao))
			return true;
		return false;
	}
	
	public void jogar() {
		int x=0;
		int y=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n"+this.verGlade());
		while(true) {
			while(true) {
				System.out.println("Jogador 1");
				System.out.print("Linha: ");
				x=scanner.nextInt();
				System.out.print("Coluna: ");
				y=scanner.nextInt();
				if(this.vezJogador1(x, y))
					break;
				else
					System.out.println("\nMovimento inválido, tente novamente");
				System.out.println("\n"+this.verGlade());
			}
			
			System.out.println("\n"+this.verGlade());
			
			if(verificaEmpate()) {
				System.out.println("\nEmpate");
				break;
			}else if(this.verificarVitoria(1, x, y)) {
				System.out.println("\nJogador 2 foi derrotado");
				break;
			}
			
			while(true) {
				System.out.println("Jogador 2");
				System.out.print("Linha: ");
				x=scanner.nextInt();
				System.out.print("Coluna: ");
				y=scanner.nextInt();
				if(this.vezJogador2(x, y))
					break;
				else
					System.out.println("\nMovimento inválido, tente novamente");
				System.out.println("\n"+this.verGlade());
			}
			
			System.out.println("\n"+this.verGlade());
			
			if(verificaEmpate()) {
				System.out.println("\nEmpate");
				break;
			}else if(this.verificarVitoria(2, x, y)) {
				System.out.println("\nJogador 1 foi derrotado");
				break;
			}
		}
	}
}
