package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;

public class MackTable extends JTable{

	private MackTableModel tableModel_ = new MackTableModel();
	
	public MackTable() {
		super();
		this.setModel(tableModel_);
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	}
	
	public void addColumn(String title) {
		this.tableModel_.addColumn(title);
	}
	
	public void removeColumn(int index) {
		this.tableModel_.removeColumn(index);
	}
	
	public void addRow(ArrayList row) {
		this.tableModel_.addRow(row);
	}
	
	public void removeRow(int index) {
		this.tableModel_.removeRow(index);
	}
	
	public ArrayList getRow(int index) {
		return this.tableModel_.getRow(index);
	}
	
	public void updateRow(int index, ArrayList row) {
		this.tableModel_.updateRow(index, row);
	}
	
	public void setDataList(ArrayList dataList) {
		this.tableModel_.setDataList(dataList);
	}
	
	public ArrayList getDataList() {
		return this.tableModel_.getDataList();
	}
	
	public ArrayList getColumnsNames() {
		return this.tableModel_.getColumnsDataList();
	}
	
	public MackTableModel getTableModel() {
		return this.tableModel_;
	}
	
	public void removeAllColumns() {
		this.tableModel_.removeAllColumns();
	}
	
	public void clear() {
		this.tableModel_.clear();
	}
	
	public void clearData() {
		this.tableModel_.clearData();
	}
	
	public void buildColumns() {
		throw new RuntimeException("Not implemented");
	}
	
	public static void main(String[] args) {
		JTable table = new MackTable();
		RunForm.runTable(table);
	}
	
}
