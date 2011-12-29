package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

public class ConstraintsTable extends MackTable {
	
	public ConstraintsTable() {
		super();
		addColumn("Descrição");
		addColumn("Alternativa");
		addColumn("Função de Pertinência");
	}

	public void addConstraint(ArrayList constraint) {
		addRow(constraint);
	}
	
}
