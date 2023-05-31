package gameLaby.laby;

public class Amulette implements Entite {
    public final static String AMULETTE = "Amulette";
    /**
     * position de l'amulette
     */
    int x, y;

    /**
     * constructeur de l'amulette
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Amulette(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si l'amulette est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le monstre est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x de l'amulette
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y de l'amulette
     */
    public int getY() {
        //getter
        return this.y;
    }


}
