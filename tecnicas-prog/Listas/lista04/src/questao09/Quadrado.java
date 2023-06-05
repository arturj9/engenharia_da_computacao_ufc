package questao09;

public class Quadrado extends Forma  {
	private float lado;
	
	public Quadrado(float lado) {
		this.setLado(lado);
	}
	
	public float calcularArea() {
		return this.getLado()*this.getLado();
	}
		
	public String imprimirNome() {
		return "Quadrado";
	}

	public float getLado() {
		return lado;
	}

	public void setLado(float lado) {
		this.lado = lado;
	}

}
