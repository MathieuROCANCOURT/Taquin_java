package Taquin;

public class Vide extends Piece{ //Case vide, poss�dant un verfier a True par d�faut (car nom=0), et un toString vide
	public Vide (int ligne, int colonne) {
		super(ligne, colonne, 0);
	}
	public boolean verifier (int colonnes) {
		return true;
	}
	
	public String toString() {
		return "  ";
	}
}
