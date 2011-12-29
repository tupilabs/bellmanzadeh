package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.EditVariableAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.HideDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.VariablesTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.TypeVo;

import com.jeta.forms.components.panel.FormPanel;

public class EditVariablePanel extends FormPanel{

	private JTextField variabletextField_;
	private JComboBox  typeComboBox_;
	private JDialog    dialog_;
	private VariablesTable table_;
	
	public EditVariablePanel(String fileName, JDialog dialog, VariablesTable table) {
		super(fileName);
		this.dialog_ = dialog;
		this.table_  = table;
		variabletextField_ = this.getTextField("variable.text");
		buildComboBox();
		buildButtons();
	}

	private void buildComboBox() {
		typeComboBox_ = this.getComboBox("type.combobox");
		typeComboBox_.addItem(new TypeVo("Número Real", TypeVo.DOUBLE));
		typeComboBox_.addItem(new TypeVo("Número Inteiro", TypeVo.LONG));
		typeComboBox_.addItem(new TypeVo("Crisp (booleano)", TypeVo.BOOLEAN));
	}
	
	public void buildButtons() {
		AbstractButton editButton = this.getButton("add.btn");
		editButton.setAction(new EditVariableAction(this, this.dialog_, this.table_));
		
		AbstractButton cancelButton = this.getButton("cancel.btn");
		cancelButton.setAction(new HideDialogAction(this, this.dialog_));
	}
	
	public JComboBox getTypeComboBox()
	{
		return typeComboBox_;
	}

	public JTextField getVariabletextField()
	{
		return variabletextField_;
	}
	
	public VariablesTable getTable() {
		return this.table_;
	}
	
	public JDialog getDialog() {
		return this.dialog_;
	}
	
}