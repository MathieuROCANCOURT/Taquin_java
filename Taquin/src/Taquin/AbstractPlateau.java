package Taquin;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;

public abstract class AbstractPlateau implements Observable {

	protected int lignes;
	protected int colonnes;
	protected ArrayList<ArrayList<Piece>> plateau = new ArrayList<ArrayList<Piece>>(); //Liste de listes, contenant chacune les pieces de la ligne correspondante
	private ArrayList<Observer> observerList= new ArrayList<Observer>(); //Liste des observateurs
	
	
	public AbstractPlateau (int lignes, int colonnes) {
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.creerPieces();
		this.shuffle(2^(this.lignes*this.colonnes*2)); //Nombre arbitraire de coups pour mélanger (l'aléatoire semble fonctionner étrangement)
	}
	
	//***********************************************************//
	
	//Fonctions qui créent le Taquin et l'initialisent
	public abstract void creerPieces();
	
	public abstract void shuffle(int nbCoups);
	
	public abstract boolean res(); //Fonction qui indique si le taquin est résolu
	
	public abstract void afficher(); //Affiche le taquin dans le terminal
	
	
	
	//***********************************************************//
	
	//Fonctions qui gèrent le déplacement de pieces dans le Taquin
	public abstract void moveLeft();
	
	public abstract void moveRight();
	
	public abstract void moveUp();
	
	public abstract void moveDown();
	
	
	//***********************************************************//
	
	//Fonctions qui informent/gèrent les Observers
	public void addObserver(Observer obs) {
	    this.observerList.add(obs);
	  }
	
	public void notifyObserver() {
		for (Observer obs : observerList) {
			obs.update();
		}
	}
	
	//***********************************************************//
	
	//Getters
	public int getDim() {
		return this.lignes*this.colonnes;
	}

	public ArrayList<ArrayList<Piece>> getPlateau(){
		return this.plateau;
	}

	public int getColonnes() {
		return this.colonnes;
	}

	public int getLignes() {
		return this.lignes;
	}
}
