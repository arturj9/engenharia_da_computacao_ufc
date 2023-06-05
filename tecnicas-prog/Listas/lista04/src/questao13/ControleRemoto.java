package questao13;

public class ControleRemoto {
	private int volume = 50;
	private int canal = 10;
	private boolean ligado = false;
	
	public String ligar() {
		this.setLigado(true);
		return "Ligado";
	}
	
	public String desligar() {
		this.setLigado(false);
		return "Desligado";
	}
	
	public void aumentarVolume() {
		this.setVolume(this.getVolume()+1);
	}
	
	public void diminuirVolume() {
		this.setVolume(this.getVolume()-1);
	}
	
	public void aumentarCanal() {
		this.setCanal(this.getCanal()+1);
	}
	
	public void diminuirCanal() {
		this.setCanal(this.getCanal()-1);
	}
	
	public void trocarCanal(int canal) {
		this.setCanal(canal);
	}
	
	public void mute() {
		this.setVolume(0);
	}
	
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		if(canal>=0)
			this.canal = canal;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		if(volume>=0&&volume<=100)
			this.volume = volume;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	
}
