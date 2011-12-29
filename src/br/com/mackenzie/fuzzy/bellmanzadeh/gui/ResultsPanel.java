package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.table.MackTable;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.ConfluenceVo;

import com.jeta.forms.components.panel.FormPanel;

public class ResultsPanel extends FormPanel{

	private MackTable confluenceTable_;
	private MackTable conjunctionTable_;
	private MackTable decisionTable_;
	
	private JFrame owner_;
	
	public ResultsPanel(String fileName, JFrame owner) {
		super(fileName);
		this.owner_ = owner;
		confluenceTable_  = (MackTable)this.getTable("confluencia.table");
		conjunctionTable_ = (MackTable)this.getTable("conjuncao.table");
		decisionTable_ 	  = (MackTable)this.getTable("decisao.table");
	}

	/**
	 * @return the confluenceTable_
	 */
	public MackTable getConfluenceTable()
	{
		return confluenceTable_;
	}

	/**
	 * @param confluenceTable the confluenceTable_ to set
	 */
	public void setConfluenceTable(MackTable confluenceTable)
	{
		this.confluenceTable_ = confluenceTable;
	}

	/**
	 * @return the conjunctionTable_
	 */
	public MackTable getConjunctionTable()
	{
		return conjunctionTable_;
	}

	/**
	 * @param conjunctionTable the conjunctionTable_ to set
	 */
	public void setConjunctionTable(MackTable conjunctionTable)
	{
		this.conjunctionTable_ = conjunctionTable;
	}

	/**
	 * @return the decisionTable_
	 */
	public MackTable getDecisionTable()
	{
		return decisionTable_;
	}

	/**
	 * @param decisionTable the decisionTable_ to set
	 */
	public void setDecisionTable(MackTable decisionTable)
	{
		this.decisionTable_ = decisionTable;
	}
	
	public JFrame getOwner() {
		return this.owner_;
	}
	
	public static void main(String[] args)
	{
		ResultsPanel rp = new ResultsPanel("ResultsPanel.jfrm", null);
		RunForm.runPanel(rp);
	}

	public void updateMembershipFunctions(String alternativeName, String key, String value) {
		ArrayList dataList = this.confluenceTable_.getDataList();
		Iterator  iterator = dataList.iterator();
		
		while(iterator.hasNext()) {
			ArrayList row = (ArrayList)iterator.next();
			for(int i = 1 ; i < this.confluenceTable_.getColumnCount(); ++i) {
				if(confluenceTable_.getColumnName(i).equals(alternativeName)) {
					ConfluenceVo vo = (ConfluenceVo)row.get(i);
					MembershipFunction mf = vo.getMf();
					mf.setX(Double.parseDouble(value));
					vo.setFinalValue(""+mf.compute());
					//System.out.println(alternativeName + "'s " + key + " membership = " + mf.compute());
				}
			}
		}
		
		this.repaint();
		//System.out.println("Update " + key + " value " + value + " for alternative " + alternativeName);
	}
}
