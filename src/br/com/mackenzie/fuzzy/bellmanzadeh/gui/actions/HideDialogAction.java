package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

public class HideDialogAction extends BaseAction {

	private JDialog dialog_;
	
	public HideDialogAction(Component owner, JDialog dialog) {
		super(owner);
		putValue(AbstractAction.NAME, "Cancelar");
		this.dialog_ = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.dialog_.isVisible())
			this.dialog_.setVisible(false);
	}
	
}
