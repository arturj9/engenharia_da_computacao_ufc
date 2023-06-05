package questao18;

public class Main {

	public static void main(String[] args) {
		Mapa m = new Mapa(7,7);
		Robo r = m.getRobo();
		System.out.println(m.show());
//		r.caminharNorte();
//		System.out.println(m.show());
//		r.caminharSul();
//		r.caminharSul();
//		System.out.println(m.show());
//		r.caminharLeste();
//		System.out.println(m.show());
//		r.caminharOeste();
//		System.out.println(m.show());
//		r.caminharNordeste();
//		System.out.println(m.show());
//		r.caminharNoroeste();
//		System.out.println(m.show());
//		r.caminharSudoeste();
//		System.out.println(m.show());
//		r.caminharSudeste();
//		System.out.println(m.show());
		
//		r.caminhadaA();
//		r.caminhadaB();
		r.caminhadaC();
	
		System.out.println(m.show());
		System.out.println(r.quantDirecoes());
		System.out.println("\nPassada: "+r.quantPosicaoPassada());
		System.out.println("\nNão Passada: "+r.quantNaoPosicaoPassada());
	}

}
