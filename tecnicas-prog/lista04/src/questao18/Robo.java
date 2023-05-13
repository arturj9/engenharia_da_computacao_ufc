package questao18;

public class Robo {
	private Mapa mapa;
	private String simbolo = " R ";
	private int caminhouNorte = 0;
	private int caminhouSul = 0;
	private int caminhouLeste = 0;
	private int caminhouOeste = 0;
	private int caminhouNordeste = 0;
	private int caminhouSudeste = 0;
	private int caminhouSudoeste = 0;
	private int caminhouNoroeste = 0;

	public Robo(Mapa mapa) {
		this.setMapa(mapa);
	}

	public void caminharNorte() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha() - 1;
		int coluna = mapa.getArea().get(posicao).getColuna();
		this.caminhar(linha,coluna);
		this.setCaminhouNorte();
	}

	public void caminharSul() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha() + 1;
		int coluna = mapa.getArea().get(posicao).getColuna();
		this.caminhar(linha,coluna);
		this.setCaminhouSul();
	}

	public void caminharLeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha();
		int coluna = mapa.getArea().get(posicao).getColuna()+1;
		this.caminhar(linha,coluna);
		this.setCaminhouLeste();
	}

	public void caminharOeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha();
		int coluna = mapa.getArea().get(posicao).getColuna()-1;
		this.caminhar(linha,coluna);
		this.setCaminhouOeste();
	}

	public void caminharNordeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha()-1;
		int coluna = mapa.getArea().get(posicao).getColuna()+1;
		this.caminhar(linha,coluna);
		this.setCaminhouNordeste();

	}

	public void caminharSudeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha()+1;
		int coluna = mapa.getArea().get(posicao).getColuna()+1;
		this.caminhar(linha,coluna);
		this.setCaminhouSudeste();
	}

	public void caminharSudoeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha()+1;
		int coluna = mapa.getArea().get(posicao).getColuna()-1;
		this.caminhar(linha,coluna);
		this.setCaminhouSudoeste();
	}

	public void caminharNoroeste() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		int linha = mapa.getArea().get(posicao).getLinha()-1;
		int coluna = mapa.getArea().get(posicao).getColuna()-1;
		this.caminhar(linha,coluna);
		this.setCaminhouNoroeste();
	}
	
	public void caminhar(int linha, int coluna) {
		for (Coordenada coordenada : mapa.getArea()) {
			if (coordenada.getLinha() == linha && coordenada.getColuna() == coluna) {
				coordenada.setRobo(this);
				if(!coordenada.isJaVisitada())
					coordenada.setJaVisitada(true);
			}
		}
	}
	
	public int quantPosicaoPassada() {
		int quant=0;
		for (Coordenada coordenada : mapa.getArea()) {
			if(coordenada.isJaVisitada())
				quant++;
		}
		return quant;
	}
	
	public int quantNaoPosicaoPassada() {
		int quant=0;
		for (Coordenada coordenada : mapa.getArea()) {
			if(!coordenada.isJaVisitada())
				quant++;
		}
		return quant;
	}
	
	public void caminhadaA() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		Coordenada coordenada = this.mapa.getArea().get(0);
		coordenada.setRobo(this);
		if(!coordenada.isJaVisitada())
			coordenada.setJaVisitada(true);
		posicao=0;
		for (int i=0;i<this.mapa.getArea().size()-1;i++) {
			if(this.mapa.getArea().get(i+1).getLinha()!=posicao) {
				this.caminharSul();
				i++;
				posicao++;
			}
			if(posicao%2==0) {
				this.caminharLeste();
			}else{
				this.caminharOeste();
			}
			
		}
	}
	
	public void caminhadaB() {
		int posicao = this.mapa.getPosicaoRobo();
		this.mapa.getArea().get(posicao).setRobo(null);
		Coordenada coordenada = this.mapa.getArea().get(0);
		coordenada.setRobo(this);
		if(!coordenada.isJaVisitada())
			coordenada.setJaVisitada(true);
		int tamanhoLinhas = this.mapa.getTamanhoLinhas()-1;
		for(int i=0;i<tamanhoLinhas;i++) {
			this.caminharSudeste();
		}
		for(int i=0;i<tamanhoLinhas;i++) {
			this.caminharNorte();
		}
		for(int i=0;i<tamanhoLinhas;i++) {
			this.caminharSudoeste();
		}
		for(int i=0;i<tamanhoLinhas-1;i++) {
			this.caminharNorte();
		}
		
	}
	
	public void caminhadaC() {
		int posicao=1;
		boolean finnal=false;
		for (int i=0;i<this.mapa.getTamanhoLinhas();i++) {
			if(posicao%2!=0||finnal) {
				for (int j = 0; j < posicao; j++) {
					this.caminharLeste();
				}
				for (int j = 0; j < posicao; j++) {
					this.caminharSul();
				}
				if(posicao!=this.mapa.getTamanhoLinhas()-1)
					posicao++;
				else
					finnal=true;
			}else{
				for (int j = 0; j < posicao; j++) {
					this.caminharOeste();
				}
				for (int j = 0; j < posicao; j++) {
					this.caminharNorte();
				}
				if(posicao!=this.mapa.getTamanhoLinhas()-1)
					posicao++;
				else
					finnal=true;
			}
			
		}
	}

	public int getCaminhouNorte() {
		return caminhouNorte;
	}

	public void setCaminhouNorte() {
		this.caminhouNorte++;
	}

	public int getCaminhouSul() {
		return caminhouSul;
	}

	public void setCaminhouSul() {
		this.caminhouSul++;
	}

	public int getCaminhouLeste() {
		return caminhouLeste;
	}

	public void setCaminhouLeste() {
		this.caminhouLeste++;
	}

	public int getCaminhouOeste() {
		return caminhouOeste;
	}

	public void setCaminhouOeste() {
		this.caminhouOeste++;
	}

	public int getCaminhouNordeste() {
		return caminhouNordeste;
	}

	public void setCaminhouNordeste() {
		this.caminhouNordeste++;
	}

	public int getCaminhouSudeste() {
		return caminhouSudeste;
	}

	public void setCaminhouSudeste() {
		this.caminhouSudeste++;
	}

	public int getCaminhouSudoeste() {
		return caminhouSudoeste;
	}

	public void setCaminhouSudoeste() {
		this.caminhouSudoeste++;
	}

	public int getCaminhouNoroeste() {
		return caminhouNoroeste;
	}

	public void setCaminhouNoroeste() {
		this.caminhouNoroeste++;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String quantDirecoes() {
		return "\nQuantidade caminhada pelo Robô\n"+ "Norte:" + caminhouNorte + ", Sul:" + caminhouSul + ", Leste:"
				+ caminhouLeste + ", Oeste:" + caminhouOeste + ", Nordeste:" + caminhouNordeste
				+ ", Sudeste:" + caminhouSudeste + ", Sudoeste:" + caminhouSudoeste
				+ ", Noroeste:" + caminhouNoroeste;
	}
	
	
	

}
