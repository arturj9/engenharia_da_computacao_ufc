package questao08;

public class Main {

	public static void main(String[] args) {
		ContaEspecial ce = new ContaEspecial(12458, 1122, 100, 50);
		
		System.out.println("Saque: "+ce.sacar(50));
		System.out.println("Saldo: "+ce.getSaldo());
		System.out.println("Saque: "+ce.sacar(50));
		System.out.println("Saldo: "+ce.getSaldo());
		System.out.println("Saque: "+ce.sacar(40));
		System.out.println("Saldo: "+ce.getSaldo());
		System.out.println("Saque: "+ce.sacar(50));
		System.out.println("Saldo: "+ce.getSaldo());

	}

}
