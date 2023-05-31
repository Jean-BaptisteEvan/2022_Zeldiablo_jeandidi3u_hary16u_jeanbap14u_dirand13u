import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestIterationUn {

    @Test
    public void test_initMonstre(){
        try {
            LabyJeu jeuLab = new LabyJeu("labySimple/labytestMouvP.txt",0,0);
            boolean bPresence = jeuLab.getLabyrinthe().monstre.etrePresent(3,2);
            assertEquals(true,bPresence,"le monstre devrait exister");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test_MouvAleatoireMonstre(){
        try {
            LabyJeu jeuLab = new LabyJeu("labySimple/labytestMouvP.txt",0,0);
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);
            boolean bPresence = jeuLab.getLabyrinthe().monstre.etrePresent(3,2);
            assertEquals(false,bPresence,"le monstre devrait avoir bouger");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test_PersoMouvContreMonstre(){
        try {
            LabyJeu jeuLab = new LabyJeu("labySimple/labytestMouvP.txt",0,0);
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);
            boolean bPresence = jeuLab.getLabyrinthe().pj.etrePresent(2,2);
            assertEquals(false,bPresence,"le monstre devrait avoir bouger");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
