import Controler.AbstractControler;
import Controler.TaquinControler;
import Taquin.AbstractPlateau;
import Taquin.Plateau;
import Vue.Application;
import Vue.Events;

public class Test {

	public static void main(String[] args) {
    
		    AbstractPlateau taquin = new Plateau (7,7); //Changer la dimension du Taquin
		 
		    AbstractControler controler = new TaquinControler(taquin);

		    Application window = new Events(controler);

		    taquin.addObserver(window);
		   }
}
