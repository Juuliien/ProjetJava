package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private PanelConnexion panelCo;

	public MainFrame(){
		super("SchoolEngine Connexion");
		
		setSize(600, 500);
		setMinimumSize(new Dimension(600, 500));
		setMaximumSize(new Dimension(700, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panelCo = new PanelConnexion();
		
		
		setLayout(new BorderLayout());
		add(panelCo, BorderLayout.CENTER);
		
		setVisible(true);
		
	}

	public PanelConnexion getPanelCo() {
		return panelCo;
	}
}
