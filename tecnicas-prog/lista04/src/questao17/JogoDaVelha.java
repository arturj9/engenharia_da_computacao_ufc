package questao17;

public class JogoDaVelha {
	private String[][] glade;
	private String[] possibilidades = {"*","X","O"};
	
	public JogoDaVelha() {
		for(int i=0;i<glade.length;i++) {
			for()
			glade[i]=this.getPossibilidades()[0];
		}
			
	}

	public String[][] getGlade() {
		return glade;
	}

	public String[] getPossibilidades() {
		return possibilidades;
	}
}
