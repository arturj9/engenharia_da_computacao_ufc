package questao09;

public class Retangulo extends Forma {
	private float base;
	private float altura;
	
	public Retangulo(float base, float altura) {
		this.setAltura(altura);
		this.setBase(base);
	}
	
	public float calcularArea() {
		return this.getAltura()*this.getBase();
	}
		
	public String imprimirNome() {
		return "Retângulo";
	}
	
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
}
