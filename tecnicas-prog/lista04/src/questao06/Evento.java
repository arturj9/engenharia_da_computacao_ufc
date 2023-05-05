package questao06;

import java.util.ArrayList;

public class Evento {
	public ArrayList<Ingresso> ingressos;
	public int quant;
	
	public Evento(int quant) {
		this.quant = quant;
		ingressos = new ArrayList<Ingresso>(quant);
	}

	public String venderIngresso(Ingresso ingresso) {
		if(ingressos.size()<quant) {
			ingressos.add(ingresso);
			return "Ingresso vendido com sucesso";	
		}
		return "Ingressos esgotados";
		
	}
	
	public float valorTotal() {
		int valorTotal = 0;
		for (Ingresso ingresso : ingressos) {
			valorTotal+=ingresso.getValor();
		}
		return valorTotal;
	}
	
	public int getIngressosNaoVendidos() {
		return quant-ingressos.size();
	}
}
