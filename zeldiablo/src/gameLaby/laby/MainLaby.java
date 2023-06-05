package gameLaby.laby;



import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby  {

    public static void main(String[] args) throws IOException {


        // creation des objets
        LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt",0,0);
        LabyDessin dessinLab = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(LabyDessin.TAILLE * jeuLab.getLabyrinthe().getLength(),LabyDessin.TAILLE * jeuLab.getLabyrinthe().getLengthY());
        MoteurJeu.setFPS(10);

        // lancement du jeu
        MoteurJeu.launch(jeuLab, dessinLab);
    }
}
