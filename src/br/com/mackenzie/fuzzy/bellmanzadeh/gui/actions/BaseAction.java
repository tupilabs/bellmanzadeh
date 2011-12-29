package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;

import javax.swing.AbstractAction;

public abstract class BaseAction extends AbstractAction{

	private Component owner_;
	
	public BaseAction(Component owner) {
		this.owner_ = owner;
	}
	
	public Component getOwner() {
		return this.owner_;
	}
	
	public void setComponent(Component owner) {
		this.owner_ = owner;
	}
	
}
