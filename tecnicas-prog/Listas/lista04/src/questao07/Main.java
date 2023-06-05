package questao07;

public class Main {

	public static void main(String[] args) {
		
		Empregado e = new Empregado("Luca Gomes", 5000);
		Gerente g = new Gerente("Tales B.", 10000, "Financeiro");
		Vendedor v = new Vendedor("Oliver Oliveira", 3000, 10);
		
		System.out.println(e.toString());
		System.out.println(g.toString());
		System.out.println(v.toString());

	}

}
