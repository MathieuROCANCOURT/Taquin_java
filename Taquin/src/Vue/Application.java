package Vue;

import java.awt.*;
import javax.swing.*;
import Controler.AbstractControler;
import observer.Observer;

public abstract class Application extends JFrame implements Observer{
	protected JPanel panneau = new JPanel();
	protected JButton[] tabPieces;
	protected AbstractControler controler;
	protected JLabel win= new JLabel("Vous avez gagné");
	
	public Application(AbstractControler controler){                
		this.controler = controler;
		this.tabPieces= new JButton[this.controler.getPlateau().getDim()];
		this.setSize(800, 800);
	    this.setTitle("Taquin");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.win.setHorizontalAlignment(JLabel.CENTER);
	    this.win.setVerticalAlignment(JLabel.CENTER);
	    this.panneau.setLayout(new GridLayout(this.controler.getPlateau().getLignes(), this.controler.getPlateau().getColonnes()));
	    init();                
	    this.setContentPane(panneau);
	    this.setVisible(true);
	  }

	public abstract void init();

	
	public void update() {
		this.panneau.removeAll();
		if(this.controler.getPlateau().res()) {
			this.panneau.add(win);
		}
		else {
			init();
		}
		panneau.revalidate();
		panneau.repaint();
		}
}
