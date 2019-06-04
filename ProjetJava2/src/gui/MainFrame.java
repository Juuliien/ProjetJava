package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame(){
		super("School Engine");
		
		setSize(720, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		PanelTab panelTab = new PanelTab();
		
		
		setLayout(new BorderLayout());
		add(panelTab, BorderLayout.CENTER);
		setVisible(true);
		
	}

	
}
