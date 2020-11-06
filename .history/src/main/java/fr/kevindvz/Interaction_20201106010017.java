package fr.kevindvz;

import java.util.Scanner;

public class Interaction {

    Scanner clavier = new Scanner(System.in);

    public Interaction() {

    }

    // Liste des messages
    public void messageIntro() {
        System.out.println(
                "****************************************\nBienvenue dans le jeu du morpion !\n****************************************");
    }

    // Affichage de la grille

    public void afficherGrille(Pion grille[][]) {

        for (int i = 0; i < grille.length; i++) {
            System.out.print("\n-------------\n| ");
            for (int j = 0; j < grille.length; j++) {
                System.out.print(grille[i][j].symbole + " | ");
            }
        }
        System.out.print("\n-------------\n");
    }

    // Liste des interactions
    public int recupererNumeroCase(Joueur joueurActuel) {
        System.out.println("Inscrivez la case à remplir, " + joueurActuel.name);
        String CoordoneeClavier = clavier.nextLine();

        while (!CoordoneeClavier.matches("^1-9")) {
            System.out.println("Vous devez entrer un chiffre entre 1 & 9");
            CoordoneeClavier = clavier.nextLine();
        }

        int coordonneeInt = Integer.parseInt(CoordoneeClavier);
        return coordonneeInt;

    }

    // checker le char d'entrée du joueur

    public void name() {

    }
}