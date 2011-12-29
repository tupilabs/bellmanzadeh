package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddObjectiveOrConstraintPanel;

public class ShowAddObjectiveOrConstraintDialogAction extends BaseAction {

	private JDialog dialog_;
	private AddObjectiveOrConstraintPanel panel_;
	
	public ShowAddObjectiveOrConstraintDialogAction(Component owner, JDialog dialog, AddObjectiveOrConstraintPanel panel) {
		super(owner);
		putValue(AbstractAction.NAME, "Adicionar");
		this.dialog_ = dialog;
		this.panel_  = panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		panel_.getDescriptionTextField().setText("");
		panel_.getMembershipTextField().setText("");
		this.dialog_.setLocationRelativeTo(this.getOwner());
		this.dialog_.setVisible(true);
	}	
}
