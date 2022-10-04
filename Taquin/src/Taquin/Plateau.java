package Taquin;

import java.util.ArrayList;


public class Plateau extends AbstractPlateau {
	
	public Plateau (int lignes, int colonnes) {
		super(lignes, colonnes);
	}
	
	//Crée les pieces du Taquin et les place dans l'arrayList
	public void creerPieces () {
		for (int i=0; i<this.lignes*this.colonnes-1; i++) {
			if (i%this.colonnes==0) {
				this.plateau.add(new ArrayList<Piece>());
			}
			this.plateau.get(i/this.colonnes).add(new Piece(i/this.colonnes +1, i%this.colonnes +1, i+1));
		}
		this.plateau.get(this.lignes-1).add( new Vide (this.lignes, this.colonnes));
	}
		
	public void afficher () {
		for (int i=0; i<lignes; i++ ) {
			for(int j=0; j<colonnes; j++) {
				System.out.print(plateau.get(i).get(j));
			}
			System.out.println("");
		}
	}
	
	//***********************************************************//
	
	//Fonctions de mouvement (meme construction dans les 4)
	public void moveLeft() {
		int i=0;
		while(this.plateau.get(i/colonnes).get(i%colonnes).getNom()!=0) { //Trouve l'emplacement de la case vide
			i=i+1;
		}
		if(this.plateau.get(i/colonnes).get(i%colonnes).getColonne()!=1) { //Vérifie si il existe une case a gauche
			
			this.plateau.get(i/colonnes).get(i%colonnes).setColonne(-1);	//Echange les coordonnées 
			this.plateau.get(i/colonnes).get(i%colonnes-1).setColonne(+1);
			
			Piece tmp = this.plateau.get(i/colonnes).get(i%colonnes);	//Echange les places des 2 pieces dans l'arrylist
			this.plateau.get(i/colonnes).set(i%colonnes, this.plateau.get(i/colonnes).get(i%colonnes-1));
			this.plateau.get(i/colonnes).set(i%colonnes-1, tmp);
		}
	}
	
	public void moveRight() {
		int i=0;
		while(this.plateau.get(i/colonnes).get(i%colonnes).getNom()!=0) {
			i=i+1;
		}
		if(this.plateau.get(i/colonnes).get(i%colonnes).getColonne()!=this.colonnes) {
			this.plateau.get(i/colonnes).get(i%colonnes).setColonne(+1);
			this.plateau.get(i/colonnes).get(i%colonnes+1).setColonne(-1);
			
			Piece tmp = this.plateau.get(i/colonnes).get(i%colonnes);
			
			this.plateau.get(i/colonnes).set(i%colonnes, this.plateau.get(i/colonnes).get(i%colonnes+1));
			this.plateau.get(i/colonnes).set(i%colonnes+1, tmp);
		}
	}
	
	public void moveUp() {
		int i=0;
		while(this.plateau.get(i/colonnes).get(i%colonnes).getNom()!=0) {
			i=i+1;
		}
		if(this.plateau.get(i/colonnes).get(i%colonnes).getLigne()!=1) {
			this.plateau.get(i/colonnes).get(i%colonnes).setLigne(-1);
			this.plateau.get(i/colonnes-1).get(i%colonnes).setLigne(+1);
			
			Piece tmp = this.plateau.get(i/colonnes).get(i%colonnes);
			
			this.plateau.get(i/colonnes).set(i%colonnes, this.plateau.get(i/colonnes-1).get(i%colonnes));
			this.plateau.get(i/colonnes-1).set(i%colonnes, tmp);
		}
	}
	
	public void moveDown() {
		int i=0;
		while(this.plateau.get(i/colonnes).get(i%colonnes).getNom()!=0) {
			i=i+1;
		}
		if(this.plateau.get(i/colonnes).get(i%colonnes).getLigne()!=this.lignes) {
			this.plateau.get(i/colonnes).get(i%colonnes).setLigne(+1);
			this.plateau.get(i/colonnes+1).get(i%colonnes).setLigne(-1);
			
			Piece tmp = this.plateau.get(i/colonnes).get(i%colonnes);
			
			this.plateau.get(i/colonnes).set(i%colonnes, this.plateau.get(i/colonnes+1).get(i%colonnes));
			this.plateau.get(i/colonnes+1).set(i%colonnes, tmp);
		}
	}

	//***********************************************************//
	public boolean res() { //Verifie si chaque piece est a sa place
		for (int i=0; i<this.lignes; i++) {
			for(int j=0; j<this.colonnes; j++) {
				if(!this.plateau.get(i).get(j).verifier(this.colonnes)) {
					return false;
				}
			}
		}
		return true;
	}

	public void shuffle(int nbCoups) {
		for(int i = 0; i <nbCoups;i++) {
			double tmp= Math.random();
			if (tmp < 0.25) {
				this.moveUp();
			}
			if (0.25 <= tmp && tmp <0.5) {
				this.moveDown();
			}
			if (0.5 <= tmp && tmp <0.75) {
				this.moveRight();
			}
			else {
				this.moveLeft();
			}
		}
	}

	//***********************************************************//
}

