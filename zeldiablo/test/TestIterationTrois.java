import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestIterationTrois {

    @Test
    public void test_apparitionBombe() {
        try {
            //Initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt", 0, 0);
            Perso perso = jeuLab.getLabyrinthe().pj;

            //Pose de la bombe
            perso.poserBombe();

            //Vérification que la bombe à les meme coordonnée que le perso
            assertTrue(perso.getBombes().get(0).etrePresent(perso.getX(), perso.getY()), "La bombe est censé être au coordonnée de du perso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_CollisionAvecBombe() {
        try {
            //Initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt", 0, 0);
            Labyrinthe laby = jeuLab.getLabyrinthe();

            //Pose de la bombe
            laby.pj.poserBombe();

            //Déplacement afin de faire un demi tour vers la bombe
            laby.deplacerEntite(Labyrinthe.GAUCHE);
            laby.deplacerEntite(Labyrinthe.DROITE);

            //Vérification que la bombe n'as pas les meme coordonnées que le perso
            assertFalse(laby.pj.getBombes().get(0).etrePresent(laby.pj.getX(),laby.pj.getY()), "La bombe est censé être au coordonnée de du perso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_MaxBombe() {
        try {
            //Initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt", 0, 0);
            Labyrinthe laby = jeuLab.getLabyrinthe();

            //Pose des bombes
            laby.pj.poserBombe();
            laby.deplacerEntite(Labyrinthe.GAUCHE);
            laby.pj.poserBombe();
            laby.deplacerEntite(Labyrinthe.GAUCHE);
            laby.pj.poserBombe();
            laby.deplacerEntite(Labyrinthe.GAUCHE);
            laby.pj.poserBombe();

            //Vérification qu'il n'y a que 3 bombes et non 4
            assertEquals(laby.pj.getBombes().size(),3, "La bombe est censé être au coordonnée de du perso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_DisparitionBombe()throws InterruptedException {
        try {
            //Initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt", 0, 0);
            Labyrinthe laby = jeuLab.getLabyrinthe();

            //Pose de la bombe
            laby.pj.poserBombe();
            // Attendre 2 secondes
            Thread.sleep(2000);

            //La bombe est censé ne pas avoir explosé
            assertFalse(laby.pj.getBombes().get(0).aExplose(),"La bombe ne doit pas avoir explosé");

            // Attendre encore 1 seconde
            Thread.sleep(1000);

            //Vérification que la bombe a explosé
            assertTrue(laby.pj.getBombes().get(0).aExplose());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    public void test_ZoneExplosionBombeAucunMur()throws InterruptedException {
//        try {
//            //Initialisation
//            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestBombe.txt", 0, 0);
//            Labyrinthe laby = jeuLab.getLabyrinthe();
//
//
//            //Pose de la bombe
//            laby.pj.poserBombe();
//
//            // Attendre l'explosion
//            Thread.sleep(4000);
//
//            ArrayList<Boolean> mursExplose = new ArrayList<Boolean>();
//
//
//            mursExplose.add(laby.getMurFriables().get(1).etreDetruit());
//
//
//
//            assertFalse(laby.getMurFriables().get(0).etreDetruit(),"Les murs friables sont censé être détruit");
//
//
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }


//    }
}
