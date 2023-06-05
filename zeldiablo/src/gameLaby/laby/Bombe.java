package gameLaby.laby;

import gameLaby.laby.MurFriable;
import java.util.ArrayList;

/**
 * La classe Bombe représente une bombe placee dans le jeu du labyrinthe.
 * Elle hérite de la classe Entite et définit le comportement specifique des bombes, notamment l'explosion et l'impact sur les autres entités.
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
     * Vérifie si la bombe a explose.
     * Si la bombe a explosé, elle impacte les cases autour d'elle et peut affecter les autres entités.
     * @return true si la bombe a explosé, sinon false
     */
    public boolean aExplose() {
        // Vérifie si le temps actuel est supérieur ou égal au temps d'explosion
        if (System.currentTimeMillis() >= tempsExplosion) {
            // Calcule les cases qui seront impactées par l'explosion de la bombe
            calculerCasesExplosion();
            // Vérifie l'impact de l'explosion sur les autres entités
            verifierImpactExplosion();
            // La bombe a explosé
            return true;
        }
        // La bombe n'a pas encore explosé
        return false;
    }

    /**
     * Détermine les cases qui seront impactees par l'explosion de la bombe.
     */
    private void calculerCasesExplosion() {
        // Récupère les coordonnées x et y de la bombe
        int x = getX();
        int y = getY();

        // Parcourt les cases dans la direction vers le haut jusqu'à une distance de 3 cases
        for (int i = y - 1; i >= y - 3; i--) {
            // Vérifie si la case est un mur
            if(!labyrinthe.getMur(x,i)){
                // Ajoute la case à la liste des cases d'explosion
                casesExplosion.add(new int[]{x, i});
            } else {
                // Arrête la boucle si la case est un mur
                break;
            }
        }

        // Parcourt les cases dans la direction vers le bas jusqu'à une distance de 3 cases
        for (int i = y + 1; i <= y + 3; i++) {
            // Vérifie si la case est un mur
            if(!labyrinthe.getMur(x,i)){
                // Ajoute la case à la liste des cases d'explosion
                casesExplosion.add(new int[]{x, i});
            } else {
                // Arrête la boucle si la case est un mur
                break;
            }
        }

        // Parcourt les cases dans la direction vers la gauche jusqu'à une distance de 3 cases
        for (int i = x - 1; i >= x - 3; i--) {
            // Vérifie si la case est un mur
            if(!labyrinthe.getMur(i,y)){
                // Ajoute la case à la liste des cases d'explosion
                casesExplosion.add(new int[]{i, y});
            } else {
                // Arrête la boucle si la case est un mur
                break;
            }
        }

        // Parcourt les cases dans la direction vers la droite jusqu'à une distance de 3 cases
        for (int i = x + 1; i <= x + 3; i++) {
            // Vérifie si la case est un mur
            if(!labyrinthe.getMur(i,y)){
                // Ajoute la case à la liste des cases d'explosion
                casesExplosion.add(new int[]{i, y});
            } else {
                // Arrête la boucle si la case est un mur
                break;
            }
        }
    }

    /**
     * Vérifie l'impact de l'explosion sur les autres entités du labyrinthe.
     */
    private void verifierImpactExplosion() {
        // Parcourt les cases d'explosion
        for (int[] caseExplosion : casesExplosion) {
            // Récupère les coordonnées x et y de la case d'explosion
            int expX = caseExplosion[0];
            int expY = caseExplosion[1];

            // Vérifie si la case d'explosion correspond à la position actuelle de la bombe
            if (expX == this.x && expY == this.y) {
                // Si c'est le cas, ignore cette case
                return;
            }

            // Parcourt les murs friables du labyrinthe
            for (MurFriable murFriable : labyrinthe.getMurFriables()) {
                // Vérifie si le mur friable est présent sur la case d'explosion et n'a pas déjà été détruit
                if (murFriable.etrePresent(expX, expY) && !murFriable.etreDetruit()) {
                    // Définit le mur friable comme détruit
                    murFriable.setDestruction(true);
                }
            }

            // Vérifie si le personnage du labyrinthe est présent sur la case d'explosion
            if(labyrinthe.getLabyrinthe().pj.etrePresent(expX,expY)){
                // Réduit la vie du personnage de 2 points
                labyrinthe.getLabyrinthe().pj.setVie(- 2);
            }
        }
    }
}
