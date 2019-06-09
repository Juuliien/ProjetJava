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
import javax.swing.JTextField;
import javax.swing.border.Border;

import controleur.Controleur;

public class AddEval extends JPanel {

	private JPanel panel = new JPanel(false);
	
	private JLabel matLabel = new JLabel("Matiere: ");
	private JLabel noteLabel = new JLabel("Note: ");
	private JLabel appreLabel = new JLabel("Appreciation: ");
	
	private JComboBox<String> matCb = new JComboBox<String>();
	
	private JTextField noteTf = new JTextField(2);
	private JTextField appreTf = new JTextField(24);
	
	private JButton addButton = new JButton("Ajouter !");

	/**
         * Fenêtre d'ajout d'une évaluation 
         * @param idBulletin id du bulletin 
         * @param fenetre de type JDialog
         * @param tablePanel 
         */
	public AddEval(int idBulletin, JDialog fenetre, TablePanelUnBulletin tablePanel) {
		
		Border insideBorder = BorderFactory.createTitledBorder("Ajouter une evaluation");
		Border outsideBorder = BorderFactory.createEmptyBorder(150,100,160,100);
		panel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		Controleur controleur = new Controleur();
		
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
		panel.add(matLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(matCb, gc);
		
		/***row 2 ***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panel.add(noteLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(noteTf, gc);
		
		/***row 3***/
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		panel.add(appreLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(appreTf, gc);
		
		/***row 4***/
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(addButton, gc);
		
		ArrayList<String> listeMat = controleur.obtenirMatiere();
		String[] itemsMat = new String[listeMat.size()];
		listeMat.toArray(itemsMat);
		
		matCb.setModel(new DefaultComboBoxModel<String>(itemsMat));
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] idEnseignement = matCb.getSelectedItem().toString().split(" - ");
				if (controleur.verifierExistanceBulletinMat(idBulletin, idEnseignement[0])==-1) {
					int idBulletinMat = controleur.ajoutBulletinMat(idBulletin, Integer.parseInt(idEnseignement[0]));
					controleur.ajoutEval(idBulletinMat, Integer.parseInt(noteTf.getText()), appreTf.getText());
					
				}else {
					controleur.ajoutEval(controleur.verifierExistanceBulletinMat(idBulletin, idEnseignement[0]), Integer.parseInt(noteTf.getText()), appreTf.getText());
				}

				fenetre.dispose();
				tablePanel.setData(controleur.rechercheUnBulletin(idBulletin));
				tablePanel.rafraichir();
				
			}
		});
		
		
		
	}
	/**
         * Getter du panel utilisé
         * @return 
         */
	public JPanel getPanel() {
		return panel;
	}
	
}
