package fr.kevindvz;

import java.util.HashMap;

public class Grille {
    Joueur listeJoueur[];
    public Pion[][] grille;
    boolean grilleRemplie;

    public Grille() {
        grille = new Pion[3][3];
        grilleRemplie = false;

    }

    public void initialiserGrille() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                grille[i][j] = new Pion();
            }
        }
    }

    // retourne 0 si la grille n'est pas encore terminée
    // retourne 1 si joueur 1 gagne
    // retourne 2 si joueur 2 gagne
    // retourne 3 si la grille est bloquée
    public int verifierGrille() {
        int retour = 0;
        int presenceTotal = 0;
        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < grille.length; j++) {
                presenceTotal += this.grille[i][j].presence;
            }
            // test des lignes
            if (this.grille[i][0].valeur + this.grille[i][1].valeur + this.grille[i][2].valeur == 3) {
                retour = 1;
                this.grilleRemplie = true;
            }
            if (this.grille[i][0].valeur + this.grille[i][1].valeur + this.grille[i][2].valeur == -3) {
                retour = 2;
                this.grilleRemplie = true;
            }
            // test des colonnes
            if (this.grille[0][i].valeur + this.grille[1][i].valeur + this.grille[2][i].valeur == 3) {
                retour = 1;
                this.grilleRemplie = true;
            }
            if (this.grille[0][i].valeur + this.grille[1][i].valeur + this.grille[2][i].valeur == -3) {
                retour = 2;
                this.grilleRemplie = true;
            }

        }

        // test des diagonales

        if (this.grille[0][0].valeur + this.grille[1][1].valeur + this.grille[2][2].valeur == 3
                || this.grille[0][2].valeur + this.grille[1][1].valeur + this.grille[2][1].valeur == 3) {
            retour = 1;
            this.grilleRemplie = true;
        }

        if (this.grille[0][0].valeur + this.grille[1][1].valeur + this.grille[2][2].valeur == -3
                || this.grille[0][2].valeur + this.grille[1][1].valeur + this.grille[2][1].valeur == -3) {
            retour = 2;
            this.grilleRemplie = true;
        }

        // test de grille bloquée
        if (presenceTotal == 9 && retour == 0) {
            retour = 3;
            this.grilleRemplie = true;
        }

        return retour;

    }

    public HashMap<Integer, String> creerHashMap() {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "this.grille[0][0].valeur");
        map.put(2, "this.grille[0][1].valeur");
        map.put(3, "this.grille[0][2].valeur");
        map.put(4, "this.grille[0][0].valeur");
        map.put(5, "this.grille[1][1].valeur");
        map.put(6, "this.grille[2][2].valeur");
        map.put(7, "this.grille[0][0].valeur");
        map.put(8, "this.grille[1][1].valeur");
        map.put(9, "this.grille[2][2].valeur");

        return map;
    }

    public void fairePartie() {

        HashMap<Integer, String> map = this.creerHashMap();

        boolean finDePartie = false;
        Interaction interaction = new Interaction();
        this.listeJoueur = interaction.creationJoueur();
        grille = new Pion[3][3];

        while (finDePartie == false) {
            int tourDejeux = 0;
            int resultatVerif = 0;
            while (this.grilleRemplie == false || resultatVerif == 3 || resultatVerif == -3) {
                tourDejeux++;
                interaction.afficherGrille(this.grille);

                if (tourDejeux % 2 == 0) {
                    int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[1]);
                    this.grille[coordonneeJeu % 3][1].setPion(this.listeJoueur[1].symbole);
                } else {
                    int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[0]);
                    this.grille[coordonneeJeu % 3][2].setPion(this.listeJoueur[0].symbole);
                }
                resultatVerif = this.verifierGrille();
                interaction.viderEcran();
                System.out.println(resultatVerif);

            }
            if (resultatVerif == 3) {
                System.out.println("Bravo joueur 1 !");
                this.listeJoueur[0].points++;
            } else if (resultatVerif == -3) {
                System.out.println("Bravo joueur 2 !");
                this.listeJoueur[1].points++;
            } else {
                System.out.println("Personne n'a gagné, dommage !");
            }
            finDePartie = interaction.invitNouvellePartie();
        }
        System.out.println("Merci d'avoir joué, à bientôt :)");
    }
}