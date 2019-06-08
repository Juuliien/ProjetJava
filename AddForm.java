package gui;

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
import javax.swing.JTextField;
import javax.swing.border.Border;

import controleur.Controleur;
import model.Personne;

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
	
	public AddForm(String type, JDialog fenetre, TablePanel tablePanel) {
		
		Border insideBorder = BorderFactory.createTitledBorder("Ajouter un "+type);
		Border outsideBorder = BorderFactory.createEmptyBorder(150,100,160,100);
		panel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		Controleur controleur = new Controleur();
		
		if(type == "eleve") {
			nivDisLabel = new JLabel("Niveau: ");
			ArrayList<String> listeNiv = controleur.obtenirNiveau();
			
			String[] itemsNiv = new String[listeNiv.size()];
            listeNiv.toArray(itemsNiv);

			nivDisCb.setModel(new DefaultComboBoxModel<String>(itemsNiv));
			
			nivDisCb.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
				         String niveau = nivDisCb.getSelectedItem().toString();
				         ArrayList<String> listeClasse = controleur.obtenirClasse(niveau);
				         
				         String[] itemsClasse = new String[listeClasse.size()];
				         listeClasse.toArray(itemsClasse);
				         
				         classeCb.setModel(new DefaultComboBoxModel<String>(itemsClasse));
				         
				       }
					
				}
			});
			
		}else {
			nivDisLabel = new JLabel("Discipline: ");
			ArrayList<String> listeDis = controleur.obtenirDispline();
			
			String[] itemsDis = new String[listeDis.size()];
            listeDis.toArray(itemsDis);

			nivDisCb.setModel(new DefaultComboBoxModel<String>(itemsDis));
			
			 ArrayList<String> listeClasse = controleur.obtenirToutClasse();
	         
	         String[] itemsClasse = new String[listeClasse.size()];
	         listeClasse.toArray(itemsClasse);
	         
	         classeCb.setModel(new DefaultComboBoxModel<String>(itemsClasse));
				
		}
		
		buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (type == "eleve") {
					int idPersonne = controleur.ajouterPersonne(nomTf.getText(), prenomTf.getText(), type);
					int idClasse = controleur.obtenirIdClasse(classeCb.getSelectedItem().toString());
					controleur.ajoutInscription(idPersonne, idClasse);
					fenetre.dispose();
					tablePanel.setData(controleur.recherchePersonne());
					tablePanel.changerHeaderEl();
					tablePanel.rafraichir();
				}else {
					int idPersonne = controleur.ajouterPersonne(nomTf.getText(), prenomTf.getText(), type);
					int idClasse = controleur.obtenirIdClasse(classeCb.getSelectedItem().toString());
					int idDis = controleur.obtenirIdDiscipline(nivDisCb.getSelectedItem().toString());
					controleur.ajoutEnseignement(idDis, idPersonne, idClasse);
					fenetre.dispose();
					tablePanel.setData(controleur.recherchePersonneEn());
					tablePanel.changerHeaderEn();
					tablePanel.rafraichir();
					
				}
			}
		});
		
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
		panel.add(nivDisLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(nivDisCb, gc);
		
		/***row 4***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		
		panel.add(classeLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(classeCb, gc);
		
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
