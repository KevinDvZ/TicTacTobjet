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

                this.grille[i][j] = new Pion();

            }
        }
        this.etatGrille = "en cours";
    }

    // Initialisation d'une hashmap permettant de viser le bon pion selon l'entrée
    // clavier du joueur
    // Grille numéroté de puis la premiere case de la premire ligne jusqu'à la
    // derniere case de la derniere ligne

    public HashMap<Integer, Pion> creerHashMap(Pion[][] grille) {

        HashMap<Integer, Pion> map = new HashMap<>();

        map.put(1, grille[0][0]);
        map.put(2, grille[0][1]);
        map.put(3, grille[0][2]);
        map.put(4, grille[1][0]);
        map.put(5, grille[1][1]);
        map.put(6, grille[1][2]);
        map.put(7, grille[2][0]);
        map.put(8, grille[2][1]);
        map.put(9, grille[2][2]);

        return map;

    }

    // Verification de la grille en cherchant si il y a des combinaison gagnantes

    private void verifierGrille(HashMap<Integer, Pion> map, int tourDejeux) {

        if (map.get(2).symbole != ' ') {
            if (map.get(1).symbole == map.get(2).symbole && map.get(2).symbole == map.get(3).symbole) {
                this.etatGrille = "BRAVO !";
            }
        }
        if (map.get(5).symbole != ' ') {

            if (map.get(5).symbole == map.get(1).symbole && map.get(5).symbole == map.get(9).symbole) {
                this.etatGrille = "BRAVO ! Joueur " + tourDejeux + " gagne !";
                this.listeJoueur[tourDejeux % 2].points++;
            }
            if (map.get(5).symbole == map.get(4).symbole && map.get(5).symbole == map.get(6).symbole) {
                this.etatGrille = "BRAVO ! Joueur " + tourDejeux + " gagne !";
                this.listeJoueur[tourDejeux % 2].points++;
            }
            if (map.get(5).symbole == map.get(7).symbole && map.get(5).symbole == map.get(3).symbole) {
                this.etatGrille = "BRAVO ! Joueur " + tourDejeux + " gagne !";
                this.listeJoueur[tourDejeux % 2].points++;
            }
            if (map.get(5).symbole == map.get(2).symbole && map.get(5).symbole == map.get(8).symbole) {
                this.etatGrille = "BRAVO ! Joueur " + tourDejeux + " gagne !";
                this.listeJoueur[tourDejeux % 2].points++;
            }
        }
        if (map.get(2).symbole != ' ') {
            if (map.get(1).symbole == map.get(2).symbole && map.get(2).symbole == map.get(3).symbole) {
                this.etatGrille = "BRAVO !";
            }
        }
        if (map.get(2).symbole != ' ') {
            if (map.get(1).symbole == map.get(2).symbole && map.get(2).symbole == map.get(3).symbole) {
                this.etatGrille = "BRAVO !";
            }
        }
    }

    // Lancement des boucles de jeu

    public void fairePartie() {

        boolean finDePartie = false;
        Interaction interaction = new Interaction();
        this.listeJoueur = interaction.creationJoueur();
        int tourDejeux = 0;

        while (finDePartie == false) {
            this.initialiserGrille();
            HashMap<Integer, Pion> map = this.creerHashMap(this.grille);

            while (this.etatGrille == "en cours") {
                tourDejeux++;

                interaction.afficherGrille(this.grille);

                int coordonneeJeu = interaction.recupererNumeroCase(this.listeJoueur[tourDejeux % 2]);
                Pion emplacementvise = (Pion) map.get(coordonneeJeu);

                emplacementvise.setPion(this.listeJoueur[tourDejeux % 2]);

                // emplacementvise.setPion(this.listeJoueur[tourDejeux % 2]);
                this.verifierGrille(map, tourDejeux % 2);
                interaction.viderEcran();
                System.out.println(this.etatGrille);

            }
            interaction.afficherGrille(this.grille);
            System.out.println(this.etatGrille);
            finDePartie = interaction.invitNouvellePartie();
        }
        System.out.println("Merci d'avoir joué, à bientôt :)");
    }
}