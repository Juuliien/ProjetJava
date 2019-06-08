package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controleur.Controleur;
import model.Personne;

public class OpenBulletin extends JPanel {
	
	JPanel panel = new JPanel(false);
	JPanel panelN = new JPanel(false);
	JPanel panelC = new JPanel(false);
	 
	JLabel errLabel = new JLabel("PatchNote 9.69 Rito Games!");
	 
	JButton addEvalButton = new JButton("Ajouter une evaluation");
	
	public OpenBulletin(JDialog fenetre) {
		
		 TablePanelBulletin tablePanel;
		 tablePanel = new TablePanelBulletin();
		 tablePanel.setData(controleur.rechercheBulletin());
		 tablePanel.rafraichir();
		 
		 
		 panelN.setLayout(new FlowLayout());
		 panelN.add(addEvalButton);
		 
		 panelC.setLayout(new BorderLayout());
		 
		 panelC.add(new JScrollPane(tablePanel), BorderLayout.CENTER);
		 
		 panel.setLayout(new BorderLayout());
		 panel.add(panelC, BorderLayout.CENTER);
		 panel.add(panelN, BorderLayout.NORTH);
		 panel.add(errLabel, BorderLayout.SOUTH);
		
	}
	
	
	public JPanel getPanel() {
		return panel;
	}
}
