package fr.kevindvz;

public class Pion {
    char symbole;
    int valeur;
}

    public Pion() {

        this.symbole = ' ';
        this.valeur = 0;
    }

public void newPion(char symbole){
    if(symbole == 'X' ){
        this.symbole = 'X';
        this.valeur = 1;

    } else {
        this.symbole = '0';
        this.valeur = -1;
    }
    
}