package fr.kevindvz;

public class Interface {

}

    // Liste des messages
    public void messageIntro() {
        System.out.println("Bienvenue dans le jeu du morpion !");
    }

    // Affichage de la grille

    public void afficherGrille(Pion grille[][]) {

        for (int i = 0; i < grille.length; i++) {
            System.out.print("----------\n|");
            for (int j = 0; j < grille.length; j++) {
                System.out.println(grille[i][j] + "|");
            }
        }

    }

    // Liste des interactions

public void name() {
    
}