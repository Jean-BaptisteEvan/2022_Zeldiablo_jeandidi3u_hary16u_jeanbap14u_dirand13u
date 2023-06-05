package gameLaby.laby;

import java.util.ArrayList;

import java.util.ArrayList;

public class Perso extends Entite {


    private final ArrayList<Bombe> bombes;
    private int vie;
    private boolean amuletteTrouve;

    private final Labyrinthe labyrinthe;


    /**
     * Constructeur du personnage
     *
     * @param dx Position selon x
     * @param dy Position selon y
     * @param labyrinthe Le labyrinthe dans lequel se trouve le personnage.
     */
    public Perso(int dx, int dy, Labyrinthe labyrinthe) {
        super(dx, dy);
        this.labyrinthe = labyrinthe;
        this.amuletteTrouve = false;
        this.bombes = new ArrayList<>();
        this.vie = 5;
    }

    /**
     * Pose une bombe à la position actuelle du personnage.
     * Le personnage peut poser jusqu'à 3 bombes maximum.
     * Si une bombe existe déjà à la position du personnage, la bombe ne sera pas posée.
     */
    public void poserBombe() {
        if (bombes.size() >= 3) {
            return; // Limite de bombes atteinte, ne pose pas de bombe
        }

        for (Bombe bombe : bombes) {
            if (this.etrePresent(bombe.getX(), bombe.getY())) {
                return; // Il y a déjà une bombe à cette position, ne pose pas de bombe
            }
        }

        bombes.add(new Bombe(this.x, this.y, labyrinthe));
    }

    /**
     * Supprime une bombe de la liste des bombes du personnage.
     *
     * @param bombe La bombe à supprimer.
     */
    public void supprimerBombe(Bombe bombe) {
        bombes.remove(bombe);
    }

    /**
     *
     * @return Le nombre de points de vie du personnage.
     */
    public int getVie() {
        return vie;
    }

    /**
     *
     * @return true si le personnage a trouvé l'amulette, false sinon.
     */
    public boolean getAmuletteTrouve() {
        return amuletteTrouve;
    }

    /**
     *
     * @return La liste des bombes du personnage.
     */
    public ArrayList<Bombe> getBombes() {
        return bombes;
    }

    /**
     * Modifie le nombre de points de vie du personnage.
     *
     * @param pv La variation de points de vie à appliquer.
     */
    public void setVie(int pv) {
        if (this.vie + pv < 0) {
            this.vie = 0;
        } else {
            this.vie += pv;
        }
    }

    /**
     * Définit si le personnage a trouvé l'amulette.
     * @param t true si le personnage a trouvé l'amulette, false sinon.
     */
    public void setAmuletteTrouve(boolean t) {
        this.amuletteTrouve = t;
    }
}

