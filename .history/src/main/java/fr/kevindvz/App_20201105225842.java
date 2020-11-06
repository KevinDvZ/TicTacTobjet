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
        Interaction interaction = new Interaction();
        Grille grille = new Grille();

        interaction.afficherGrille(grille.grille);
        ;
        System.out.println("Hello World!");

    }
}
