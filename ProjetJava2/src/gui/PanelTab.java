package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import controleur.Controleur;
import model.Connexion;


public class PanelTab extends JPanel {
	


	public PanelTab() {
		super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		
		  
        JComponent panel1 = tab1();
        tabbedPane.addTab("Recherche de personne", null, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_R);
         
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", null, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        tabbedPane.addTab("Tab 4", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	
	}
	
	 protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }
	 
	 protected JComponent tab1() {
		 JPanel panel = new JPanel(false);
		 JPanel panelN = new JPanel(false);
		 JPanel panelC = new JPanel(false);
		 
		 
		 JButton buttonAdd = new JButton("Ajouter !");
		 JButton buttonEdit = new JButton("Modifier !");
		 JButton buttonDelete = new JButton("Supprimer !");
		 
		 JCheckBox boxEleve = new JCheckBox("Eleve", true);
		 JCheckBox boxEnseignant = new JCheckBox("Enseignant", false);
		 
		 JLabel errLabel = new JLabel("Test !");
		 
		 Controleur controleur = new Controleur();
		 
		
		 
		 panelN.setLayout(new FlowLayout());
		 panelN.add(buttonAdd);
		 panelN.add(buttonEdit);
		 panelN.add(buttonDelete);
		 panelN.add(boxEleve);
		 panelN.add(boxEnseignant);
		 
		 panelC.setLayout(new BorderLayout());
		 
		 TablePanel tablePanel;
		 tablePanel = new TablePanel();
		 tablePanel.setData(controleur.recherchePersonne());
		 tablePanel.rafraichir();
		 
		 boxEleve.addItemListener(new ItemListener() {
			 	
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						boxEnseignant.setSelected(false);
						tablePanel.setData(controleur.recherchePersonne());
						tablePanel.changerHeaderEl();
						tablePanel.rafraichir();
					}else {
						boxEnseignant.setSelected(true);
						tablePanel.setData(controleur.recherchePersonneEn());
						tablePanel.changerHeaderEn();
						tablePanel.rafraichir();
						
					}
					
				}
			});
		 
		 boxEnseignant.addItemListener(new ItemListener() {
			 	
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						boxEleve.setSelected(false);
						tablePanel.setData(controleur.recherchePersonneEn());
						tablePanel.changerHeaderEn();
						tablePanel.rafraichir();
					}else {
						boxEleve.setSelected(true);
						tablePanel.setData(controleur.recherchePersonne());
						tablePanel.changerHeaderEl();
						tablePanel.rafraichir();
						
					}
					
				}
			});
		 
		 buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddForm addForm;
				if (boxEleve.isSelected()) {
					addForm = new AddForm("eleve");
				}else {
					addForm = new AddForm("enseignant");
				}
				JDialog addDial = new JDialog();
				addDial.setLayout(new FlowLayout());
				addDial.add(addForm.getPanel());
				addDial.setTitle("Donnez nous 20/20 SVP");
				addDial.setSize(600, 400);
				addDial.setVisible(true);
				
			}
		});
		 
		 
		 panelC.add(new JScrollPane(tablePanel), BorderLayout.CENTER);
		 
		 panel.setLayout(new BorderLayout());
		 panel.add(panelC, BorderLayout.CENTER);
		 panel.add(panelN, BorderLayout.NORTH);
		 panel.add(errLabel, BorderLayout.SOUTH);
		 
		 
		 
		 
		 return panel;
	 }
	 
	
}