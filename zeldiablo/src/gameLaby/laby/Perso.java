package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso implements Entite{

    public final static String PERSO = "Perso";

    /**
     * position du personnage
     */
    int x, y;

    /**
     * vie du personnage
     */
    private int vie =5;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    public int getVie(){
        return this.vie;
    }

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }


    // ############################################
    // SETTER
    // ############################################

    public void setVie(int pv){
        if(this.vie + pv<0){
            this.vie = 0;
        }else {
            this.vie = this.vie + pv;
        }
    }

}
