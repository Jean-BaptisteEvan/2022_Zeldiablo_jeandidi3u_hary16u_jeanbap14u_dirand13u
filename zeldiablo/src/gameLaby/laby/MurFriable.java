package gameLaby.laby;

/**
 * La classe MurFriable représente un mur friable dans le labyrinthe.
 * Un mur friable peut être détruit lorsqu'il est touché par une explosion.
 */
public class MurFriable extends Entite {

    private boolean destruction;

    /**
     * Constructeur de la classe MurFriable.
     *
     * @param dx La position en x du mur friable.
     * @param dy La position en y du mur friable.
     */
    public MurFriable(int dx, int dy) {
        super(dx, dy);
        this.destruction = false;
    }

    /**
     * Vérifie si le mur friable a été détruit.
     *
     * @return true si le mur friable a été détruit, false sinon.
     */
    public boolean etreDetruit() {
        return destruction;
    }

    /**
     * Définit l'état de destruction du mur friable.
     *
     * @param dest true si le mur friable est détruit, false sinon.
     */
    public void setDestruction(boolean dest) {
        this.destruction = dest;
    }
}
