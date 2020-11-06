package fr.kevindvz;

/**
 * Hello world!
 */
public final class App {

    private App() {

    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // initialisaton du jeu
        Interaction interaction = new Interaction();
        Grille grille = new Grille();

        // accueil
        interaction.messageIntro();
        grille.fairePartie();

    }
}
