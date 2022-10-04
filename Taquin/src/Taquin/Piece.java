package Taquin;

public class Piece {
	protected int ligne;
	protected int colonne;
	protected int nom;
	
	public Piece (int ligne, int colonne, int nom) {
		this.ligne=ligne;
		this.colonne=colonne;
		this.nom=nom;
	}
	
	
	//Setters (+1 ou -1 pour changer de ligne/colonne)
	public void setLigne(int move) {
		this.ligne=this.ligne+move;
	}
	public void setColonne(int move) {
		this.colonne=this.colonne+move;
	}
	
	//***********************************************************//
	
	
	//Getters
	public int getLigne() {
		return this.ligne;
	}
	
	public int getColonne() {
		return this.colonne;
	}
	public int getNom() {
		return this.nom;
	}
	
	//***********************************************************//
	
	public String toString () {
		return "" + this.nom + " ";
	}

	public boolean verifier (int colonnes) { //Verfie si le nom et le numero d'emplacement correspondent
		if ((this.ligne-1)*colonnes + this.colonne == nom) {
			return true;
		}
		return false;
	}
}
