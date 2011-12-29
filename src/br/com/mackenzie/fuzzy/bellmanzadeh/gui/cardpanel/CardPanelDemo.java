package br.com.mackenzie.fuzzy.bellmanzadeh.gui.cardpanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 * Simple Demo of the CardPanel class: shows off most of the API: 
 * CardPanel.show("myCardName") and the CardPanel.showXXXCard
 * methods.
 */
public class CardPanelDemo
{
    private static final int nCards = 15;
    private static final Class[] noParams = {};
    private static final Object[] noArgs = {};


    /** 
     * A JPanel that displays a number between 0 and nCards-1 against
     * a distinctly colored (hued!) background.
     */
    private static class Card extends JPanel {
	Card(int n) {
	    super();
	    float hue = (float)n / (float)nCards;
	    Color color = Color.getHSBColor(hue, 0.5f, 0.85f);
	    JLabel label = new JLabel("<html><font size=+5><b>Card " + n + "</html>");
	    label.setForeground(color.brighter());
	    add(label);
	    setBackground(color);
	    setPreferredSize(new Dimension(200, 200));
	    setBorder(BorderFactory.createEtchedBorder());
	}
	public String toString() {
	    return getClass().getName() + " " + getName();
	}
    }


    public static void main(String[] args) 
    {
	final CardPanel cardPanel = new CardPanel(); 
	JToolBar toolBar = new JToolBar();
	JMenuBar menuBar = new JMenuBar();
	JMenu showMenu = new JMenu("Select a Card");
	
	/* Add nCards Card instances to the cardPanel and build
	 * the showMenu items while we're at it - one for each card.
	 */

	for(int i = 0; i < nCards; i++) {
	    final String cardName = "Card" + i;
	    Action showCardAction = new AbstractAction(cardName) {
		public void actionPerformed(ActionEvent e) {
		    cardPanel.showCard(cardName);
		}
	    };
	    cardPanel.add(new Card(i), cardName);
	    showMenu.add(showCardAction);
	}
	menuBar.add(showMenu);

	/* For each of the no-arg showXXXCard CardPanel methods, build
	 * an Action that calls the method.
	 */

	String[] methodNames = 
            {"showNextCard", "showPreviousCard", "showFirstCard", "showLastCard"};

	for(int i = 0; i < methodNames.length; i++) {
	    final String name = methodNames[i];
	    Action invokeMethodAction = new AbstractAction(" " + name + " ") {
		public void actionPerformed(ActionEvent ignore) {
		    try {
			CardPanel.class.getMethod(name, noParams).invoke(cardPanel, noArgs);
		    }
		    catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    };
	    toolBar.add(new JButton(invokeMethodAction));
	    toolBar.addSeparator();
	}

	/* Application boilerplate.
	 */

	JFrame f = new JFrame("CardPanel Demo");

	WindowListener l = new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		System.exit(0);
	    }
	};
	f.addWindowListener(l); 

	Container contentPane = f.getContentPane();
	contentPane.add(cardPanel, BorderLayout.CENTER);
	contentPane.add(toolBar, BorderLayout.NORTH);
	f.setJMenuBar(menuBar);
	f.pack();
	f.setVisible(true);
    }
}
