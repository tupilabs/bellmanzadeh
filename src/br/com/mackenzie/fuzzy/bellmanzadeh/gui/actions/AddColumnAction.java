package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.AddColumnPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;

public class AddColumnAction extends BaseAction{
	
	private MackTable table_;
	private AddColumnPanel panel_;
	private JDialog addColumnDialog_;
	
	public AddColumnAction(Component owner) {
		super(owner);
		this.putValue(AbstractAction.NAME, "Adicionar coluna");
		getAddColumnPanel();
	}
	
	private void getAddColumnPanel() {
		if(panel_ == null) {
			panel_ = new AddColumnPanel("AddColumnPanel.jfrm");
			addColumnDialog_ = buildAddColumnDialog();
		}
	}

	private JDialog buildAddColumnDialog() {
		//return new JDialog(Main.getInstance());
		return null;
	}

	public AddColumnAction(Component owner, MackTable table) {
		this(owner);
		this.table_ = table;
	}
	
	public MackTable getTable() {
		return table_;
	}

	public void setTable(MackTable table) {
		this.table_ = table;
	}

	public void actionPerformed(ActionEvent e) {
		if(this.table_ != null) {
			addColumnDialog_.pack();
			addColumnDialog_.setLocationRelativeTo(this.getOwner());
			addColumnDialog_.setVisible(true);
		}
	}	
}
