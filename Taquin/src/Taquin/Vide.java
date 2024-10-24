package Taquin;

public class Vide extends Piece { //Case vide, possédant un verifier à True par défaut (car nom=0), et un toString vide
    public Vide(int ligne, int colonne) {
        super(ligne, colonne, 0);
    }

    public boolean verifier(int colonnes) {
        return true;
    }

    public String toString() {
        return "  ";
    }
}
