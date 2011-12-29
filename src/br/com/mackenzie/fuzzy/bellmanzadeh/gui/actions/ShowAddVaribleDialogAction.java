package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddVariablePanel;

public class ShowAddVaribleDialogAction extends BaseAction {

	private JDialog dialog_;
	private AddVariablePanel panel_;
	
	public ShowAddVaribleDialogAction(Component owner, JDialog dialog, AddVariablePanel panel) {
		super(owner);
		putValue(AbstractAction.NAME, "Adicionar");
		this.dialog_ = dialog;
		this.panel_  = panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		panel_.getVariabletextField().setText("");
		if(panel_.getTypeComboBox().getItemCount() >0)
			panel_.getTypeComboBox().setSelectedIndex(0);
		this.dialog_.pack();
		this.dialog_.setSize(350,120);
		this.dialog_.setLocationRelativeTo(this.getOwner());
		this.dialog_.setVisible(true);
	}	
}