package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.AddMembershipFunctionAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.gui.actions.HideDialogAction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.DifferentialSigmoidalMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.GaussianBellShapedMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.GaussianMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.MembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.ProductSigmoidalMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.SShapedMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.SigmoidalMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.TrapezoidalMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.TriangularMembershipFunction;
import br.com.mackenzie.fuzzy.bellmanzadeh.mf.ZShapedMembershipFunction;

import com.jeta.forms.components.image.ImageComponent;
import com.jeta.forms.components.panel.FormPanel;

public class AddMembershipFunctionPanel extends FormPanel
{

	private JDialog dialog_;
	private JComboBox typeTextComboBox_;
	private JTextField parametersField_;
	private MembershipPanel panel_;
	private ImageComponent image_;

	public AddMembershipFunctionPanel(String fileName, MembershipPanel owner ,JDialog dialog)
	{
		super(fileName);
		this.dialog_ = dialog;
		this.panel_ = owner;
		this.typeTextComboBox_ = this.getComboBox("tipo.combobox");
		this.parametersField_ = this.getTextField("parametros.text");
		this.image_ = (ImageComponent)this.getComponentByName("image");
		buildButtons();
		buildCombobox();
	}

	private void buildCombobox()
	{
		this.typeTextComboBox_.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					MembershipFunction mf = (MembershipFunction)AddMembershipFunctionPanel.this.typeTextComboBox_.getSelectedItem();
					AddMembershipFunctionPanel.this.setImage(mf.getImage());
					AddMembershipFunctionPanel.this.repaint();
				}
			}
		});
		this.typeTextComboBox_.addItem(new TriangularMembershipFunction("images\\trimf.gif"));
		this.typeTextComboBox_.addItem(new TrapezoidalMembershipFunction("images\\trapmf.gif"));
		this.typeTextComboBox_.addItem(new GaussianMembershipFunction("images\\gaussmf.gif"));
		this.typeTextComboBox_.addItem(new GaussianBellShapedMembershipFunction("images\\gbellmf.gif"));
		this.typeTextComboBox_.addItem(new SigmoidalMembershipFunction("images\\sigmf.gif"));
		this.typeTextComboBox_.addItem(new DifferentialSigmoidalMembershipFunction("images\\dsigmf.gif"));
		this.typeTextComboBox_.addItem(new ProductSigmoidalMembershipFunction("images\\psigmf.gif"));
		this.typeTextComboBox_.addItem(new ZShapedMembershipFunction("images\\zmf.gif"));
		//this.typeTextComboBox_.addItem("PI-Shaped");
		this.typeTextComboBox_.addItem(new SShapedMembershipFunction("images\\smf.gif"));
	}

	private void buildButtons()
	{
		AbstractButton addButton = this.getButton("ok.btn");
		addButton.setAction(new AddMembershipFunctionAction(this, panel_, dialog_));

		AbstractButton cancelButton = this.getButton("cancelar.btn");
		cancelButton.setAction(new HideDialogAction(this, this.dialog_));
		
		//TODO
		//AbstractButton helpButton = this.getButton("ajuda.btn");
	}

	public JComboBox getTypeComboBox()
	{
		return this.typeTextComboBox_;
	}

	public JTextField getParametersTextBox()
	{
		return this.parametersField_;
	}
	
	public void setImage(ImageIcon image) {
		this.image_.setIcon(image);
		this.repaint();
	}

	public void updateComboBox(LinkedHashMap fields)
	{
		Set set = fields.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			Entry entry = (Entry)i.next();
			this.typeTextComboBox_.addItem(entry.getKey());
		}
	}

}
