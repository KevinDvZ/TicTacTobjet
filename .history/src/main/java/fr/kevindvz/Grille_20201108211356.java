package fr.kevindvz;

import java.util.HashMap;

public class Grille {
    Joueur listeJoueur[];
    public Pion[][] grille;
    String etatGrille;

    public Grille() {
        grille = new Pion[3][3];
        etatGrille = "non initialisée";

    }

    // on vire les pions de la grille
    public void initialiserGrille() {
        for (int i = 0; i < this.grille.length; i++) {
            for (int j = 0; j < this.grille.length; j++) {

                this.grille[i][j] = null;

            }
        }
        this.etatGrille = "en cours";
    }
    /*
     * // retourne 0 si pas encore de gagnant // retourne 1 si joueur 1 gagne //
     * retourne 2 si joueur 2 gagne // retourne 3 si la grille est bloquée public
     * int verifierGrille() { int retour = 0; int presenceTotal = 0; for (int i = 0;
     * i < 2; i++) {
     * 
     * for (int j = 0; j < grille.length; j++) { presenceTotal +=
     * this.grille[i][j].presence; }
     * 
     * // test des lignes switch (this.grille[i][0].valeur +
     * this.grille[i][1].valeur + this.grille[i][2].valeur) { case 3: retour = 1;
     * this.grilleRemplie = true;
     * 
     * case -3: retour = 2; this.grilleRemplie = true;
     * 
     * break;
     * 
     * default: break; } // test des colonnes switch (this.grille[0][i].valeur +
     * this.grille[1][i].valeur + this.grille[2][i].valeur) { case 3: retour = 1;
     * this.grilleRemplie = true; case -3: retour = 2; this.grilleRemplie = true;
     * break;
     * 
     * default: break; }
     * 
     * }
     * 
     * // test des diagonales
     * 
     * if (this.grille[0][0].valeur + this.grille[1][1].valeur +
     * this.grille[2][2].valeur == 3 || this.grille[0][2].valeur +
     * this.grille[1][1].valeur + this.grille[2][1].valeur == 3) { retour = 1;
     * this.grilleRemplie = true; }
     * 
     * if (this.grille[0][0].valeur + this.grille[1][1].valeur +
     * this.grille[2][2].valeur == -3 || this.grille[0][2].valeur +
     * this.grille[1][1].valeur + this.grille[2][1].valeur == -3) { retour = 2;
     * this.grilleRemplie = true; }
     * 
     * // test de grille bloquée if (presenceTotal == 9 && retour == 0) { retour =
     * 3; this.grilleRemplie = true; }
     * 
     * return retour;
     * 
     * }
     * 
     */

    // Initialisation d'une hashmap permettant de viser le bon pion selon l'entrée
    // clavier du joueur
    // Grille numéroté de puis la premiere case de la premire ligne jusqu'à la
    // derniere case de la derniere ligne

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

    // Verification de la grille en cherchant si il y a des combinaison gagnantes

    private void verifierGrille(HashMap<Integer, Pion> map, int tourDejeux) {
        // utilisation des expression ternaires pour faire les tests
        // rappel ternaire : variableAChanger = Comparé1 test Comparé2 ?
        // resultatAttribuéSivrai : ResultatAttribuésiFaux;
        if (map.get(1) != null) {
            this.etatGrille = map.get(1).symbole == map.get(2).symbole
                    ? map.get(2).symbole == map.get(3).symbole ? ("Joueur " + tourDejeux + " gagnant ! Bravo !")
                            : " en cours"
                    : "en cours";
            this.etatGrille = map.get(1).symbole == map.get(4).symbole
                    ? map.get(4).symbole == map.get(7).symbole ? ("Joueur " + tourDejeux + " gagnant ! Génial !")
                            : " en cours"
                    : "en cours";
            this.etatGrille = map.get(1).symbole == map.get(5).symbole ? map.get(5).symbole == map.get(9).symbole
                    ? ("Joueur " + tourDejeux + " gagnant ! You're the greatest !")
                    : " en cours" : "en cours";
        }
        if (map.get(3) != null) {
            this.etatGrille = map.get(3).symbole == map.get(5).symbole
                    ? map.get(5).symbole == map.get(7).symbole ? ("Joueur " + tourDejeux + " gagnant ! Extraordinary !")
                            : " en cours"
                    : "en cours";
            this.etatGrille = map.get(3).symbole == map.get(6).symbole
                    ? map.get(6).symbole == map.get(9).symbole ? ("Joueur " + tourDejeux + " gagnant ! Marvellous !")
                            : " en cours"
                    : "en cours";
        }
        if (map.get(8) != null) {
            this.etatGrille = map.get(2).symbole == map.get(5).symbole
                    ? map.get(5) == map.get(8) ? ("Joueur " + tourDejeux + " gagnant  OH YEAH !") : " en cours"
                    : "en cours";
            this.etatGrille = map.get(7).symbole == map.get(8).symbole ? map.get(8).symbole == map.get(9).symbole
                    ? ("Joueur " + tourDejeux + " gagnant ! You are the champion !")
                    : " en cours" : "en cours";
        }
        if (map.get(5) != null) {
            this.etatGrille = map.get(4).symbole == map.get(5).symbole ? map.get(5).symbole == map.get(6).symbole
                    ? ("Joueur " + tourDejeux + " gagnant ! Hop, un point de plus !")
                    : " en cours" : "en cours";
        }

    }

    // Lancement des boucles de jeu

    public void fairePartie() {

        HashMap<Integer, Pion> map = this.creerHashMap();

        boolean finDePartie = false;
        Interaction interaction = new Interaction();
        this.listeJoueur = interaction.creationJoueur();
        int tourDejeux = 0;

        while (finDePartie == false) {
            this.initialiserGrille();

            while (this.etatGrille == "en cours") {
                tourDejeux++;

                interaction.afficherGrille(this.grille);

                int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[tourDejeux % 2]);
                Pion emplacementvise = (Pion) map.get(coordonneeJeu);
                emplacementvise = new Pion();

                emplacementvise.setPion(this.listeJoueur[tourDejeux % 2]);
                this.verifierGrille(map, tourDejeux % 2);
                interaction.viderEcran();
                System.out.println(emplacementvise.symbole);

            }

            finDePartie = interaction.invitNouvellePartie();
        }
        System.out.println("Merci d'avoir joué, à bientôt :)");
    }
}