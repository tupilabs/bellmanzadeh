package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddVariablePanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class AddVariableAction  extends BaseAction {

	private AddVariablePanel panel_;
	private JDialog  dialog_;
	
	public AddVariableAction(Component owner, JDialog dialog) {
		super(owner);
		panel_ = (AddVariablePanel)this.getOwner();
		dialog_ = dialog;
		putValue(AbstractAction.NAME, "Adicionar");
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
			table.addRow(row);
			dialog_.setVisible(false);
		}
	}
	
}