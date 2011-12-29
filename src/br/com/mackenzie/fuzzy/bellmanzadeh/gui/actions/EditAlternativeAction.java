package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class EditAlternativeAction extends AddAlternativeAction {

	private AddAlternativePanel panel_;
	private JDialog  dialog_;
	private MackTable table_;
	
	public EditAlternativeAction(Component owner, JDialog dialog, MackTable table) {
		super(owner);
		panel_ = (AddAlternativePanel)this.getOwner();
		dialog_ = dialog;
		table_ = table;
		putValue(AbstractAction.NAME, "Salvar");
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
			table_.updateRow(table_.getSelectedRow(), row);
			dialog_.setVisible(false);
		}
	}
	
}