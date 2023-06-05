package questao06;

public class IngressoVIP extends Ingresso {
	
	public float valorAdicional;
	
	public float getValor() {
		return valor + valorAdicional;
	}

	public IngressoVIP(Ingresso ingresso, float valorAdicional) {
		super(ingresso.getValor());
		this.valorAdicional = valorAdicional;
	}
	
	public String toString() {
		return "Valor: "+ getValor();
	}
}
