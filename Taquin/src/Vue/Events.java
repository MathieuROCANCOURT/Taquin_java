package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Controler.AbstractControler;


public class Events extends Application implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public Events (AbstractControler controler){
		super(controler);
	}

	
	public void init() {
		for(int i=0; i<this.controler.getPlateau().getDim(); i++) {
			JButton tmp = new JButton(this.controler.getPlateau().getPlateau().get(i/this.controler.getPlateau().getColonnes()).get(i%this.controler.getPlateau().getColonnes()).toString());
			tmp.addActionListener(this);
			this.panneau.add(tmp);
			tabPieces[i]=tmp;
			
		}	
	}


	
	public void actionPerformed(ActionEvent e) {
		int pos=0;
		while(!((JButton)e.getSource()).getText().contentEquals(this.tabPieces[pos].getText())) {
			pos=pos+1;
		}
		if(pos+1<this.controler.getPlateau().getDim() && this.tabPieces[pos+1].getText().equals("  ")) {
			this.controler.setDirection("left");
			this.controler.control();
		}
		if(pos-1>=0 && this.tabPieces[pos-1].getText().equals("  ")) {
			this.controler.setDirection("right");
			this.controler.control();
		}
		if(pos+this.controler.getPlateau().getColonnes()<this.controler.getPlateau().getDim() && this.tabPieces[pos+this.controler.getPlateau().getColonnes()].getText().equals("  ")) {
			this.controler.setDirection("up");
			this.controler.control();
		}
		if(pos-this.controler.getPlateau().getColonnes()>=0 && this.tabPieces[pos-this.controler.getPlateau().getColonnes()].getText().equals("  ")) {
			this.controler.setDirection("down");
			this.controler.control();
		}
	}
}
