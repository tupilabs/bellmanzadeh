package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddObjectiveOrConstraintPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class AddObjectiveOrConstraintAction  extends BaseAction {

	private AddObjectiveOrConstraintPanel panel_;
	private JDialog  dialog_;
	
	public AddObjectiveOrConstraintAction(Component owner, JDialog dialog) {
		super(owner);
		panel_ = (AddObjectiveOrConstraintPanel)this.getOwner();
		dialog_ = dialog;
		putValue(AbstractAction.NAME, "Adicionar");
	}
	
	public void actionPerformed(ActionEvent e) {
		String description = panel_.getDescriptionTextField().getText();
		Object alternative = panel_.getAlternativesComboBox().getSelectedItem();
		Object membership  = panel_.getMembershipFunction();
		if(alternative == null || (description == null || description.trim().equals("")) || (membership == null)) {
			JOptionPane.showMessageDialog(this.panel_, "Preencha corretamente os campos necessários", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			MackTable table = panel_.getTable();
			ArrayList row = new ArrayList();
			row.add(description);
			row.add(alternative);
			row.add(membership);
			table.addRow(row);
			dialog_.setVisible(false);
		}
	}
	
}