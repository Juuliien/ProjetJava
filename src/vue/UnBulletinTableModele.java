package vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.UnBulletin;

public class UnBulletinTableModele extends AbstractTableModel {
	
	private List<UnBulletin> data;
	private String[] header = {"Matiere","Note","Appreciation"};
	/**
         * Constructeur par défaut
         */
	public UnBulletinTableModele() {
		
	}
	
	public void setData(List<UnBulletin> data) {
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
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		UnBulletin unBulletin = data.get(row);
		switch(col) {
		case 0:
			return unBulletin.getMatiere();
		case 1:
			return unBulletin.getNote();
		case 2:
			return unBulletin.getAppreciationEval();
		}
		return null;
	}

}
