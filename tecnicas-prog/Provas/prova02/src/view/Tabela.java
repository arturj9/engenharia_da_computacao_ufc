package view;

import java.awt.Color;

import javax.swing.JTable;

public class Tabela extends JTable {

	public Tabela(Object[][] dados, String[] colunas) {
		super(dados, colunas);
		this.setCellSelectionEnabled(false);
		this.setBackground(Color.cyan);
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
