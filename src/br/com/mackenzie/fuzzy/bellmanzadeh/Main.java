package br.com.mackenzie.fuzzy.bellmanzadeh;

import javax.swing.UIManager;

import br.com.mackenzie.fuzzy.bellmanzadeh.gui.MainFrame;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

public class Main {
	
	// Instância única do objeto
	private static Main obj_ = null;
	
	private MainFrame frame_ = null;
	
	/**
	 * Retorna o objeto Singleton
	 * @return
	 */
	public static Main getInstance() {
		if(obj_ == null){
			obj_ = new Main();
		}
		return obj_;
	}
	
	private Main() {
		frame_ = new MainFrame("Sistema de Apoio a Decisão - Bellman-Zadeh");
	}
	
	public MainFrame getMainFrame() {
		return this.frame_;
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Main main = Main.getInstance();
		main.getMainFrame().showIt();
	}

}
