package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import com.jeta.forms.components.panel.FormPanel;

import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;

public abstract class MembershipPanel extends FormPanel
{

	public MembershipPanel(String fileName) {
		super(fileName);
	}
	
	private MembershipFunction mf;
	
	public void updateTextField(MembershipFunction mf) {
		this.mf = mf;		
	}
	
	public MembershipFunction getMembershipFunction() {
		return this.mf;
	}
	
	public void setMembershipFunction(MembershipFunction mf) {
		this.mf = mf;
	}
	
}
