package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ExitSystemAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.FillResultsAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.NextCardAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.PreviousCardAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.ShowHelpDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.cardpanel.CardPanel;

import com.jeta.forms.components.panel.FormPanel;

public class GUI extends FormPanel
{
	//http://java.sun.com/products/jfc/tsc/articles/cardpanel/index.html
	private CardPanel cardPanel_ = null;
	private JDialog   helpDialog_;
	private FormPanel helpPanel_;
	private JFrame    owner_;
	// card panels
	private EntrancePanel entrancePanel_;
	private MainPanel mainPanel_;
	private ResultsPanel resultsPanel_;
	private int cardIndex_;
	private AbstractButton nextButton_;
	private AbstractButton previousButton_;

	public GUI(String fileName, JFrame owner) {
		super(fileName);
		this.owner_ = owner;
		buildPanels();
		buildButtons();
		this.cardPanel_.showCard("entrance");
		this.cardIndex_ = 0;
		this.previousButton_.setEnabled(false);
	}

	private void buildPanels() {
		this.cardPanel_ = (CardPanel)this.getPanel("card.panel");
		this.entrancePanel_ = new EntrancePanel("EntrancePanel.jfrm", this.owner_);
		this.mainPanel_ = new MainPanel("MainPanel.jfrm", this.owner_);
		this.resultsPanel_ = new ResultsPanel("ResultsPanel.jfrm", this.owner_);
		this.cardPanel_.add(this.entrancePanel_, "entrance");
		this.cardPanel_.add(this.mainPanel_, "main");
		this.cardPanel_.add(this.resultsPanel_, "results");
	}
	
	private void buildButtons() {
		buildControlButtons();
		buildHelpButton();
		buildExitButton();
	}

	private void buildControlButtons() {
		nextButton_ = this.getButton("next.btn");
		nextButton_.setAction(new NextCardAction(this));
		previousButton_ = this.getButton("previous.btn");
		previousButton_.setAction(new PreviousCardAction(this));
	}
	
	private void buildHelpButton(){
		AbstractButton addButton = this.getButton("help.btn");
		helpDialog_ = new JDialog(this.owner_, true);
		helpPanel_ = new HelpPanel("HelpPanel.jfrm", helpDialog_);
		helpDialog_.setContentPane(helpPanel_);
		helpDialog_.pack();
		addButton.setAction(new ShowHelpDialogAction(this, helpDialog_));
	}

	private void buildExitButton(){
		AbstractButton button = this.getButton("exit.btn");
		button.setAction(new ExitSystemAction(button));
	}
	
	public void processNextEvent() {
		if(this.cardIndex_ == 0) {
			this.cardIndex_++;
			this.previousButton_.setEnabled(true);
			this.nextButton_.setText("Avançar");
			mainPanel_.buildAlternativesTable(this.entrancePanel_.getTable().getDataList());
			mainPanel_.buildAlternativesAddForm(this.entrancePanel_.getTable().getDataList());
			mainPanel_.updateAlternativesComboBox();
			this.cardPanel_.showCard("main");
		} else if(this.cardIndex_ == 1) { 
			this.cardIndex_++;
			FillResultsAction action = new FillResultsAction(this.mainPanel_, this.resultsPanel_);
			action.actionPerformed(null);
			this.cardPanel_.showCard("results");
		}
	}
	
	public void processPreviousEvent() {
		if(this.cardIndex_ == 1) {
			this.cardIndex_--;
			this.previousButton_.setEnabled(false);
			this.nextButton_.setText("Avançar");
			this.mainPanel_.clearTables();
			this.mainPanel_.clearAlternativesAddForm();
			this.mainPanel_.clearComboBox();
			this.cardPanel_.showCard("entrance");
		}
	}
}
