package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Bulletin;

public class TablePanelBulletin extends JPanel {
	private JTable table;
	private BulletinTableModele tableModele;
	
	public TablePanelBulletin() {
		
		
			tableModele = new BulletinTableModele();
			table = new JTable(tableModele);
			setLayout(new BorderLayout());
			add(new JScrollPane(table), BorderLayout.CENTER);
		
		
	}
	public void setData(List<Bulletin> data) {
		tableModele.setData(data);
	}
	
	public void rafraichir() {
		tableModele.fireTableDataChanged();
	}
	

	public int SelectedRow() {
		return table.getSelectedRow();
	}
	
	public String getValueCol0(int row) {
		return tableModele.getValueAt(row, 0).toString();
	}
	
}
