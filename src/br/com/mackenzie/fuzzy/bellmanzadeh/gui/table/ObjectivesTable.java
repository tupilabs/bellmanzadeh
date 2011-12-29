package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

public class ObjectivesTable extends MackTable {
	
	public ObjectivesTable() {
		super();
		addColumn("Descrição");
		addColumn("Alternativa");
		addColumn("Função de Pertinência");
	}
	
	public void addObjective(ArrayList objective) {
		addRow(objective);
	}
	
}
