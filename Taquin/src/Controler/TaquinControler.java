package Controler;

import Taquin.AbstractPlateau;

public class TaquinControler extends AbstractControler {

    public TaquinControler(AbstractPlateau p) {
        super(p);
    }


    public void control() {
        if (this.direction.contentEquals("up")) {        //Vers le haut
            this.plateau.moveUp();
        }
        if (this.direction.contentEquals("down")) {    //Vers le bas
            this.plateau.moveDown();
        }
        if (this.direction.contentEquals("left")) {    //Vers la gauche
            this.plateau.moveLeft();
        }
        if (this.direction.contentEquals("right")) {    //Vers la droite
            this.plateau.moveRight();
        }
        this.setDirection("");                        //Reset la variable d'instruction
        this.plateau.notifyObserver();                //Demande au modèle d'informer la vue
    }

}
