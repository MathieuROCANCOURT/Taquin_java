package Controler;

import Taquin.AbstractPlateau;

public abstract class AbstractControler {

    protected AbstractPlateau plateau;
    protected String direction = "";

    public AbstractControler(AbstractPlateau p) {
        this.plateau = p;
    }

    //***********************************************************//

    //Gere la direction de déplacement choisie
    public void setDirection(String dir) {
        this.direction = dir;
    }

    //***********************************************************//

    //Getter
    public AbstractPlateau getPlateau() {
        return this.plateau;
    }

    //***********************************************************//

    //Vérifie si une action choisie est possible, puis envoie l'instruction au modèle
    public abstract void control();
}
