package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class ShowMembershipWizardDialogAction extends BaseAction{

	private JDialog dialog_;
	
	public ShowMembershipWizardDialogAction(Component owner, JDialog dialog) {
		super(owner);
		putValue(AbstractAction.SMALL_ICON, new ImageIcon(getClass().getClassLoader().getResource("images\\wizard.gif")));
		dialog_ = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.dialog_.setLocationRelativeTo(this.getOwner());
		this.dialog_.pack();
		this.dialog_.setVisible(true);
	}
	
}
