package br.com.mackenzie.fuzzy.bellmanzadeh.gui.table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MackTableModel extends AbstractTableModel{

	private ArrayList dataList_ = new ArrayList();
	private ArrayList columnNames_ = new ArrayList();
	
	public MackTableModel() {
		super();
	}
	
	public int getColumnCount() {
		return columnNames_.size();
	}
	
	public int getRowCount() {
		return dataList_.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList row = (ArrayList)dataList_.get(rowIndex);
		return row.get(columnIndex);
	}
	
	public void addRow(ArrayList row) {
		this.dataList_.add(row);
		fireTableStructureChanged();
	}
	
	public void removeRow(int rowIndex) {
		this.dataList_.remove(rowIndex);
		fireTableStructureChanged();
	}
	
	public void addColumn(String colName) {
		this.columnNames_.add(colName);
		fireTableStructureChanged();
	}
	
	public void removeColumn(int columnIndex) {
		this.columnNames_.remove(columnIndex);
		fireTableStructureChanged();
	}
	
	public ArrayList getColumnsDataList() {
		return this.columnNames_;
	}
	
	public void removeAllColumns() {
		this.columnNames_.clear();
		fireTableStructureChanged();
	}
	
	public String getColumnName(int column) {
		return (String)columnNames_.get(column);
	}
	
	public Object getColumnByName(String name) {
		Object r = null;
		for(int i = 0; i < this.columnNames_.size() ; ++i ){
			if(this.columnNames_.get(i).toString().equalsIgnoreCase("name")){
				r = columnNames_.get(i);
				break;
			}
		}
		return r;
	}
	
	public int getColumnIndexByName(String name) {
		int index = -1;
		for(int i = 0; i < this.columnNames_.size() ; ++i ){
			if(this.columnNames_.get(i).toString().equalsIgnoreCase("name")){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public ArrayList getRow(int index) {
		return (ArrayList)this.dataList_.get(index);
	}
	
	public void updateRow(int index, ArrayList row) {
		this.dataList_.set(index, row);
		fireTableStructureChanged();
	}
	
	public ArrayList getDataList() {
		return this.dataList_;
	}
	
	public void setDataList(ArrayList dataList) {
		this.dataList_ = dataList;
		fireTableStructureChanged();
	}
	
	public void clear() {
		this.dataList_.clear();
		this.columnNames_.clear();
		fireTableStructureChanged();
	}
	
	public void clearData() {
		this.dataList_.clear();
		fireTableStructureChanged();
	}
}
