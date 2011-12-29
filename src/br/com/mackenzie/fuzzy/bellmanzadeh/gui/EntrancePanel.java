package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.RemoveObjectiveOrConstraintAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowAddVaribleDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowEditVariableDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.VariablesTable;

import com.jeta.forms.components.panel.FormPanel;

public class EntrancePanel extends FormPanel{

	private VariablesTable variablesTable_;
	private JDialog        addVariableDialog_;
	private JDialog 	   editVariableDialog_;
	private AddVariablePanel addVariabelPanel_;
	private EditVariablePanel editVariablePanel_;
	private JFrame owner_;
	
	public EntrancePanel(String fileName, JFrame owner) {
		super(fileName);
		this.owner_ = owner;
		this.variablesTable_ = (VariablesTable)this.getTable("alt.table");
		buildButtons();
	}

	private void buildButtons() {
		AbstractButton addButton = this.getButton("add.btn");
		addVariableDialog_ = new JDialog(this.owner_, "Adicionar",  true);
		addVariabelPanel_ = new AddVariablePanel("AddVariable.jfrm", addVariableDialog_, variablesTable_);
		addVariableDialog_.setContentPane(addVariabelPanel_);
		addVariableDialog_.pack();
		addButton.setAction(new ShowAddVaribleDialogAction(this, addVariableDialog_, addVariabelPanel_));
		
		AbstractButton editButton = this.getButton("edt.btn");
		editVariableDialog_ = new JDialog(this.owner_, "Editar",  true);
		editVariablePanel_ = new EditVariablePanel("AddVariable.jfrm", editVariableDialog_, variablesTable_);
		editVariableDialog_.setContentPane(editVariablePanel_);
		editVariableDialog_.pack();
		editButton.setAction(new ShowEditVariableDialogAction(editVariablePanel_, this.editVariableDialog_));
		
		AbstractButton removeButton = this.getButton("rem.btn");
		removeButton.setAction(new RemoveObjectiveOrConstraintAction(this, variablesTable_));
	}
	
	public MackTable getTable() {
		return this.variablesTable_;
	}
	
}