package questao06;

public class Main {

	public static void main(String[] args) {
//			6) Crie uma implementação orientada a objetos conforme os passos abaixo:
//				a) Crie uma classe chamada Ingresso que possua um atributo valor e um
//					método toString que retorne à informação do valor do ingresso.
//				b) Crie uma classe IngressoVIP, que herda de Ingresso e possui um atributo
//					valor Adicional. O método toString da classe IngressoVIP deve considerar que o
//					valor do ingresso é o valor da superclasse somado ao valor Adicional do
//					IngressoVIP.
//				c) Crie uma classe evento que é composta de uma lista ingresso.
//				d) Crie um método para possibilitar uma venda um determinado ingresso
//				e) Crie um método para computar o valor total dos ingressos vendidos
//				f) Crie um método que permita mostrar os ingressos que não foram vendidos
//				c) Crie uma classe para testar os objetos das classes Ingresso e IngressoVIP
		
		Ingresso ingresso = new Ingresso(100);
		System.out.println(ingresso.toString());
		
		IngressoVIP ingressoVIP = new IngressoVIP(ingresso, 50);
		System.out.println(ingressoVIP.toString());
		
		Evento calourada = new Evento(100);
		System.out.println("Valor Total: "+calourada.valorTotal());
		System.out.println(calourada.venderIngresso(ingresso));
		System.out.println("Valor Total: "+calourada.valorTotal());
		System.out.println(calourada.venderIngresso(ingressoVIP));
		System.out.println("Valor Total: "+calourada.valorTotal());
		System.out.println(calourada.venderIngresso(ingressoVIP));
		System.out.println("Valor Total: "+calourada.valorTotal());
		
		System.out.println("Ingressos não vendidos: "+calourada.getIngressosNaoVendidos());

	}

}
