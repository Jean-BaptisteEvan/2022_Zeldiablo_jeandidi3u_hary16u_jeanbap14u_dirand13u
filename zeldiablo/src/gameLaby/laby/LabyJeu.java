package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.ArrayList;

public class LabyJeu implements Jeu {
    private final Labyrinthe labyrinthe;

    /**
     * Constructeur de la classe LabyJeu.
     *
     * @param nom Le nom du fichier contenant la configuration du labyrinthe.
     * @param dx  La position initiale selon l'axe x du personnage.
     * @param dy  La position initiale selon l'axe y du personnage.
     * @throws IOException Si une erreur de lecture du fichier se produit.
     */
    public LabyJeu(String nom, int dx, int dy) throws IOException {
        this.labyrinthe = new Labyrinthe(nom);
    }

    @Override
    public void update(double deltaTime, Clavier clavier) {
        if (clavier.haut || clavier.hautEnAttente) {
            // Effectuer l'action correspondant à la touche haut
            this.labyrinthe.deplacerEntite(Labyrinthe.HAUT);
            clavier.hautEnAttente = false;
        }
        if (clavier.bas || clavier.basEnAttente) {
            // Effectuer l'action correspondant à la touche bas
            this.labyrinthe.deplacerEntite(Labyrinthe.BAS);
            clavier.basEnAttente = false;
        }
        if (clavier.gauche || clavier.gaucheEnAttente) {
            // Effectuer l'action correspondant à la touche gauche
            this.labyrinthe.deplacerEntite(Labyrinthe.GAUCHE);
            clavier.gaucheEnAttente = false;
        }
        if (clavier.droite || clavier.droiteEnAttente) {
            // Effectuer l'action correspondant à la touche droite
            this.labyrinthe.deplacerEntite(Labyrinthe.DROITE);
            clavier.droiteEnAttente = false;
        }
        if (clavier.espace || clavier.espaceEnAttente) {
            // Effectuer l'action correspondant à la touche espace
            this.labyrinthe.getLabyrinthe().pj.poserBombe();
            clavier.espaceEnAttente = false;
        }

        ArrayList<Bombe> bombes = this.labyrinthe.getLabyrinthe().pj.getBombes();
        ArrayList<Bombe> bombesASupprimer = new ArrayList<>();

        for (Bombe bombe : bombes) {
            if (bombe.aExplose()) {
                bombesASupprimer.add(bombe);
            }
        }

        for (Bombe bombe : bombesASupprimer) {
            this.labyrinthe.getLabyrinthe().pj.supprimerBombe(bombe);
        }
    }

    @Override
    public void init() {
        // Pas d'initialisation particulière
    }

    @Override
    public boolean etreFini() {
        return this.labyrinthe.etreFini();
    }

    /**
     * Obtient le labyrinthe associé au jeu.
     *
     * @return Le labyrinthe associé au jeu.
     */
    public Labyrinthe getLabyrinthe() {
        return this.labyrinthe;
    }
}
