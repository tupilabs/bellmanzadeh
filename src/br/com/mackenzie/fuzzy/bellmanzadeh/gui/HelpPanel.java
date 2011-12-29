package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import com.jeta.forms.components.panel.FormPanel;

public class HelpPanel extends FormPanel{

	private Component owner_ ;
	
	public HelpPanel(String file, Component owner) {
		super(file);
		this.owner_ = owner;
		buildCloseButton();
	}
	
	private void buildCloseButton() {
		AbstractButton button = this.getButton("close.btn");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				owner_.setVisible(false);
			}
		});
	}
	
}
