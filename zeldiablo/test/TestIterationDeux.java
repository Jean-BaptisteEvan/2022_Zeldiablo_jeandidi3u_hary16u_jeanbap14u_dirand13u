import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIterationDeux {
    @Test
    public void test_PersoMort(){
        try {
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestPersoMustDie.txt",0,0);
            for(int i = 0;i < 5;i++){
                jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);
            }
            int viePJ = jeuLab.getLabyrinthe().pj.getVie();
            assertEquals(0,viePJ,"le joueur ne devrait plus avoir de vie");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
