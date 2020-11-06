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

    public void viderEcran() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    // Invitation creation joueur

    public Joueur[] creationJoueur() {
        System.out.println("Veuillez entre votre nom Joueur 1 :");
        String nomClavier = clavier.nextLine();
        Joueur joueur1 = new Joueur(nomClavier);
        joueur1.symbole = 'X';
        System.out.println("Veuillez entre votre nom Joueur 2 :");
        nomClavier = clavier.nextLine();
        Joueur joueur2 = new Joueur(nomClavier);
        joueur2.symbole = 'O';
        Joueur[] listeJoueur = new Joueur[2];
        listeJoueur[0] = joueur1;
        listeJoueur[1] = joueur2;
        return listeJoueur;

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

        while (!CoordoneeClavier.matches("^[1-9]")) {
            System.out.println("Vous devez entrer un chiffre entre 1 & 9");
            CoordoneeClavier = clavier.nextLine();

        }

        int coordonneeInt = Integer.parseInt(CoordoneeClavier);
        return coordonneeInt;

    }

    public Boolean invitNouvellePartie() {
        System.out.println("Souhaitez-vous faire une nouvelle partie ? O | N");
        String clavierEntre = this.clavier.next();
        while (!clavierEntre.matches("^[o,O,n,N]") || clavierEntre.length() != 1) {
            System.out.println("erreur : veuillez entre O ou N.");
            clavierEntre = this.clavier.next();
        }
        if (clavierEntre.matches("^[o,O]") == true) {
            return false;
        } else {
            return true;
        }
    }
}