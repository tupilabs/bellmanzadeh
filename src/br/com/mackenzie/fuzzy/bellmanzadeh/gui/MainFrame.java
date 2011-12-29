package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import javax.swing.JFrame;

import com.jeta.forms.components.panel.FormPanel;

public class MainFrame extends JFrame{

//	 Componentes
	//private FormPanel mainPanel_;
	private FormPanel GUI_;
	
	public MainFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*this.mainPanel_ = new MainPanel("MainPanel.jfrm", this);
		this.setContentPane(mainPanel_);*/
		this.GUI_ = new GUI("GUI.jfrm", this);
		this.setContentPane(this.GUI_);
	}
	
	public MainFrame() {
		this("");
	}
	
	public void showIt() {
		this.pack();
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
