package questao05;

public class Main {

	public static void main(String[] args) {
		Contato co = new Contato(1001, "João", "jj@mail.com");
		Contato co2 = new Contato(1002, "JP", "jPA@mail.com");
		Contato co3;
		
		Agenda a = new Agenda("Minha Agenda", "Hoje é um novo dia");
		
		Cliente c = new Cliente("Artur");
		
		c.setAgenda(a);
		
		c.agenda.addContato(co);
		c.agenda.addContato(co2);
		
		System.out.println(c.agenda.listarContatos());
		System.out.println(c.agenda.getContato(co2).verificarPreenchidoTotal());
		
		co3 = c.agenda.getContato(co2).duplicar();
		
		System.out.println(c.agenda.getContato(co3));
		
		c.agenda.addContato(co3);
		
		System.out.println(c.agenda.getContato(co3).getDados()+"\n\n");
		
		System.out.println(c.agenda.listarContatos());

	}

}
