package gameLaby.laby;

public class Perso extends Entite {

    public final static String PERSONNAGE = "Personnage";

    private int vie = 5;
    private boolean amuletteTrouve;

    /**
     * Constructeur du personnage
     *
     * @param dx Position selon x
     * @param dy Position selon y
     */
    public Perso(int dx, int dy) {
        super(dx, dy);
        this.amuletteTrouve = false;
    }

    /**
     * Permet de savoir si le personnage est en x, y
     *
     * @param dx Position testée
     * @param dy Position testée
     * @return vrai si le personnage est bien en (dx, dy)
     */
    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    public int getVie(){
        return this.vie;
    }

    public boolean getAmuletteTrouve() {
        return amuletteTrouve;
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
    public void setAmuletteTrouve(boolean t){
        this.amuletteTrouve = t;
    }



}
