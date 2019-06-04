package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddForm extends JPanel {
	
	private JPanel panel = new JPanel(false);
	
	private JButton buttonAdd = new JButton("Ajouter !");
	
	private JLabel nomLabel = new JLabel("Nom: ");
	private JLabel prenomLabel = new JLabel("Prenom: ");
	private JLabel classeLabel = new JLabel("Classe: ");
	private JLabel nivDisLabel;

	private JTextField nomTf = new JTextField(24);
	private JTextField prenomTf = new JTextField(24);
	
	private JComboBox<String> classeCb = new JComboBox<String>();
	private JComboBox<String> nivDisCb = new JComboBox<String>();
	
	public AddForm(String type) {
		
		Border insideBorder = BorderFactory.createTitledBorder("Ajouter un "+type);
		Border outsideBorder = BorderFactory.createEmptyBorder(150,100,160,100);
		panel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		if(type == "eleve") {
			nivDisLabel = new JLabel("Niveau: ");
		}else {
			nivDisLabel = new JLabel("Discipline: ");
		}
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		/***row 1 ***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panel.add(nomLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(nomTf, gc);
		
		/***row 2 ***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panel.add(prenomLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(prenomTf, gc);
		
		/***row 3***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panel.add(classeLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(classeCb, gc);
		
		/***row 4***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(nivDisLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(nivDisCb, gc);
		
		/***row 5***/
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(buttonAdd, gc);
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
