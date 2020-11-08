package fr.kevindvz;

public class Pion {
    char symbole;
    int valeur;
    int presence;

    public Pion() {

        this.symbole = ' ';
        this.valeur = 0;
        this.presence = 0;
    }

    public void setPion(char symbole) {
        if (symbole == 'X' || symbole == 'x') {
            this.symbole = 'X';
            this.valeur = 1;

        } else {
            this.symbole = 'O';
            this.valeur = -1;
        }

    }

    public void getSymbolePion() {
        return this.symbole;
    }
}