package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import java.io.IOException;

public class LabyJeu implements Jeu {
    private final Labyrinthe labyrinthe;



    /**
     * constructeur par defaut
     */
    public LabyJeu(String nom,int dx,int dy) throws IOException {
        this.labyrinthe = new Labyrinthe(nom);
    }


    @Override
    /**
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {

        // deplace la raquette en fonction des touches
        if (clavier.droite) {
            this.labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        }
        if (clavier.gauche) {
            this.labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
        }
        if (clavier.haut) {
            this.labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        }
        if (clavier.bas) {
            this.labyrinthe.deplacerPerso(Labyrinthe.BAS);
        }
    }


    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    @Override
    public boolean etreFini() {
        // le jeu ne s'arrete jamais
        return false;
    }


    /*#######################################
    # GETTER
    ######################################### */

    public Labyrinthe getLabyrinthe() {
        return this.labyrinthe;
    }

}

