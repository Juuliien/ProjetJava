package vue;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.UnBulletin;

public class TablePanelUnBulletin extends JPanel {
	private JTable table;
	private UnBulletinTableModele tableModele;
	/**
         * Fenetre de lecture du bulletin spécifique à l'élève
         */
	public TablePanelUnBulletin() {
		
		
			tableModele = new UnBulletinTableModele();
			table = new JTable(tableModele);
			setLayout(new BorderLayout());
			add(new JScrollPane(table), BorderLayout.CENTER);
		
		
	}
        /**
         * Setter de la List de bulletin
         * @param data 
         */
	public void setData(List<UnBulletin> data) {
		tableModele.setData(data);
	}
	/**
         * Rafraîchis la page 
         */
	public void rafraichir() {
		tableModele.fireTableDataChanged();
	}
	
        /**
         * Retourne la ligne selectionné
         * @return un entier
         */
	public int SelectedRow() {
		return table.getSelectedRow();
	}
	
	
}
