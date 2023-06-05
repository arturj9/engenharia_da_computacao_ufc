package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PainelListar extends Painel {

	public PainelListar(Color color) {
		super(color);

		Object[][] dados = { { "João", 1234567812, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  },
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  }, 
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  },
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  }, 
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  },
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  }, 
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  },
				{ "João", 25235553, 2352355, "Ciências da Computação" }, 
				{ "Maria", 3023323, 435552355, "Automação"  }, 
				{ "Carlos", 405555, 54652355, "Telecomunicação"  }};

		String[] colunas = { "Nome", "CPF", "Matrícula", "Vertente" };
		
		Tabela tabela = new Tabela(dados, colunas);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.setRowHeight(30);
		
		JScrollPane painelRolagem = new JScrollPane(tabela);
		
		this.add(painelRolagem);
		
	}

}
