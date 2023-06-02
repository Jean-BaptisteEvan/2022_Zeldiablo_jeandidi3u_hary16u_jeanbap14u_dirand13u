package gameLaby.laby;

public class MurFriable extends Entite{

    boolean destruction;

    public MurFriable(int dx,int dy){
        super(dx,dy);
        this.destruction = false;
    }

    public boolean etreDetruit(){
        return destruction;
    }
    public void setDestruction(boolean dest){
        this.destruction = dest;
    }
}
