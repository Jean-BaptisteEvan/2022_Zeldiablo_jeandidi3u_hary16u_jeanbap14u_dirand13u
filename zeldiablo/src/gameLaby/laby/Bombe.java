package gameLaby.laby;

import gameLaby.laby.MurFriable;
import java.util.ArrayList;

/**
 * La classe Bombe représente une bombe placée dans le jeu du labyrinthe.
 * Elle hérite de la classe Entite et définit le comportement spécifique des bombes, notamment l'explosion et l'impact sur les autres entités.
 */
public class Bombe extends Entite {
    private final Labyrinthe labyrinthe;
    private final ArrayList<int[]> casesExplosion;
    private final long tempsExplosion;

    /**
     * Constructeur de la classe Bombe.
     * @param dx la coordonnée x de la bombe
     * @param dy la coordonnée y de la bombe
     * @param labyrinthe le labyrinthe dans lequel la bombe est placée
     */
    public Bombe(int dx, int dy, Labyrinthe labyrinthe) {
        super(dx, dy);
        this.labyrinthe = labyrinthe;
        this.tempsExplosion = System.currentTimeMillis() + 3000;
        this.casesExplosion = new ArrayList<>();
    }

    /**
     * Vérifie si la bombe a explosé.
     * Si la bombe a explosé, elle impacte les cases autour d'elle et peut affecter les autres entités.
     * @return true si la bombe a explosé, sinon false
     */
    public boolean aExplose() {
        if (System.currentTimeMillis() >= tempsExplosion) {
            calculerCasesExplosion();
            verifierImpactExplosion();
            return true;
        }
        return false;
    }

    /**
     * Calcule les cases qui seront impactées par l'explosion de la bombe.
     */
    private void calculerCasesExplosion() {
        int x = getX();
        int y = getY();

        for (int i = y - 1; i >= y - 3; i--) {
            if(!labyrinthe.getMur(x,i)){
                casesExplosion.add(new int[]{x, i});
            } else {
                break;
            }
        }

        for (int i = y + 1; i <= y + 3; i++) {
            if(!labyrinthe.getMur(x,i)){
                casesExplosion.add(new int[]{x, i});
            } else {
                break;
            }
        }

        for (int i = x - 1; i >= x - 3; i--) {
            if(!labyrinthe.getMur(i,y)){
                casesExplosion.add(new int[]{i, y});
            } else {
                break;
            }
        }

        for (int i = x + 1; i <= x + 3; i++) {
            if(!labyrinthe.getMur(i,y)){
                casesExplosion.add(new int[]{i, y});
            } else {
                break;
            }
        }
    }

    /**
     * Vérifie l'impact de l'explosion sur les autres entités du labyrinthe.
     */
    private void verifierImpactExplosion() {
        for (int[] caseExplosion : casesExplosion) {
            int expX = caseExplosion[0];
            int expY = caseExplosion[1];

            if (expX == getX() && expY == getY()) {
                return;
            }

            for (MurFriable murFriable : labyrinthe.getMurFriables()) {
                if (murFriable.etrePresent(expX, expY) && !murFriable.etreDetruit()) {
                    murFriable.setDestruction(true);
                }
            }

            if(labyrinthe.getLabyrinthe().pj.etrePresent(expX,expY)){
                labyrinthe.getLabyrinthe().pj.setVie(- 2);
            }
        }
    }
}
