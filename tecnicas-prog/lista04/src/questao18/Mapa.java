package questao18;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {
	private ArrayList<Coordenada> area;
	private Robo robo;
	
	public Mapa(int tamanhoX, int tamanhoY) {
		Random random = new Random();
		int moedaX = random.nextInt(tamanhoX);
		int moedaY = random.nextInt(tamanhoY);
		this.area = new ArrayList<Coordenada>();
		this.robo = new Robo(this);
		for (int i = 0; i < tamanhoX; i++) {
			for (int j = 0; j < tamanhoY; j++) {
				Coordenada coordenada = new Coordenada(i,j);
				if(i==(tamanhoX-1)/2&&j==(tamanhoY-1)/2) {
					coordenada.setRobo(this.robo);
					if(!coordenada.isJaVisitada())
						coordenada.setJaVisitada(true);
				}
				if(i==moedaX&&j==moedaY)
					coordenada.setMoeda(new Moeda());
				this.area.add(coordenada);
			}
		}
	}
	
	public String show() {
		String texto="\n";
		int posicao=0;
		for (Coordenada coordenada : area) {
			if(coordenada.getLinha()!=posicao) {
				posicao++;
				texto+="\n";
			}

			if(coordenada.verificaRobo())
				texto+=this.robo.getSimbolo();
			else if(coordenada.verificaMoeda()&&coordenada.isJaVisitada()) {
				texto+=coordenada.getMoeda().getSimbolo();
			}
			else
				texto+=coordenada.getSimbolo();
		}
		return texto;
	}
	
	public int getPosicaoRobo() {
		int posicao=0;
		for (Coordenada coordenada : area) {
			if(coordenada.temRobo())
				break;
			posicao++;
		}
		return posicao;
	}
	
	public int getTamanhoLinhas() {
		int posicao=0;
		for (Coordenada coordenada : area) {
			if(coordenada.getLinha()!=posicao) {
				posicao++;
			}
		}
		return posicao+1;
	}

	public ArrayList<Coordenada> getArea() {
		return area;
	}

	public void setArea(ArrayList<Coordenada> area) {
		this.area = area;
	}

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}
}
