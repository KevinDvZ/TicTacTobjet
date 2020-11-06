package fr.kevindvz;

public class Grille {
    public Pion[][] grille;
    Pion pion;

    public Grille() {

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                grille[i][j] = pion;
            }
        }

    }

}
