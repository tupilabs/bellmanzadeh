package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddAlternativeDialogPanel;

public class ShowAddAlternativeDialogAction extends BaseAction {

	private JDialog dialog_;
	private AddAlternativeDialogPanel panel_;
	private Action addAction;
	
	public ShowAddAlternativeDialogAction(Component owner, JDialog dialog, AddAlternativeDialogPanel panel) {
		super(owner);
		putValue(AbstractAction.NAME, "Adicionar");
		this.dialog_ = dialog;
		this.panel_  = panel;
		this.addAction = panel_.getAddButton().getAction();
	}
	
	public void actionPerformed(ActionEvent e) {
		/*panel_.getVariabletextField().setText("");
		if(panel_.getTypeComboBox().getItemCount() >0)
			panel_.getTypeComboBox().setSelectedIndex(0);*/
		//TODO esvaziar painel
		panel_.getAddButton().setAction(addAction);
		
		LinkedHashMap fields = panel_.getAddAlternativePanel().getFields();
		Set set = fields.entrySet();
		
		Object component = null;
		Entry  entry     = null;
		for(Iterator iter = set.iterator(); iter.hasNext() ; ) {
			entry = (Entry)iter.next();
			component = entry.getValue();
			if(component instanceof JComboBox) {
				((JComboBox)component).setSelectedIndex(0);
			} else {
				((JTextField)component).setText("");
			}
		}
		
		this.dialog_.pack();
		this.dialog_.setSize(350,350);
		this.dialog_.setLocationRelativeTo(this.getOwner());
		this.dialog_.setVisible(true);
	}	
}