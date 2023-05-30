package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import moteurJeu.Jeu;
import moteurJeu.DessinJeu;


public class LabyDessin implements DessinJeu {

    public static final int TAILLE = 50;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyrinthe = (LabyJeu) jeu;


        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin Labyrinthe
        gc.setFill(Color.BLACK);
        Labyrinthe laby = labyrinthe.getLabyrinthe();
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if (laby.getMur(i, j)) {
                    gc.fillRect(i * TAILLE, j * TAILLE, TAILLE, TAILLE);
                }
            }
        }
        //dessin perso
        double px = labyrinthe.getLabyrinthe().pj.getX();
        double py = labyrinthe.getLabyrinthe().pj.getY();
        gc.setFill(Color.RED);
        gc.fillOval(px * TAILLE,py * TAILLE,TAILLE,TAILLE);
    }
}


