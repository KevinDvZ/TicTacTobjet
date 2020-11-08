package fr.kevindvz;

public class Pion {
    char symbole;

    public Pion() {

        this.symbole = 'p';

    }

    // le symbole du pion differera selon le joueur qui le "set"
    public void setPion(Joueur joueur) {

        this.symbole = joueur.symbole;
    }

    public char getSymbolePion() {
        return this.symbole;
    }
}