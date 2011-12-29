package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.GUI;

public class PreviousCardAction extends BaseAction
{

	private GUI gui_ = null;
	
	public PreviousCardAction(Component owner) {
		super(owner);
		gui_ = (GUI)owner;
		putValue(AbstractAction.NAME, "Voltar");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.gui_.processPreviousEvent();
	}
}
