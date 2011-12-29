package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

public class ObjectivesTable extends MackTable {
	
	public ObjectivesTable() {
		super();
		addColumn("Descri��o");
		addColumn("Alternativa");
		addColumn("Fun��o de Pertin�ncia");
	}
	
	public void addObjective(ArrayList objective) {
		addRow(objective);
	}
	
}
