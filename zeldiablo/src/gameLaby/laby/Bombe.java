package gameLaby.laby;

public class Bombe extends Entite {

    private long tempsExplosion;

    public Bombe(int dx,int dy) {
        super(dx, dy);
        this.tempsExplosion = System.currentTimeMillis() + 3000; // 3 secondes à partir de maintenant
    }

    public boolean aExplose() {
        return System.currentTimeMillis() >= tempsExplosion;
    }
}
