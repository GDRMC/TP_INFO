package s3.tp5proiepredat;

import java.util.ArrayList;
import java.awt.*;

public class Aquarium {

    public static final int PASMAXPROIES = 4;
    public static final int ESPACEVITALX = 100;
    public static final int ESPACEVITALY = 100;
    public static final int DUREEVIE = 100;

    private ArrayList<Proie> lesProies;
    private ArrayList<Predateur> lesPredateurs;

    private Fenetre maFenetre;  //une vue graphique

    Aquarium(int NbProies, int NbPredateurs) {
        lesProies = new ArrayList();
        this.lesPredateurs = new ArrayList();

        for(int i=0;i<NbProies;i++){
            this.lesProies.add(new Proie(Aleatoire(0, ESPACEVITALX), Aleatoire(0, ESPACEVITALY)));
        }


        maFenetre = new Fenetre("L'Aquarium de La Rochelle", 500, 500, this.lesProies, this.lesPredateurs, 0, Color.RED, Color.BLACK); // Cr ation de la fen tre graphique

    }

    public void simulation(int nb) {
        int temps = 0;
        while (temps != nb) {

            deplacements();
            
            Proie.regenererNourritureProies(5);
            System.out.println("Predateurs :" + this.lesPredateurs.size() + "  Proies :" + this.lesProies.size());

            temps++;
            mortalite();
            // affichage dans la vue
            maFenetre.mise_a_jour(this.lesProies, this.lesPredateurs, temps); // mise en jour des variables mod le
            maFenetre.repaint(); // on redessine la vue
            try {
                Thread.sleep(100);   // on ralentit la simulation 0.1s ici
            } catch (InterruptedException e) {
                
            }

        }
    }

    private void deplacements() {
        for (int j = 0; j < this.lesProies.size(); j++) {
            (this.lesProies.get(j)).deplacement();
        }

    }

    private void mortalite() {
        // 1) vielles proies
        for(int i=0;i<this.lesProies.size();i++){
            if(this.lesProies.get(i).getVie()<=0){
                this.lesProies.remove(i);
            }
        }
         // 2) vieux predateurs
        for(int i=0;i<this.lesPredateurs.size();i++){
            if(this.lesPredateurs.get(i).getVie()<=0){
                this.lesPredateurs.remove(i);
            }
        }
         // 3) predation
        
    }

    private void reproProies() {
        ArrayList<Proie> bebe = new ArrayList();

    }

    private int Aleatoire(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }

    private boolean probaRealisation(double pourcentage) {
        double val = Math.random();
        if (val <= pourcentage) {
            return true;
        } else {
            return false;
        }

    }

}
