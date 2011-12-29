package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.EditObjectiveOrConstraintPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class ShowEditObjectiveOrConstraintDialogAction extends BaseAction {

	private JDialog dialog_;
	private EditObjectiveOrConstraintPanel panel_;
	
	public ShowEditObjectiveOrConstraintDialogAction(Component owner, JDialog dialog) {
		super(owner);
		putValue(AbstractAction.NAME, "Editar");
		this.dialog_ = dialog;
		this.panel_  = (EditObjectiveOrConstraintPanel)owner;
	}
	
	public void actionPerformed(ActionEvent e) {
		MackTable table = panel_.getTable();
		if(table.getSelectedRow() >= 0) {
			ArrayList row = table.getRow(table.getSelectedRow());
			panel_.getDescriptionTextField().setText(row.get(0).toString());
			String alternative = (String)row.get(1);
			for(int i = 0 ; i < panel_.getAlternativesComboBox().getItemCount(); ++i) {
				if(alternative.equalsIgnoreCase(panel_.getAlternativesComboBox().getItemAt(i).toString())) {
					panel_.getAlternativesComboBox().setSelectedIndex(i);
					break;
				}
			}
			panel_.getMembershipTextField().setText(row.get(2).toString());
			this.dialog_.setLocationRelativeTo(this.getOwner());
			this.dialog_.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this.getOwner(), "Não há linhas selecionadas para editar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}	
}