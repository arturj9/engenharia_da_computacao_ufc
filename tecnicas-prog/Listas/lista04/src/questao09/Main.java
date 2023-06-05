package questao09;

public class Main {

	public static void main(String[] args) {
		Quadrado q = new Quadrado(10);
		Retangulo r = new Retangulo(5, 30);
		Triangulo t = new Triangulo(10,4);
		Circulo c = new Circulo(3);
		
		System.out.println(q.imprimirNome());
		System.out.println(q.calcularArea());
		
		System.out.println(r.imprimirNome());
		System.out.println(r.calcularArea());
		
		System.out.println(t.imprimirNome());
		System.out.println(t.calcularArea());
		
		System.out.println(c.imprimirNome());
		System.out.println(c.calcularArea());

	}

}
