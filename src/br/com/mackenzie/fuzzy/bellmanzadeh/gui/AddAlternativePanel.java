package br.com.mackenzie.fuzzy.bellmanzadeh.gui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.mackenzie.fuzzy.bellmanzadeh.RunForm;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.AlternativeVo;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.CrispVo;
import br.com.mackenzie.fuzzy.bellmanzadeh.model.TypeVo;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class AddAlternativePanel extends JPanel
{

	private DefaultFormBuilder builder = null;
	private LinkedHashMap	   fields = new LinkedHashMap();
	private LinkedHashMap      labels = new LinkedHashMap();
	private JComboBox  		   crispComboBox_;
	
	public AddAlternativePanel () {
		super();
		buildEmptyPanel();
		/*addAlternative(new AlternativeVo("Teste", new TypeVo("Domjeorp", TypeVo.DOUBLE)));
		addAlternative(new AlternativeVo("Teste", new TypeVo("Domjeorp", TypeVo.DOUBLE)));
		addAlternative(new AlternativeVo("Teste", new TypeVo("Domjeorp", TypeVo.DOUBLE)));
		addAlternative(new AlternativeVo("Teste", new TypeVo("Domjeorp", TypeVo.DOUBLE)));
		addAlternative(new AlternativeVo("Teste", new TypeVo("Domjeorp", TypeVo.DOUBLE)));*/
	}
	
	public JComboBox getCrispComboBox() {
		if( crispComboBox_ == null ) {
			crispComboBox_ = new JComboBox();
			crispComboBox_.addItem(new CrispVo(true, "Verdadeiro"));
			crispComboBox_.addItem(new CrispVo(false, "Falso"));
		}
		return crispComboBox_;
	}
	
	private void buildEmptyPanel() {
		buildPanel("right:pref:grow, 7dlu, left:pref:grow, 7dlu", "pref");
	}
	
	public void buildPanel(String cols, String rows) {
		FormLayout layout = new FormLayout(
			 /*"right:max(40dlu;pref), 3dlu, 90dlu, 7dlu, " +
			 "right:max(40dlu;pref), 3dlu, 90dlu"*/
				cols,
				rows
		);
		
		builder = new DefaultFormBuilder(layout, this);
		builder.setDefaultDialogBorder();
		builder.setRowGroupingEnabled(true);
	}
	
	public void addAlternative(AlternativeVo vo) {
		final TypeVo type = vo.getType();
		
		final JComponent component = getComponent(type);
		
		labels.put(vo.getName(), builder.append(vo.getName(), component));
		builder.nextLine();
		fields.put(vo.getName(), component);
	}
	
	public JComponent getComponent(TypeVo vo) {
		if(vo.getType() == TypeVo.BOOLEAN) {
			return getCrispComboBox();
		} else if(vo.getType() == TypeVo.DOUBLE) {
			return new JTextField(15);
		} else if(vo.getType() == TypeVo.LONG) {
			return new JTextField(15);
		} else {
			return new JTextField(15);
		}
	}
	
	public LinkedHashMap getFields() {
		return this.fields;
	}
	
	public void clearPanel() {
		buildEmptyPanel();
		Set set = fields.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Entry entry = (Entry)iter.next();
			this.remove((JComponent)entry.getValue());
		}
		Set set2 = labels.entrySet();
		Iterator iter2 = set2.iterator();
		while(iter2.hasNext()) {
			Entry entry = (Entry)iter2.next();
			this.remove((JComponent)entry.getValue());
		}
		labels.clear();
		fields.clear();
	}
	
	public static void main(String[] args)
	{
		AddAlternativePanel p = new AddAlternativePanel();
		p.addAlternative(new AlternativeVo("Teste", new TypeVo()));
		p.addAlternative(new AlternativeVo("Teste", new TypeVo()));
		p.addAlternative(new AlternativeVo("Teste", new TypeVo()));
		p.addAlternative(new AlternativeVo("Teste", new TypeVo()));
		RunForm.runPanel(p);
	}
	
}
