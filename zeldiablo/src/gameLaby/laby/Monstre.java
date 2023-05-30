package gameLaby.laby;

public class Monstre implements Entite{

     public final static String MONSTRE = "Monstre";
    /**
     * position du monstre
     */
    int x, y;

    /**
     * constructeur du monstre
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si le monstre est en x,y
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
