package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import controleur.Controleur;
import modele.UnBulletin;

public class OpenBulletin extends JPanel {
	
	JPanel panel = new JPanel(false);
	JPanel main = new JPanel(false);
	JPanel panelN = new JPanel(false);
	JPanel panelC = new JPanel(false);
	 
	JLabel errLabel = new JLabel("Application de Julien, Axel et Rosanna");
	 
	JButton addEvalButton = new JButton("Ajouter une evaluation");
	JButton ouvrirDiagrammeButton = new JButton("Ouvrir Diagramme");
	
	Controleur controleur = new Controleur();
	/**
         * Fenetre de lecture du bulletin 
         * @param fenetre
         * @param idBulletin 
         */
	public OpenBulletin(JDialog fenetre, int idBulletin) {
		
		 TablePanelUnBulletin tablePanel;
		 tablePanel = new TablePanelUnBulletin();
		 tablePanel.setData(controleur.rechercheUnBulletin(idBulletin));
		 tablePanel.rafraichir();
		 
		 panelN.setLayout(new FlowLayout());
		 panelN.add(addEvalButton);
		 panelN.add(ouvrirDiagrammeButton);
		 
		 main.setLayout(new BorderLayout());
		 main.add(panelN, BorderLayout.NORTH);
		 main.add(new JScrollPane(tablePanel), BorderLayout.CENTER);
		 
		 addEvalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddEval addEval;
				JDialog addEvalWindo = new JDialog();
				addEval = new AddEval(idBulletin, addEvalWindo, tablePanel);
				
				addEvalWindo.setLayout(new FlowLayout());
				addEvalWindo.add(addEval.getPanel());
				addEvalWindo.setTitle("Donnez nous 20/20 SVP");
				addEvalWindo.setSize(600, 400);
				addEvalWindo.setVisible(true);
				
			}
		});
		 
		 ouvrirDiagrammeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
				
				List<UnBulletin> listeBulletin = controleur.rechercheUnBulletin(idBulletin);
				
				for(int i=0;i<listeBulletin.size();i++) {
					dataset.setValue(listeBulletin.get(i).getNote(),"Note",listeBulletin.get(i).getMatiere());
				}
				
				JFreeChart chart = ChartFactory.createBarChart("Note de l'eleve", "Matiere", "Note", dataset, PlotOrientation.VERTICAL, false, false, false);
				CategoryPlot p = chart.getCategoryPlot(); 
				p.setRangeGridlinePaint(Color.DARK_GRAY);
				ChartFrame frame = new ChartFrame("Diagramme de note",chart);
				frame.setVisible(true);
				frame.setSize(720, 480);
				
			}
		});
		
	}
	
	
	public JPanel getPanel() {
		return main;
	}
}
