package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.AddAlternativeAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.HideDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.AlternativesTable;

import com.jeta.forms.components.panel.FormPanel;

public class AddAlternativeDialogPanel extends FormPanel{

	private JFrame owner_;
	private JDialog dialog_;
	private AddAlternativePanel panel_;
	private AlternativesTable table_;
	private AbstractButton addButton_ = null;
	private AbstractButton cancelButton_ = null;
	
	public AddAlternativeDialogPanel(String filename, JFrame owner, JDialog dialog, AlternativesTable table) {
		super(filename);
		owner_ = owner;
		dialog_ = dialog;
		table_ = table;
		panel_ = (AddAlternativePanel)this.getComponentByName("add.alternative.panel");
		buildButtons();
	}

	private void buildButtons()	{
		addButton_ = this.getButton("add.btn");
		addButton_.setAction(new AddAlternativeAction(panel_, dialog_, table_));
		
		cancelButton_ = this.getButton("cancel.btn");
		cancelButton_.setAction(new HideDialogAction(this.owner_, this.dialog_));
	}	
	
	public AddAlternativePanel getAddAlternativePanel() {
		return this.panel_;
	}

	/**
	 * @return the addButton_
	 */
	public AbstractButton getAddButton()
	{
		return addButton_;
	}

	/**
	 * @param addButton the addButton_ to set
	 */
	public void setAddButton(AbstractButton addButton)
	{
		this.addButton_ = addButton;
	}

	/**
	 * @return the cancelButton_
	 */
	public AbstractButton getCancelButton()
	{
		return cancelButton_;
	}

	/**
	 * @param cancelButton the cancelButton_ to set
	 */
	public void setCancelButton(AbstractButton cancelButton)
	{
		this.cancelButton_ = cancelButton;
	}
	
}