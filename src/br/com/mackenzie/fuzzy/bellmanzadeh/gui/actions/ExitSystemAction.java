package br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import br.com.mackenzie.fuzzy.bellmanzadeh.Main;

public class ExitSystemAction extends BaseAction{

	public ExitSystemAction(Component owner) {
		super(owner);
		putValue(AbstractAction.NAME, "Sair");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(Main.getInstance().getMainFrame(), "Confirmar saída?", "Confirme", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
			System.exit(1);	
		}	
	}	
}
