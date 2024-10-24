package observer;

public interface Observable {
    //Un objet observable (ici le modèle) possède des observateurs, et doit pouvoir les prévenir d'un changement
    void addObserver(Observer obs);

    void notifyObserver();
}
