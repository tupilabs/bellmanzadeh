package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class RemoveObjectiveOrConstraintAction extends BaseAction {

	private MackTable  table_;
	
	public RemoveObjectiveOrConstraintAction(Component owner, MackTable table) {
		super(owner);
		table_ = table;
		putValue(AbstractAction.NAME, "Remover");
	}
	
	public void actionPerformed(ActionEvent e) {
		int selectedRow = table_.getSelectedRow();
		if(selectedRow >= 0) {
			if(JOptionPane.showConfirmDialog(this.getOwner(), "Remover linha " + selectedRow + "?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
				table_.removeRow(selectedRow);
				if(table_.getRowCount() == 0) {
					this.getOwner().repaint(); // Great trick! 
				}
			}
		} else {
			JOptionPane.showMessageDialog(this.getOwner(), "Não há linhas selecionadas para remover.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}	
}