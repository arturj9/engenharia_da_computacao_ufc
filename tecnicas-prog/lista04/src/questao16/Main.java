package questao16;

public class Main {

	public static void main(String[] args) {
		Elevador e = new Elevador();
		e.inicializa(5, 3);
		System.out.println(e.toString());
		e.entra();
		e.entra();
		e.entra();
		System.out.println(e.toString());
		e.sobe();
		System.out.println(e.toString());
		e.sai();
		e.sobe();
		System.out.println(e.toString());
		e.entra();
		e.entra();
		e.entra();
		e.entra();
		System.out.println(e.toString());
		e.sobe();
		e.sai();
		e.sai();
		System.out.println(e.toString());
		e.sobe();
		e.entra();
		System.out.println(e.toString());
		e.desce();
		e.desce();
		e.sai();
		e.sai();
		e.sai();
		System.out.println(e.toString());
		e.desce();
		e.desce();
		e.sai();
		e.sai();
		System.out.println(e.toString());
	}

}
