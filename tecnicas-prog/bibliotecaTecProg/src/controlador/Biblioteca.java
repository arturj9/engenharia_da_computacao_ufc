package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Biblioteca {

	private ArrayList<Emprestimo> listaEmprestimo;
	private Relatorio relatorio = new Relatorio();

	public Biblioteca() {
		listaEmprestimo = new ArrayList<Emprestimo>();
	}

	public String fazerEmprestimo(Cliente c, Publicacao p) {
		if (this.getEmprestimosDeCliente(c).size() < c.verificarPublicacaos()) {
			if (p.getQuantidadeDisponivel() > 0) {
				Emprestimo e = new Emprestimo(c, p);
				listaEmprestimo.add(e);
				p.setQuantidadeDisponivel(p.getQuantidadeDisponivel() - 1);
				return "Empréstimo feito com sucesso, tempo limite com a publicação: " + c.verificarDias() + " dias";

			} else {
				return "Essa publicação não está mais disponivel";
			}
		}
		return "Limite de publicações emprestadas para o tipo de usuário foi excedido (" + c.verificarPublicacaos()
				+ " publicações)";

	}

	public ArrayList<Emprestimo> getListaEmprestimo() {
		return listaEmprestimo;
	}

	public ArrayList<Emprestimo> getEmprestimosDeCliente(Cliente c) {
		ArrayList<Emprestimo> emprestimosDeCliente = new ArrayList<Emprestimo>();
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getCliente() == c)
				emprestimosDeCliente.add(emprestimo);

		}
		return emprestimosDeCliente;
	}

	public ArrayList<Publicacao> getEmprestimosDeCliente(int matricula) {
		ArrayList<Publicacao> publicacoesDeCliente = new ArrayList<Publicacao>();
		ArrayList<Emprestimo> emprestimosDeCliente;
		Cliente cliente = null;
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getCliente().getMatricula() == matricula) {
				cliente = emprestimo.getCliente();
				break;
			}
		}

		emprestimosDeCliente = this.getEmprestimosDeCliente(cliente);

		for (Emprestimo emprestimo : emprestimosDeCliente) {
			publicacoesDeCliente.add(emprestimo.getPublicacao());
		}

		return publicacoesDeCliente;

	}

	public String relatorioClientePublicacoes(int matricula) {
		String relatorio = "Publicações do usuário de matricula " + matricula + ": ";
		ArrayList<Publicacao> publicacoesDeCliente = this.getEmprestimosDeCliente(matricula);
		relatorio += this.relatorio.publicacao(publicacoesDeCliente);
		return relatorio;

	}

	public String getPublicacao(String nome) {
		ArrayList<Publicacao> p = new ArrayList<Publicacao>();
		for (Emprestimo emprestimo : listaEmprestimo) {
			if (emprestimo.getPublicacao().getTitulo().equals(nome)) {
				p.add(emprestimo.getPublicacao());
				break;
			}
		}
		if (p.size() == 0) {
			return "Publicação não encontrada";
		}
		return this.relatorio.publicacao(p);
	}

	public String getAcervo() {
		String texto = "\nAcervo\n";
		ArrayList<Publicacao> livros = new ArrayList<Publicacao>();
		ArrayList<Publicacao> artigos = new ArrayList<Publicacao>();
		ArrayList<Publicacao> revistas = new ArrayList<Publicacao>();
		for (Emprestimo emprestimo : listaEmprestimo) {
			Publicacao p = emprestimo.getPublicacao();
			if (p instanceof Livro) {
				boolean existe = false;
				for (Publicacao livro : livros) {
					if (livro == p)
						existe = true;
				}
				if (!existe)
					livros.add(p);
			} else if (p instanceof Artigo) {
				boolean existe = false;
				for (Publicacao artigo : artigos) {
					if (artigo == p)
						existe = true;
				}
				if (!existe)
					artigos.add(p);
			} else if (p instanceof Revista) {
				boolean existe = false;
				for (Publicacao revista : revistas) {
					if (revista == p)
						existe = true;
				}
				if (!existe)
					revistas.add(p);
			}

		}
		texto += "\nLivros:" + this.relatorio.publicacao(livros);
		texto += "\n\nArtigos: " + this.relatorio.publicacao(artigos);
		texto += "\n\nRevistas: " + this.relatorio.publicacao(revistas);
		return texto;

	}

	public String getClientes() {
		String texto = "\nClientes\n";
		ArrayList<Cliente> professores = new ArrayList<Cliente>();
		ArrayList<Cliente> alunos = new ArrayList<Cliente>();
		ArrayList<Cliente> servidores = new ArrayList<Cliente>();
		for (Emprestimo emprestimo : listaEmprestimo) {
			Cliente c = emprestimo.getCliente();
			if (c instanceof Professor) {
				boolean existe = false;
				for (Cliente cliente : professores) {
					if (c == cliente)
						existe = true;
				}
				if (!existe)
					professores.add(c);
			} else if (c instanceof Aluno) {
				boolean existe = false;
				for (Cliente cliente : alunos) {
					if (c == cliente)
						existe = true;
				}
				if (!existe)
					alunos.add(c);
			} else if (c instanceof Servidor) {
				boolean existe = false;
				for (Cliente cliente : servidores) {
					if (c == cliente)
						existe = true;
				}
				if (!existe)
					servidores.add(c);
			}
		}
		texto += "\nProfessores:" + this.relatorio.cliente(professores);
		texto += "\n\nAlunos: " + this.relatorio.cliente(alunos);
		texto += "\n\nServidores: " + this.relatorio.cliente(servidores);
		return texto;
	}

	public String getRelatorioGeral() {
		String texto = "\nEmpréstimos:\n";
		int totalLivros = 0;
		int totalArtigos = 0;
		int totalRevistas = 0;
		ArrayList<Cliente> clientesL = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesA = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesR = new ArrayList<Cliente>();
		for (Emprestimo emprestimo : listaEmprestimo) {
			Cliente c = emprestimo.getCliente();
			Publicacao p = emprestimo.getPublicacao();
			if (p instanceof Livro) {
				boolean existe = false;
				for (Cliente cliente : clientesL) {
					if (cliente == c)
						existe = true;
				}
				if (!existe)
					clientesL.add(c);

				totalLivros++;
			} else if (p instanceof Artigo) {
				boolean existe = false;
				for (Cliente cliente : clientesA) {
					if (cliente == c)
						existe = true;
				}
				if (!existe)
					clientesA.add(c);

				totalArtigos++;
			} else if (p instanceof Livro) {
				boolean existe = false;
				for (Cliente cliente : clientesR) {
					if (cliente == c)
						existe = true;
				}
				if (!existe)
					clientesR.add(c);

				totalRevistas++;
			}

		}

		texto += "Livros: " + this.relatorio.emprestimo(totalLivros, clientesL);
		texto += "\nArtigos: " + this.relatorio.emprestimo(totalArtigos, clientesA);
		texto += "\nRevistas: " + this.relatorio.emprestimo(totalRevistas, clientesR);
		return texto;
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int decisao = 0;
			System.out.print("\n\nMenu:" + "\n 1: Sair" + "\n 2: Listar publicações de cliente por matricula"
					+ "\n 3: Buscar publicação por nome" + "\n 4: Mostrar Acervo" + "\n 5: Listar clientes"
					+ "\n 6: Relatório de Empréstimos" + "\nR: ");
			decisao = scanner.nextInt();
			if (decisao == 1)
				break;
			else if (decisao == 2) {
				System.out.print("Informe a matricula: ");
				int matricula = scanner.nextInt();
				System.out.println(this.relatorioClientePublicacoes(matricula));
			} else if (decisao == 3) {
				scanner = new Scanner(System.in);
				System.out.print("Informe o nome da publicação: ");
				String nome = scanner.nextLine();
				System.out.println(this.getPublicacao(nome));
			} else if (decisao == 4) {
				System.out.println(this.getAcervo());
			} else if (decisao == 5) {
				System.out.println(this.getClientes());
			} else if (decisao == 6) {
				System.out.println(this.getRelatorioGeral());
			}

		}
		scanner.close();
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

}
