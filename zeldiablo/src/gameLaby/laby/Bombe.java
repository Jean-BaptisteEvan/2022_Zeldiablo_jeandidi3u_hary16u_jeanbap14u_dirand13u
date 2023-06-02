package gameLaby.laby;

import java.util.ArrayList;

public class Bombe extends Entite {

    ArrayList<int[]> casesExplosion;
    private long tempsExplosion;

    public Bombe(int dx,int dy) {
        super(dx, dy);
        this.tempsExplosion = System.currentTimeMillis() + 3000;
        this.casesExplosion = new ArrayList<>();
    }

    public boolean aExplose() {
        if (System.currentTimeMillis() >= tempsExplosion) {
            // La bombe a explosé, on ajoute les cases de l'explosion à la liste
            int x = getX();
            int y = getY();

            // Ajouter les cases au-dessus de la bombe
            for (int i = y - 1; i >= y - 3; i--) {
                casesExplosion.add(new int[]{x, i});
            }

            // Ajouter les cases en-dessous de la bombe
            for (int i = y + 1; i <= y + 3; i++) {
                casesExplosion.add(new int[]{x, i});
            }

            // Ajouter les cases à gauche de la bombe
            for (int i = x - 1; i >= x - 3; i--) {
                casesExplosion.add(new int[]{i, y});
            }

            // Ajouter les cases à droite de la bombe
            for (int i = x + 1; i <= x + 3; i++) {
                casesExplosion.add(new int[]{i, y});
            }

            return true;
        }
        return false;
    }
}
