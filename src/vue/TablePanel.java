package vue;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import modele.Personne;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonneTableModele tableModele;
	/**
         * Fenêtre de base 
         */
	public TablePanel() {
		
		
			tableModele = new PersonneTableModele();
			table = new JTable(tableModele);
			setLayout(new BorderLayout());
			add(new JScrollPane(table), BorderLayout.CENTER);
		
		
	}
        /**
         * Setter 
         * @param data 
         */
	public void setData(List<Personne> data) {
		tableModele.setData(data);
	}
	/**
         * Rafraichis la page
         */
	public void rafraichir() {
		tableModele.fireTableDataChanged();
	}
	
       /**
        * Change l'en-tete pour l'enseignant
        */
	public void changerHeaderEn() {
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc = tcm.getColumn(4);
		tc.setHeaderValue( "Discipline" );
		th.repaint();
	}
        /**
         * Change l'header pour l'eleve
         */
	public void changerHeaderEl() {
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc = tcm.getColumn(4);
		tc.setHeaderValue( "Niveau" );
		th.repaint();
	}
	
	public int SelectedRow() {
		return table.getSelectedRow();
	}
	
	public String getValueCol0(int row) {
		return tableModele.getValueAt(row, 0).toString();
	}
	
}
