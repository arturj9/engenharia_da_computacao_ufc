package questao03;

public class Main {

	public static void main(String[] args) {
		Fatura fatura = new Fatura(123,"Salgadinho", 100, 1.5);
		System.out.println(fatura.getValorFatura());
		fatura.setDescontoEmPorcentagem(11);
		System.out.println(fatura.getValorFatura());
	}

}
