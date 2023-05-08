package questao06;

public class Main {

	public static void main(String[] args) {
		
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
