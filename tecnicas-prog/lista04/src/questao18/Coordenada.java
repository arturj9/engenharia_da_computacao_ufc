package questao18;

public class Coordenada {
	private int linha;
	private int coluna;
	private Robo robo;
	private Moeda moeda;
	private boolean jaVisitada = false;
	private String simbolo = " * ";
	
	public Coordenada(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Coordenada(int linha, int coluna, Robo robo) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.robo = robo;
	}
	
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public Robo getRobo() {
		return robo;
	}
	public void setRobo(Robo robo) {
		this.robo = robo;
	}
	
	
	public boolean temRobo() {
		if(this.robo==null)
			return false;
		return true;
	}

	public boolean isJaVisitada() {
		return jaVisitada;
	}
	
	public boolean verificaMoeda() {
		if(this.getMoeda()==null)
			return false;
		return true;
	}
	
	public boolean verificaRobo() {
		if(this.getRobo()==null)
			return false;
		return true;
	}

	public void setJaVisitada(boolean jaVisitada) {
		if(!this.verificaMoeda()) {
			if(jaVisitada&&!this.jaVisitada)
				this.setSimbolo(" @ ");
		}
		this.jaVisitada=jaVisitada;
		
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	
	
	
	
}
