package gameLaby.laby;

public class Monstre implements Entite{

    /**
     * position du monstre
     */
    int x, y;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le monste est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du monstre
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du monstre
     */
    public int getY() {
        //getter
        return this.y;
    }

}
