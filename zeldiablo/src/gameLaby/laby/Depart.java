package gameLaby.laby;

public class Depart extends Entite {

    public final static String AMULETTE = "Amulette";

    /**
     * Constructeur de l'amulette
     *
     * @param dx Position selon x
     * @param dy Position selon y
     */
    public Depart(int dx, int dy) {
        super(dx,dy);
    }

    /**
     * Permet de savoir si l'amulette est en x, y
     *
     * @param dx Position testée
     * @param dy Position testée
     * @return vrai si l'amulette est bien en (dx, dy)
     */
    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }
}