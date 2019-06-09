package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {
        /**
         * Fenetre d'accueil
         */
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
