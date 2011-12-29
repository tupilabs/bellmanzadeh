package br.com.mackenzie.fuzzy.bellmanzadeh;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

public class RunForm {

	public static void runContainer(Container c ) {
		JFrame frame = new JFrame("Run Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(c);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void runPanel(JPanel c ) {
		JFrame frame = new JFrame("Run Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(c);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void runTable(JTable table) {
		JFrame frame = new JFrame("Run Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JScrollPane pane = new JScrollPane(table);
		panel.add(pane);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void run(Class classe) 
    {    
        try 
        {
        	UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
			JFrame frame = new JFrame();
			frame.setTitle("Panel test");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			frame.getContentPane().add((Component)classe.newInstance());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
        catch (Exception e) 
		{
        	//MseExceptionDialog.showException(e);
        	e.printStackTrace();
		}
    }
	
}
