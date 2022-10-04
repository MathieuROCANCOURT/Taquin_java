package observer;

public interface Observable {
	//Un objet observable (ici le modele) possede des observateurs, et doit pouvoir les prevenir d'un changement
	public void addObserver(Observer obs);
	public void notifyObserver();
}
