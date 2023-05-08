package controlador;

import java.util.ArrayList;

public class Relatorio {
	
	public String publicacao(ArrayList<Publicacao> p) {
		String relatorio="";
		int cont=1;
		for (Publicacao publicacao : p) {
			relatorio += "\n"+(cont++)+" "+publicacao.getTitulo()+"; "+publicacao.ano+"; "
					+publicacao.autor+"; "+publicacao.getQuantidadeDisponivel();
		}
		return relatorio;
	}
	
	public String cliente(ArrayList<Cliente> c) {
		String relatorio="";
		int cont=1;
		for (Cliente cliente : c) {
			relatorio += "\n"+(cont++)+" "+cliente.getMatricula()+"; "+cliente.nome+"; "
					+cliente.tps;
		}
		return relatorio;
	}
	
	public String emprestimo(int total, ArrayList<Cliente> clientes) {
		String relatorio = "Total: "+total+" - ";
		String professor = "Professor: ";
		String aluno = "; Aluno: ";
		String servidor =  "; Servidor: ";
		
		for (Cliente cliente : clientes) {
			if(cliente instanceof Professor){
				if(professor.length()==11) {
					professor+=cliente.nome;
				}else {
					professor+=" - "+cliente.nome;
				}
				
			}else if(cliente instanceof Aluno){
				if(aluno.length()==9) {
					aluno+=cliente.nome;
				}else {
					aluno+=" - "+cliente.nome;
				}
				
			}if(cliente instanceof Servidor){
				if(servidor.length()==12) {
					servidor+=cliente.nome;
				}else {
					servidor+=" - "+cliente.nome;
				}
				
			}
		}
		relatorio+=professor+aluno+servidor;
		return relatorio;
	}
}
