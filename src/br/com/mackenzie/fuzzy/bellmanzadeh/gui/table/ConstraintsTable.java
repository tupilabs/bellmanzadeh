package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

public class ConstraintsTable extends MackTable {
	
	public ConstraintsTable() {
		super();
		addColumn("Descri��o");
		addColumn("Alternativa");
		addColumn("Fun��o de Pertin�ncia");
	}

	public void addConstraint(ArrayList constraint) {
		addRow(constraint);
	}
	
}
