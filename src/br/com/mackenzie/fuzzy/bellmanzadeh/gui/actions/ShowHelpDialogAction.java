package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;


public class ShowHelpDialogAction extends BaseAction{

	private JDialog dialog_;
	
	public ShowHelpDialogAction(Component owner, JDialog dialog) {
		super(owner);
		putValue(AbstractAction.NAME, "Ajuda");
		dialog_ = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.dialog_.setLocationRelativeTo(this.getOwner());
		this.dialog_.setVisible(true);
	}
	
}
