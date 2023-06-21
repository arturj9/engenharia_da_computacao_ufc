package controlador;

public class IniciarBiblioteca {

	public static void main(String[] args) {
		
		
		//Clientes da Biblioteca TecProg
		Cliente aluno= new Aluno(30305, "Joao");
		Cliente aluno2= new Aluno(2552, "Marcos");
		
		Cliente professor = new Professor(2525, "Mateus");
		Cliente professor2 = new Professor(565, "jonas");
		
		Cliente servidor = new Servidor(898, "Michelle");
		Cliente servidor2 = new Servidor(982, "Thales");
		
		//Publicacoes da Biblioteca TecProg
		Publicacao livro = new Livro("Java como programa", 2020, "Deitel", 10);
		Publicacao livro2 = new Livro("Python como programa", 2019, "Oliveira", 10);
		
		Publicacao revista = new Revista("INDICO: inclusao digital necessaria para sociedade atual", 2023, "Geovana e Cau�", 8);
		Publicacao revista2 = new Revista("inteligencia artificial aplicada", 2023, "Amora",10);

		Publicacao artigo = new Artigo("Um comparativo de desempenho entre Java e Python", 2021, "Silva", 4);
		Publicacao artigo2 = new Artigo("Um comparativo entre o Eclipse e VsCode", 2023, "Cordeiro", 5);
		
		Biblioteca bib= new Biblioteca();
		System.out.println(bib.fazerEmprestimo(aluno, livro));
		System.out.println(bib.fazerEmprestimo(aluno, livro));
		System.out.println(bib.fazerEmprestimo(aluno, livro));
		System.out.println(bib.fazerEmprestimo(aluno, artigo2));
		System.out.println(bib.fazerEmprestimo(aluno, artigo));
		System.out.println(bib.fazerEmprestimo(aluno2, artigo));
		System.out.println(bib.fazerEmprestimo(aluno2, artigo));
		System.out.println(bib.fazerEmprestimo(professor, revista));
		System.out.println(bib.relatorioClientePublicacoes(30305));
		
		bib.menu();
		
	}

}
