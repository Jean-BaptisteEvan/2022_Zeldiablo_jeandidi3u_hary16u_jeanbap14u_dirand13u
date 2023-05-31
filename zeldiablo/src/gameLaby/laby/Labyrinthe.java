package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE = 'M';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;

    public Monstre monstre;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */



    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;

                    case MONSTRE:
                        //pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        //ajoute MONSTRE
                        this.monstre = new Monstre(colonne, numeroLigne);
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param entite type d'entite a deplacer
     * @param action une des actions possibles
     *
     */
    public void deplacerEntite(String action) {
        int[] courantePerso = {this.pj.x, this.pj.y};

        // calcule case suivante
        int[] suivante = getSuivant(courantePerso[0], courantePerso[1], action);

        // si c'est ni un mur ni un monstre, on effectue le deplacement du personnage
        if (!this.murs[suivante[0]][suivante[1]] && (this.monstre.getX() != suivante[0] || this.monstre.getY() != suivante[1])) {
            // on met a jour le personnage
            this.pj.x = suivante[0];
            this.pj.y = suivante[1];
        }
        if(etreColler()){
            this.pj.setVie(-1);
        }else {
            String[] actions = {HAUT, BAS, GAUCHE, DROITE};
            String actionAleatoire = actions[(int) (Math.random() * actions.length)];
            int[] couranteMonstre = {this.monstre.x, this.monstre.y};

            //calcule case suivante
            suivante = getSuivant(couranteMonstre[0], couranteMonstre[1], actionAleatoire);

            // si c'est ni un mur ni un personnage, on effectue le deplacement du monstre
            if (!this.murs[suivante[0]][suivante[1]] && (this.pj.getX() != suivante[0] || this.pj.getY() != suivante[1])) {
                // on met a jour le monstre
                this.monstre.x = suivante[0];
                this.monstre.y = suivante[1];
            }
        }
    }

    public boolean etreColler(){
        Monstre m = this.monstre;
        Perso p = this.pj;
        if((m.getX()==p.getX()+1)||(m.getX()==p.getX()-1)||(m.getY()==p.getY()+1)||(m.getY()==p.getY()-1)){
            return true;
        }else{
            return false;
        }
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        int vie = this.pj.getVie();
        if (vie<=0){
            return true;
        }
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }




}
