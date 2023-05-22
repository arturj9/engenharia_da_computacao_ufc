package robo;

public class Main {

	public static void main(String[] args) {
		
		Plano p = new Plano(2, 2);
		
		Robo r = new Robo(1, "delta x", 2, 2, p);
		p.verificarSeTemRobo();
		r.moverEsquerda();
		p.verificarSeTemRobo();
		
	
	}
	

}
