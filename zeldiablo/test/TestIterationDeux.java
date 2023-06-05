import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void test_recupereramulette(){
        try {
            //initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestAmulette.txt",0,0);


            //test amulette pas trouvé
            assertFalse(jeuLab.getLabyrinthe().pj.getAmuletteTrouve(),"L'amulette ne doit pas être trouvé par le joueur");

            //déplacement vers l'amulette
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);

            //déplacement pour voir si l'amulette a bien les coordonnées du joueur
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.DROITE);

            //test quand le perso est sur la meme case que l'amulette
            assertTrue(jeuLab.getLabyrinthe().pj.getAmuletteTrouve(), "l'amulette doit etre récuperer par le joueur");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_victoire(){
        try {
            //initialisation
            LabyJeu jeuLab = new LabyJeu("labySimple/labyTestAmulette.txt",0,0);

            //déplacement vers l'amulette
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.GAUCHE);

            //demi-tour vers la case départ avec l'amulette
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.DROITE);
            jeuLab.getLabyrinthe().deplacerEntite(Labyrinthe.DROITE);

            //test le joueur gagne
            assertTrue(jeuLab.getLabyrinthe().etreFini(), "La partie est gagné");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
