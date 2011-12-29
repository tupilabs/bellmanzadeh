package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

public class AlternativesTable extends MackTable {
	
	private ArrayList variablesDataList_ = new ArrayList();
	
	public AlternativesTable() {
		super();
		buildColumns();
	}
	
	public void addVariableColumn(ArrayList row){
		this.addColumn(row.get(0).toString());
		this.variablesDataList_.add(row);
	}
	
	public ArrayList getVariables() {
		return this.variablesDataList_;
	}
	
	public void setVariables(ArrayList variables) {
		this.variablesDataList_ = variables;
	}
	
	public void buildColumns()
	{
		addColumn("Descrição");
	}
	
}
