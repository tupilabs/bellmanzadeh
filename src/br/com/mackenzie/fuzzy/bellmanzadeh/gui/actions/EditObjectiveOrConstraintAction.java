package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.EditObjectiveOrConstraintPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class EditObjectiveOrConstraintAction extends BaseAction {

	private EditObjectiveOrConstraintPanel panel_;
	private JDialog  dialog_;
	private MackTable table_;
	
	public EditObjectiveOrConstraintAction(Component owner, JDialog dialog, MackTable table) {
		super(owner);
		panel_ = (EditObjectiveOrConstraintPanel)this.getOwner();
		dialog_ = dialog;
		table_ = table;
		putValue(AbstractAction.NAME, "Salvar");
	}
	
	public void actionPerformed(ActionEvent e) {
		String description = panel_.getDescriptionTextField().getText();
		Object alternative = panel_.getAlternativesComboBox().getSelectedItem();
		Object membership  = panel_.getMembershipFunction();
		if( alternative == null || (description == null || description.trim().equals("")) || (alternative == null || alternative.equals("") ) || membership == null) {
			JOptionPane.showMessageDialog(this.panel_, "Preencha corretamente os campos necessários", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			MackTable table = panel_.getTable();
			ArrayList row = new ArrayList();
			row.add(description);
			row.add(alternative);
			row.add(membership);
			table.updateRow(table_.getSelectedRow(), row);
			dialog_.setVisible(false);
		}
	}
	
}