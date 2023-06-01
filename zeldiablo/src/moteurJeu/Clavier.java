package moteurJeu;

import javafx.scene.input.KeyEvent;

public class Clavier {

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite, espace;
    public boolean hautEnAttente, basEnAttente, gaucheEnAttente, droiteEnAttente, espaceEnAttente;

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {
        switch (event.getCode()) {
            case S:
                if (!bas) {
                    basEnAttente = true;
                }
                break;
            case Z:
                if (!haut) {
                    hautEnAttente = true;
                }
                break;
            case Q:
                if (!gauche) {
                    gaucheEnAttente = true;
                }
                break;
            case D:
                if (!droite) {
                    droiteEnAttente = true;
                }
                break;
            case SPACE:
                if (!espace) {
                    espaceEnAttente = true;
                }
                break;
        }
    }

    public void relacherTouche(KeyEvent event) {
        switch (event.getCode()) {
            case S:
                basEnAttente = false;
                break;
            case Z:
                hautEnAttente = false;
                break;
            case Q:
                gaucheEnAttente = false;
                break;
            case D:
                droiteEnAttente = false;
                break;
            case SPACE:
                espaceEnAttente = false;
                break;
        }
    }



    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */


}
