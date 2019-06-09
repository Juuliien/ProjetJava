package vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Personne;

public class PersonneTableModele extends AbstractTableModel {
	
	private List<Personne> data;
	private String[] header = {"ID","Nom","Prenom","Classe","Niveau"};
	
	public PersonneTableModele() {
		
	}
	
	public void setData(List<Personne> data) {
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
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Personne personne = data.get(row);
		switch(col) {
		case 0:
			return personne.getId();
		case 1:
			return personne.getNom();
		case 2:
			return personne.getPrenom();
		case 3:
			return personne.getNomClasse();
		case 4:
			return personne.getNomNivDis();
		}
		return null;
	}

}
