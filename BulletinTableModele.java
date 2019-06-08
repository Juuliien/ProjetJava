package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Bulletin;

public class BulletinTableModele extends AbstractTableModel {
	
	private List<Bulletin> data;
	private String[] header = {"ID","Nom","Prenom","Appreciation"};
	
	public BulletinTableModele() {
		
	}
	
	public void setData(List<Bulletin> data) {
		this.data = data;
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return header[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Bulletin bulletin = data.get(row);
		switch(col) {
		case 0:
			return bulletin.getId();
		case 1:
			return bulletin.getNom();
		case 2:
			return bulletin.getPrenom();
		case 3:
			return bulletin.getAppreciation();
		}
		return null;
	}

}
