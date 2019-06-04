package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import model.Personne;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonneTableModele tableModele;
	
	public TablePanel() {
		
		
			tableModele = new PersonneTableModele();
			table = new JTable(tableModele);
			setLayout(new BorderLayout());
			add(new JScrollPane(table), BorderLayout.CENTER);
		
		
	}
	public void setData(List<Personne> data) {
		tableModele.setData(data);
	}
	
	public void rafraichir() {
		tableModele.fireTableDataChanged();
	}
	

	public void changerHeaderEn() {
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc = tcm.getColumn(4);
		tc.setHeaderValue( "Displine" );
		th.repaint();
	}
	public void changerHeaderEl() {
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc = tcm.getColumn(4);
		tc.setHeaderValue( "Niveau" );
		th.repaint();
	}
	
	
}
