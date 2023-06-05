package questao13;

public class Main {

	public static void main(String[] args) {
		ControleRemoto c = new ControleRemoto();
		
		System.out.println(c.ligar());
		System.out.println(c.desligar());
		System.out.println(c.ligar());
		System.out.println("Canal: "+c.getCanal());
		System.out.println("Volume: "+c.getVolume());
		c.aumentarVolume();
		c.aumentarVolume();
		System.out.println("Volume: "+c.getVolume());
		c.diminuirVolume();
		System.out.println("Volume: "+c.getVolume());
		c.mute();
		System.out.println("Volume: "+c.getVolume());
		c.diminuirCanal();
		System.out.println("Canal: "+c.getCanal());
		c.aumentarCanal();
		c.aumentarCanal();
		System.out.println("Canal: "+c.getCanal());
		c.trocarCanal(100);
		System.out.println("Canal: "+c.getCanal());
	}

}
