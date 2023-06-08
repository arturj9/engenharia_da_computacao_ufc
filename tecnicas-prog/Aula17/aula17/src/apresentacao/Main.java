package apresentacao;

import negocio.CartelaClientes;
import negocio.Cliente;
import persistencia.Escrever;
import persistencia.LerDados;

public class Main {

	public static void main(String[] args) {
		
		LerDados ler = new LerDados();
		ler.lerDados("dados/dadosCliente.txt");
		
		CartelaClientes cartela = new CartelaClientes();
		cartela.setListaCliente(ler.lista);
		
		cartela.addCliente(new Cliente("Antonio", 52, "102.454.548-56"));
		System.out.println(cartela.quantidadeCliente());
		
		Escrever escrever= new Escrever();
		escrever.escerverDados("dados/dadosCliente.txt", cartela.formatarDados() );
	}

}
