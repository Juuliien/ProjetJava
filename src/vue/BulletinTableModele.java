package vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Bulletin;

public class BulletinTableModele extends AbstractTableModel {
	
	private List<Bulletin> data;
	private String[] header = {"ID","Nom","Prenom","Appreciation"};
	/**
         * Constructeur par défaut
         */
	public BulletinTableModele() {
		
	}
	/**
         * Setter de la List de bulletin
         * @param data 
         */
	public void setData(List<Bulletin> data) {
		this.data = data;
	}
	
	
        /**
         * Redéfiniion de la méthode de l'interface AbstractTableModel
         * @param column
         * @return 
         */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return header[column];
	}
        /**
         * Redéfinition du nombre de colonne max 
         * @return on le définit avec l'entier 4
         */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
        /**
         * Redéfinition de la méthode de l'interface
         * @return la taille de la liste de la classe 
         */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
        /**
         * Retourne la valeur de la ligne et de la colonne souhaitée 
         * @param row ligne 
         * @param col colonne 
         * @return un objet de type suivant les données souhaitées id, nom, prenom, appreciation
         */
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


