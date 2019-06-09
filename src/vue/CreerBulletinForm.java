package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controleur.Controleur;

public class CreerBulletinForm extends JPanel {
	private JPanel panel = new JPanel(false);
	
	private JLabel eleveLabel = new JLabel("Eleve: ");
	private JComboBox<String> eleveCb = new JComboBox<String>();
	
	private JButton creerBulletinButton = new JButton("Creer !");
	/**
         * Fenetre de crétion d'un bulletin pour un élève
         * @param trimestre
         * @param tablePanel
         * @param fenetre 
         */
	public CreerBulletinForm(int trimestre, TablePanelBulletin tablePanel, JDialog fenetre) {
		Controleur controleur = new Controleur();
		Border insideBorder = BorderFactory.createTitledBorder("Creer un bulletin");
		Border outsideBorder = BorderFactory.createEmptyBorder(150,100,160,100);
		panel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
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
		panel.add(eleveLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(eleveCb, gc);
		
		/***row 2***/
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(creerBulletinButton, gc);
		
		ArrayList<String> listeEleve = controleur.obtenirEleveInscrit();
		String[] itemsEleve = new String[listeEleve.size()];
		listeEleve.toArray(itemsEleve);
		
		eleveCb.setModel(new DefaultComboBoxModel<String>(itemsEleve));
		
		creerBulletinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String[] idEleve = eleveCb.getSelectedItem().toString().split(" - ");
				controleur.CreerBulletin(trimestre, idEleve[0]);
				tablePanel.setData(controleur.rechercheBulletin());
				tablePanel.rafraichir();
				fenetre.dispose();
				
				
			}
		});
		
	}

	public JPanel getPanel() {
		return panel;
	}
	
	

}
