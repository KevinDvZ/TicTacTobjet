package fr.kevindvz;

public class Interaction {

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

    // checker le char d'entrée du joueur

    public void name() {

    }
}