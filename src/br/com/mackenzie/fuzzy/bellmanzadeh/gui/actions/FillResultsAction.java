package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.MainPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.ResultsPanel;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.ConfluenceVo;

public class FillResultsAction extends BaseAction
{

	private MainPanel mainPanel_;
	private ResultsPanel resultsPanel_;
	
	private MackTable alternativesTable_;
	private MackTable objectivesTable_;
	private MackTable constraintsTable_;
	
	public FillResultsAction(MainPanel mainPanel, ResultsPanel resultsPanel){
		super(null);
		mainPanel_ = mainPanel;
		resultsPanel_ = resultsPanel;
		alternativesTable_ = mainPanel_.getAlternativesTable();
		objectivesTable_   = mainPanel_.getObjectivesTable();
		constraintsTable_  = mainPanel_.getConstraintsTable();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		buildConfluenceTable();		
	}
	
	private void buildConfluenceTable () {
        // coluna vazia
		resultsPanel_.getConfluenceTable().addColumn(" "); // alternativas e objetivos e restrições
		
		ArrayList alternativesDataList = alternativesTable_.getDataList();
		Iterator  alternativesIterator = alternativesDataList.iterator();
	
		// para cada alternativa 
		while(alternativesIterator.hasNext()) {
			ArrayList alternativeRow = (ArrayList)alternativesIterator.next();
			// crio uma coluna com o nome da descrição da alternativa
			resultsPanel_.getConfluenceTable().addColumn(alternativeRow.get(0).toString());
		}
		
		ArrayList objectivesDataList = objectivesTable_.getDataList();
		Iterator objectivesIterator = objectivesDataList.iterator();
		
		// para cada objetivo
		while(objectivesIterator.hasNext()){
			ArrayList objectiveRow = (ArrayList)objectivesIterator.next();
			ArrayList newRow = new ArrayList();
			newRow.add(objectiveRow.get(0).toString());
			for(int i = 1 ; i < resultsPanel_.getConfluenceTable().getColumnCount(); ++i) {
				newRow.add( new ConfluenceVo( objectiveRow.get(1).toString(), (MembershipFunction)objectiveRow.get(2) ) );
				//newRow.add(objectiveRow.get(2));
			}
			resultsPanel_.getConfluenceTable().addRow(newRow);
		}
		
		ArrayList constraintsDataList = constraintsTable_.getDataList();
		Iterator constraintsIterator = constraintsDataList.iterator();
		
		// e para cada restrição
		while(constraintsIterator.hasNext()){
			ArrayList constraintRow = (ArrayList)constraintsIterator.next();
			ArrayList newRow = new ArrayList();
			newRow.add(constraintRow.get(0).toString());
			for(int i = 1 ; i < resultsPanel_.getConfluenceTable().getColumnCount(); ++i) {
				newRow.add( new ConfluenceVo( constraintRow.get(1).toString(), (MembershipFunction)constraintRow.get(2) ) );
				//newRow.add(constraintRow.get(2));
			}
			resultsPanel_.getConfluenceTable().addRow(newRow);
		}
		
		// por fim, para cada alternativa atualizo os valores
		alternativesIterator = alternativesDataList.iterator();
		// para cada alternativa 
		while(alternativesIterator.hasNext()) {
			ArrayList alternativeRow = (ArrayList)alternativesIterator.next();
			for(int i = 1; i < alternativesTable_.getColumnCount();++i) {
				String key = alternativesTable_.getColumnName(i);
				resultsPanel_.updateMembershipFunctions(""+alternativeRow.get(0), key, ""+alternativeRow.get(i));
			}
		}
	}
	
	public MainPanel getMainPanel() {
		return this.mainPanel_;
	}
	
	public ResultsPanel getResultsPanel() {
		return this.resultsPanel_;
	}

	/**
	 * @return the alternativesTable_
	 */
	public MackTable getAlternativesTable()
	{
		return alternativesTable_;
	}

	/**
	 * @return the constraintsTable_
	 */
	public MackTable getConstraintsTable()
	{
		return constraintsTable_;
	}

	/**
	 * @return the objectivesTable_
	 */
	public MackTable getObjectivesTable()
	{
		return objectivesTable_;
	}
	
}
