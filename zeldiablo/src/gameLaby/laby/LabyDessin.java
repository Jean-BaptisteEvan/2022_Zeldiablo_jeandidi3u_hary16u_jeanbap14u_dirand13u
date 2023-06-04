package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

/**
 * permet d'afficher un jeu de type arkanoid
 */
public class LabyDessin implements DessinJeu {

    public static final int TAILLE = 50;


    /**
     * affichage d'un jeu de type arkanoid
     *
     * @param canvas dessin dans lequel dessin
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyrinthe = (LabyJeu) jeu;


        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // dessin Labyrinthe
        gc.setFill(Color.rgb(30,30,30));
        Labyrinthe laby = labyrinthe.getLabyrinthe();
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if (laby.getMur(i, j)) {
                    gc.fillRect(i * TAILLE, j * TAILLE, TAILLE, TAILLE);
                }
            }
        }
        //dessin depart
        double px = labyrinthe.getLabyrinthe().depart.getX();
        double py = labyrinthe.getLabyrinthe().depart.getY();
        gc.setFill(Color.YELLOW);
        gc.fillRect(px * TAILLE, py * TAILLE, TAILLE, TAILLE);

        //dessin perso
        px = labyrinthe.getLabyrinthe().pj.getX();
        py = labyrinthe.getLabyrinthe().pj.getY();

        gc.setFill(Color.RED);
        gc.fillOval(px * TAILLE,py * TAILLE,TAILLE,TAILLE);

        //dessin monstre
        px = labyrinthe.getLabyrinthe().monstre.getX();
        py = labyrinthe.getLabyrinthe().monstre.getY();
        gc.setFill(Color.PURPLE);
        gc.fillOval(px * TAILLE,py * TAILLE,TAILLE,TAILLE);


        //dessin Amulette
        px = labyrinthe.getLabyrinthe().amulette.getX();
        py = labyrinthe.getLabyrinthe().amulette.getY();
        gc.setFill(Color.GREEN);
        gc.fillOval(px * TAILLE+(TAILLE*0.25), py * TAILLE + (TAILLE*0.5), TAILLE*0.5, TAILLE * 0.5);


        //dessin MurFriable
        ArrayList<MurFriable> murfri = laby.getMurFriables();
        for (int i = 0; i < murfri.size(); i++) {
            MurFriable murF = murfri.get(i);
            if(murF.etreDetruit()){
                gc.setFill(Color.rgb(128,128,128,0.10));
            }else{
                gc.setFill(Color.rgb(64,64,64,0.50));
            }
            gc.fillRect(murF.getX() * TAILLE, murF.getY() * TAILLE, TAILLE, TAILLE);
        }


        // dessin Bombe
        gc.setFill(Color.rgb(106,66,29));
        ArrayList bombes = labyrinthe.getLabyrinthe().pj.getBombes();
        for (int i = 0; i < bombes.size(); i++) {
            Bombe bombe = labyrinthe.getLabyrinthe().pj.getBombes().get(i);
            gc.fillOval(bombe.getX() * TAILLE + TAILLE * 0.1 , bombe.getY() * TAILLE + TAILLE * 0.1 , TAILLE * 0.8, TAILLE * 0.8);
        }
    }
}


