package vue;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.Bulletin;

public class TablePanelBulletin extends JPanel {
	private JTable table;
	private BulletinTableModele tableModele;
	/**
         * Fenetre du bulletin
         */
	public TablePanelBulletin() {
		
		
			tableModele = new BulletinTableModele();
			table = new JTable(tableModele);
			setLayout(new BorderLayout());
			add(new JScrollPane(table), BorderLayout.CENTER);
		
		
	}
        /**
         * Setter de la List de la bulletin
         * @param data 
         */
	public void setData(List<Bulletin> data) {
		tableModele.setData(data);
	}
	/**
         * rafraichis la fenetre 
         */
	public void rafraichir() {
		tableModele.fireTableDataChanged();
	}
	
        /**
         * Selectionne une ligne 
         * @return 
         */
	public int SelectedRow() {
		return table.getSelectedRow();
	}
	/**
         * Retourne l'id de la ligne en parametre 
         * @param row
         * @return 
         */
	public String getValueCol0(int row) {
		return tableModele.getValueAt(row, 0).toString();
	}
	/**
         * retourne le nom de la ligne en paramatre 
         * @param row
         * @return un String
         */
	
	public String nom(int row) {
		return tableModele.getValueAt(row, 1).toString();
	}
	/**
         * retourne le prénom de la ligne en parametre 
         * @param row
         * @return un String 
         */
	public String prenom(int row) {
		return tableModele.getValueAt(row, 2).toString();
	}
	
}
