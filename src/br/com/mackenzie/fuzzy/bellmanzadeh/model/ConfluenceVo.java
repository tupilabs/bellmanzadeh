package br.com.mackenzie.fuzzy.bellmanzadeh.model;

import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;

public class ConfluenceVo {

	private MembershipFunction mf_;

	private String variableName_;
	
	private String finalValue_;

	public ConfluenceVo() {
		super();
	}

	public ConfluenceVo(String variableName, MembershipFunction mf) {
		super();
		this.variableName_ = variableName;
		this.mf_ = mf;
	}

	public MembershipFunction getMf() {
		return mf_;
	}

	public String getVariableName() {
		return variableName_;
	}

	public void setMf(MembershipFunction mf) {
		this.mf_ = mf;
	}

	public void setVariableName(String variableName) {
		this.variableName_ = variableName;
	}
	
	public String toString() {
		if(this.finalValue_!= null)
			return this.finalValue_;
		return this.variableName_;
	}

	public String getFinalValue() {
		return finalValue_;
	}

	public void setFinalValue(String finalValue) {
		this.finalValue_ = finalValue;
	}

	
	
}
