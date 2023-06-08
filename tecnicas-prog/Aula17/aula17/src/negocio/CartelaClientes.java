package negocio;

import java.io.LineNumberInputStream;
import java.util.ArrayList;

public class CartelaClientes {

	private ArrayList<Cliente> listaCliente;
	
	public CartelaClientes() {
	 listaCliente= new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente c) {
		listaCliente.add(c);
	}
	
	public void setListaCliente(ArrayList<Cliente> lista) {
		listaCliente= lista;
	}
	
	public int quantidadeCliente() {
		return listaCliente.size();
	}
	
	public String formatarDados() {
		
		String saida="";
		for (Cliente cliente : listaCliente) {
			saida += cliente.id + "; "+ cliente.nome +";  "+ cliente.cpf +" \n" ;
		}
		return saida;
	}
	
	
	
}
