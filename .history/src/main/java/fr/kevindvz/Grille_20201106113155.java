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
            switch (this.grille[i][0].valeur + this.grille[i][1].valeur + this.grille[i][2].valeur) {
                case 3:
                    retour = 1;
                    this.grilleRemplie = true;

                case -3:
                    retour = 2;
                    this.grilleRemplie = true;

                    break;

                default:
                    break;
            }
            switch (this.grille[0][i].valeur + this.grille[1][i].valeur + this.grille[2][i].valeur) {
                case 3:
                    retour = 1;
                    this.grilleRemplie = true;
                case -3:
                    retour = 2;
                    this.grilleRemplie = true;
                    break;

                default:
                    break;
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

    public HashMap<Integer, Pion> creerHashMap() {

        HashMap<Integer, Pion> map = new HashMap<>();

        map.put(1, this.grille[0][0]);
        map.put(2, this.grille[0][1]);
        map.put(3, this.grille[0][2]);
        map.put(4, this.grille[1][0]);
        map.put(5, this.grille[1][1]);
        map.put(6, this.grille[1][2]);
        map.put(7, this.grille[2][0]);
        map.put(8, this.grille[2][1]);
        map.put(9, this.grille[2][2]);

        return map;

    }

    public void fairePartie() {

        HashMap<Integer, Pion> map = this.creerHashMap();

        boolean finDePartie = false;
        Interaction interaction = new Interaction();
        this.listeJoueur = interaction.creationJoueur();

        while (finDePartie == false) {
            int tourDejeux = 0;
            int resultatVerif = 0;
            while (this.grilleRemplie == false || resultatVerif == 3 || resultatVerif == -3) {
                tourDejeux++;
                interaction.afficherGrille(this.grille);

                if (tourDejeux % 2 == 0) {
                    int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[1]);
                    Pion pionvise = (Pion) map.get(coordonneeJeu);
                    pionvise.setPion(this.listeJoueur[1].symbole);
                } else {
                    int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[0]);
                    Pion pionvise = (Pion) map.get(coordonneeJeu);
                    pionvise.setPion(this.listeJoueur[0].symbole);
                }
                resultatVerif = this.verifierGrille();
                interaction.viderEcran();
                System.out.println(resultatVerif);

            }
            if (resultatVerif == 1) {
                System.out.println("Bravo joueur 1 !");
                this.listeJoueur[0].points++;
            } else if (resultatVerif == 2) {
                System.out.println("Bravo joueur 2 !");
                this.listeJoueur[1].points++;
            } else if (resultatVerif == 3) {
                System.out.println("Personne n'a gagné, dommage !");
            }
            finDePartie = interaction.invitNouvellePartie();
        }
        System.out.println("Merci d'avoir joué, à bientôt :)");
    }
}