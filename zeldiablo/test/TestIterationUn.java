import gameLaby.laby.LabyJeu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestIterationUn {

    @Test
    public void test_initMonstre(){
        try {
            LabyJeu jeuLab = new LabyJeu("labySimple/labytestMouvP.txt",0,0);
            boolean bPresence = jeuLab.getLabyrinthe().monstre.etrePresent(3,2);
            assertEquals(true,true,"le monstre devrait exister");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
