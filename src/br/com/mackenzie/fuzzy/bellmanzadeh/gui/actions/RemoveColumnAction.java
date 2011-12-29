package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTableModel;

public class RemoveColumnAction extends BaseAction{

	public RemoveColumnAction(Component owner) {
		super(owner);
		this.putValue(AbstractAction.NAME, "Remover coluna");
	}
	
	public void actionPerformed(ActionEvent e) {
		MackTable table = (MackTable)this.getOwner();
		
		int selectedColumn = table.getSelectedColumn();
		if(selectedColumn != 0 && selectedColumn != 1) {
			System.out.println("Removing " + selectedColumn);
			MackTableModel model = (MackTableModel)table.getModel();
			model.removeColumn(selectedColumn+1);
		}
	}
	
}
