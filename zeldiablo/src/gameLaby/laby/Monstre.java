package gameLaby.laby;

public class Monstre extends Entite {

    public final static String MONSTRE = "Monstre";

    /**
     * Constructeur du monstre
     *
     * @param dx Position selon x
     * @param dy Position selon y
     */
    public Monstre(int dx, int dy) {
        super(dx, dy);
    }

    /**
     * Permet de savoir si le monstre est en x, y
     *
     * @param dx Position testée
     * @param dy Position testée
     * @return vrai si le monstre est bien en (dx, dy)
     */
    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }
}
