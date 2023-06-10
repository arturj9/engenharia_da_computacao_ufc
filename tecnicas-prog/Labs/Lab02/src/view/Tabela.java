package view;

import javax.swing.JTable;

public class Tabela extends JTable {

	public Tabela(Object[][] dados, String[] colunas) {
		super(dados, colunas);
		this.setCellSelectionEnabled(false);
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
