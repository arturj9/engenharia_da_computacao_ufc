package questao09;

public class Circulo extends Forma {
	private float raio;

	public Circulo(float raio) {
		this.setRaio(raio);
	}
	
	public float calcularArea() {
		return (float) (3.14*(this.getRaio()*this.getRaio()));
	}
		
	public String imprimirNome() {
		return "Círculo";
	}

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}

}
