package gameLaby.laby;

import java.util.ArrayList;

public class Perso extends Entite {

    public final static String PERSONNAGE = "Personnage";

    private final ArrayList<Bombe> bombes;

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
        this.bombes = new ArrayList<>();
    }


    public void poserBombe() {
        if (bombes.size() >= 3) {
            return; // Limite de bombes atteinte, ne pose pas de bombe
        }

        for (Bombe bombe : bombes) {
            if (this.etrePresent(bombe.getX(), bombe.getY())) {
                return; // Il y a déjà une bombe à cette position, ne pose pas de bombe
            }
        }

        bombes.add(new Bombe(this.x, this.y));
    }

    public void supprimerBombe(Bombe bombe) {
        bombes.remove(bombe);
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

    public ArrayList<Bombe> getBombes(){
        return this.bombes;
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
