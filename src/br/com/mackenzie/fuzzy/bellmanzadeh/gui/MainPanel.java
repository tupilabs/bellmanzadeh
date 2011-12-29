package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.RemoveObjectiveOrConstraintAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowAddAlternativeDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowAddObjectiveOrConstraintDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowEditAlternativeAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowEditObjectiveOrConstraintDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.AlternativesTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.AlternativeVo;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.TypeVo;

import com.jeta.forms.components.panel.FormPanel;

public class MainPanel extends FormPanel{

	// panels
	private FormPanel addObjectivePanel_;
	private FormPanel addConstraintPanel_;
	private FormPanel editObjectivePanel_;
	private FormPanel editConstraintPanel_;
	private AddAlternativeDialogPanel addAlternativesDialogPanel_;
	// dialogs
	private JDialog   addAlternativeDialog_;
	private JDialog	  addObjectiveDialog_;
	private JDialog   addConstraintDialog_;
	//private JDialog   editAlternativeDialog_;
	private JDialog   editObjectiveDialog_;
	private JDialog   editConstraintDialog_;
	// frame container
	private JFrame    owner_;
	// tables
	private AlternativesTable alternativesTable_;
	private MackTable objectivesTable_;
	private MackTable constraintsTable_;
	//actions for alternatives
	
	private ArrayList variables_ = null;
	
	public MainPanel(String filename, JFrame owner) {
		super(filename);
		this.owner_ = owner;
		this.buildPanel();
	}

	private void buildPanel() {
		buildTables();
		buildAlternativesButtons();
		buildObjectivesButtons();
		buildConstraintsButtons();
	}
	
	private void buildTables() {
		alternativesTable_ 	= (AlternativesTable)this.getTable("alternatives.table");
		objectivesTable_ 	= (MackTable)this.getTable("objectives.table");
		constraintsTable_ 	= (MackTable)this.getTable("constraints.table");
	}
	
	public void buildAlternativesTable(ArrayList dataList) {
		Iterator iterator = dataList.iterator();
		
		while(iterator.hasNext()) {
			ArrayList row = (ArrayList)iterator.next();
			this.alternativesTable_.addVariableColumn(row);
		}
		
		this.repaint();
	}
	
	public MackTable getAlternativesTable() {
		return alternativesTable_;
	}

	public MackTable getConstraintsTable() {
		return constraintsTable_;
	}

	public MackTable getObjectivesTable() {
		return objectivesTable_;
	}
	
	private void buildAlternativesButtons()
	{
		AbstractButton addButton = this.getButton("alt.add.btn");
		addButton.setAction(new ShowAddAlternativeDialogAction(this, getAddAlternativeDialog(), getAddAlternativeDialogPanel()));
		
		AbstractButton editButton = this.getButton("alt.edt.btn");
		editButton.setAction(new ShowEditAlternativeAction(this, addAlternativeDialog_, addAlternativesDialogPanel_, alternativesTable_));
		
		AbstractButton removeButton = this.getButton("alt.rem.btn");
		removeButton.setAction(new RemoveObjectiveOrConstraintAction(this, alternativesTable_));
	}
	
	private void buildObjectivesButtons() {
		AbstractButton addButton = this.getButton("obj.add.btn");
		addObjectiveDialog_ = new JDialog(this.owner_, "Adicionar objetivo",  true);
		addObjectivePanel_ = new AddObjectiveOrConstraintPanel("AddPanel.jfrm", addObjectiveDialog_, objectivesTable_, owner_);
		addObjectiveDialog_.setContentPane(addObjectivePanel_);
		addObjectiveDialog_.pack();
		addButton.setAction(new ShowAddObjectiveOrConstraintDialogAction(this, addObjectiveDialog_, (AddObjectiveOrConstraintPanel)addObjectivePanel_));
		
		AbstractButton editButton = this.getButton("obj.edt.btn");
		editObjectiveDialog_ = new JDialog(this.owner_, "Editar objetivo",  true);
		editObjectivePanel_ = new EditObjectiveOrConstraintPanel("AddPanel.jfrm", editObjectiveDialog_, objectivesTable_, owner_);
		editObjectiveDialog_.setContentPane(editObjectivePanel_);
		editObjectiveDialog_.pack();
		editButton.setAction(new ShowEditObjectiveOrConstraintDialogAction(editObjectivePanel_, editObjectiveDialog_));
		
		AbstractButton removeButton = this.getButton("obj.rem.btn");
		removeButton.setAction(new RemoveObjectiveOrConstraintAction(this, objectivesTable_));
	}
	
	private void buildConstraintsButtons() {
		AbstractButton addButton = this.getButton("con.add.btn");
		addConstraintDialog_ = new JDialog(this.owner_, "Adicionar restrição",  true);
		addConstraintPanel_ = new AddObjectiveOrConstraintPanel("AddPanel.jfrm", addConstraintDialog_, constraintsTable_, owner_);
		addConstraintDialog_.setContentPane(addConstraintPanel_);
		addConstraintDialog_.pack();
		addButton.setAction(new ShowAddObjectiveOrConstraintDialogAction(this, addConstraintDialog_, (AddObjectiveOrConstraintPanel)addConstraintPanel_));
		
		AbstractButton editButton = this.getButton("con.edt.btn");
		editConstraintDialog_ = new JDialog(this.owner_, "Editar restrição",  true);
		editConstraintPanel_ = new EditObjectiveOrConstraintPanel("AddPanel.jfrm", editConstraintDialog_, constraintsTable_, owner_);
		editConstraintDialog_.setContentPane(editConstraintPanel_);
		editConstraintDialog_.pack();
		editButton.setAction(new ShowEditObjectiveOrConstraintDialogAction(editConstraintPanel_, editConstraintDialog_));
		
		AbstractButton removeButton = this.getButton("con.rem.btn");
		removeButton.setAction(new RemoveObjectiveOrConstraintAction(this, constraintsTable_));
	}
	
	/* GUI methods */
		
	private JDialog getAddAlternativeDialog()
	{
		if(addAlternativeDialog_ == null) {
			addAlternativeDialog_ = new JDialog(this.owner_, "Adicionar alternativa",  true);
			addAlternativeDialog_.setContentPane(getAddAlternativeDialogPanel());
			addAlternativeDialog_.pack();
		}
		return addAlternativeDialog_;
	}
	
	private AddAlternativeDialogPanel getAddAlternativeDialogPanel(){
		if(addAlternativesDialogPanel_ == null ) {
			addAlternativesDialogPanel_ = new AddAlternativeDialogPanel("AddAlternativeDialogPanel.jfrm", this.owner_, getAddAlternativeDialog(), alternativesTable_);
		}
		return addAlternativesDialogPanel_;
	}

	public void buildAlternativesAddForm(ArrayList dataList){
		this.variables_ = dataList;
		Iterator iterator = dataList.iterator();
		TypeVo type = new TypeVo("Texto", TypeVo.STRING);
		AlternativeVo alternativeVo = new AlternativeVo("Descrição", type);
		getAddAlternativeDialogPanel().getAddAlternativePanel().addAlternative(alternativeVo);
		
		while(iterator.hasNext()) {
			ArrayList row = (ArrayList)iterator.next();
			alternativeVo = new AlternativeVo();
			TypeVo typeVo = (TypeVo)row.get(1);
			
			alternativeVo.setName(row.get(0).toString());
			alternativeVo.setType(typeVo);
			
			getAddAlternativeDialogPanel().getAddAlternativePanel().addAlternative(alternativeVo);
		}
		
		this.repaint();
	}
	
	public ArrayList getVariables() {
		return this.variables_;
	}

	public void clearAlternativesAddForm()
	{
		getAddAlternativeDialogPanel().getAddAlternativePanel().clearPanel();
	}

	public void updateAlternativesComboBox(){
		LinkedHashMap fields = addAlternativesDialogPanel_.getAddAlternativePanel().getFields();
		((AddObjectiveOrConstraintPanel)addObjectivePanel_).updateComboBox(fields);
		((AddObjectiveOrConstraintPanel)addConstraintPanel_).updateComboBox(fields);
		((EditObjectiveOrConstraintPanel)editObjectivePanel_).updateComboBox(fields);
		((EditObjectiveOrConstraintPanel)editConstraintPanel_).updateComboBox(fields);
	}

	public void clearComboBox(){
		((AddObjectiveOrConstraintPanel)addObjectivePanel_).getAlternativesComboBox().removeAllItems();
		((AddObjectiveOrConstraintPanel)addConstraintPanel_).getAlternativesComboBox().removeAllItems();
		((EditObjectiveOrConstraintPanel)editObjectivePanel_).getAlternativesComboBox().removeAllItems();
		((EditObjectiveOrConstraintPanel)editConstraintPanel_).getAlternativesComboBox().removeAllItems();
	}

	public void clearTables()
	{
		this.clearAlternativesTable();
		this.clearObjectivesTable();
		this.clearConstraintsTable();
	}

	public void clearAlternativesTable() {
		this.alternativesTable_.clear();
		this.alternativesTable_.buildColumns();
		this.owner_.repaint();
	}
	
	public void clearObjectivesTable() {
		this.objectivesTable_.clearData();
		//this.objectivesTable_.buildColumns();
		this.owner_.repaint();
	}
	
	public void clearConstraintsTable() {
		this.constraintsTable_.clearData();
		//this.constraintsTable_.buildColumns();
		this.owner_.repaint();
	}
}
