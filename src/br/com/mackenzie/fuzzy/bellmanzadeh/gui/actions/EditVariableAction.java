package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.EditVariablePanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.VariablesTable;

public class EditVariableAction extends BaseAction {

	private EditVariablePanel panel_;
	private JDialog  dialog_;
	private VariablesTable table_;
	
	public EditVariableAction(Component owner, JDialog dialog, VariablesTable table) {
		super(owner);
		panel_ = (EditVariablePanel)this.getOwner();
		dialog_ = dialog;
		table_ = table;
		putValue(AbstractAction.NAME, "Salvar");
	}
	
	public void actionPerformed(ActionEvent e) {
		String variable = panel_.getVariabletextField().getText();
		Object type     = panel_.getTypeComboBox().getSelectedItem();
		if( (variable == null || variable.trim().equals("")) || (type == null)) {
			JOptionPane.showMessageDialog(this.panel_, "Preencha corretamente os campos necessários", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			MackTable table = panel_.getTable();
			ArrayList row = new ArrayList();
			row.add(variable);
			row.add(type);
			table.updateRow(table_.getSelectedRow(), row);
			dialog_.setVisible(false);
		}
	}
	
}