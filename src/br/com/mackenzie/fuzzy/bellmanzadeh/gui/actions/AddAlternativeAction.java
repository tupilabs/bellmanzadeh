package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddAlternativePanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.AlternativesTable;

public class AddAlternativeAction extends BaseAction {

	private AddAlternativePanel panel_;
	private JDialog  dialog_;
	private AlternativesTable table_;
	
	public AddAlternativeAction(Component owner, JDialog dialog, AlternativesTable table) {
		super(owner);
		panel_  = (AddAlternativePanel)this.getOwner();
		dialog_ = dialog;
		table_  = table;
		putValue(AbstractAction.NAME, "Adicionar");
	}
	
	public AddAlternativeAction(Component owner) {
		super(owner);
	}
	
	public void actionPerformed(ActionEvent e) {
		LinkedHashMap fields = panel_.getFields();
		if( !checkFields(fields) ) {
			JOptionPane.showMessageDialog(this.panel_, "Preencha corretamente os campos necessários", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			ArrayList row = new ArrayList();
			Set set = fields.entrySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				Entry entry = (Entry)iter.next();
				Object value= entry.getValue();
				if(value instanceof JComboBox) {
					row.add(  ((JComboBox)value).getSelectedItem().toString() );
				} else {
					row.add(  ((JTextField)value).getText() );
				}						
			}
			table_.addRow(row);
			dialog_.setVisible(false);
		}
	}

	protected boolean checkFields(HashMap alternatives)
	{
/*		Set set = alternatives.entrySet();
		Iterator iter = set.iterator();*/
		return true;
	}
	
}