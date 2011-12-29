package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddMembershipFunctionPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.MembershipPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.util.MembershipFunctionHelper;

public class AddMembershipFunctionAction  extends BaseAction {

	private AddMembershipFunctionPanel panel_;
	private MembershipPanel destinationPanel_;
	private JDialog  dialog_;
	
	public AddMembershipFunctionAction(Component owner, MembershipPanel destinationPanel, JDialog dialog) {
		super(owner);
		panel_ = (AddMembershipFunctionPanel)this.getOwner();
		destinationPanel_ = destinationPanel;
		dialog_ = dialog;
		putValue(AbstractAction.NAME, "Adicionar");
	}
	
	public void actionPerformed(ActionEvent e) {
		MembershipFunction mf = (MembershipFunction)panel_.getTypeComboBox().getSelectedItem();
		String parameters = panel_.getParametersTextBox().getText();
		double[] dParameters = MembershipFunctionHelper.parseParameters(parameters);
		mf.setParameters(dParameters);
		
		if(mf == null || (parameters == null || parameters.trim().equals(""))) {
			JOptionPane.showMessageDialog(this.panel_, "Preencha corretamente os campos necessários", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			destinationPanel_.updateTextField(mf);
			dialog_.setVisible(false);
		}
	}
	
}
