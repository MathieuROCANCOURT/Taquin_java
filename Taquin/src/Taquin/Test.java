package Taquin;

import java.util.Scanner;

public class Test {//Permet de jouer dans la console

	public static void main(String[] args) {
		Plateau plateau = new Plateau (3 , 3);
		
		plateau.afficher();
		
		Scanner sc  = new Scanner(System.in);
		while(!plateau.res()) {
			System.out.println("Entrez l,r,u,d");
			String tmp = sc.nextLine();
			char dir = tmp.charAt(0);
			if (dir=='l') {
				plateau.moveLeft();
			}
			if (dir=='r') {
				plateau.moveRight();
			}
			if (dir=='d') {
				plateau.moveDown();
			}
			if (dir=='u') {
				plateau.moveUp();
			}
			plateau.afficher();
		}
		System.out.println("Vous avez gagné");
		sc.close();
		
		
		
	}	

}
