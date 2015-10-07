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
        
        for(int i=0;i<NbPredateurs;i++){
            this.lesPredateurs.add(new Predateur(Aleatoire(0, ESPACEVITALX), Aleatoire(0, ESPACEVITALY)));
        }

        maFenetre = new Fenetre("Oh qu'est-ce qu'on est serrés ! Au fond de cette boiteuuuh !", 500, 500, this.lesProies, this.lesPredateurs, 0, Color.RED, Color.BLACK); // Cr ation de la fen tre graphique
        maFenetre.setLocationRelativeTo(null);
    }

    public void simulation(int nb) {
        int temps = 0;
        while (temps != nb) {

            deplacements();
            
            Proie.regenererNourritureProies(5);
            System.out.println("Predateurs :" + this.lesPredateurs.size() + "  Proies :" + this.lesProies.size());

            temps++;
            mortalite();
            reproProies();
            reproPredateurs();
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

        for (int j = 0; j < this.lesPredateurs.size(); j++) {
            (this.lesPredateurs.get(j)).deplacement();
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
        for(int i=0;i<this.lesPredateurs.size();i++){
            for(int j=0;j<this.lesProies.size();j++){
                if(this.lesPredateurs.get(i).getJaugeFaim()<75){
                    if(this.lesPredateurs.get(i).getX()==this.lesProies.get(j).getX()&&this.lesPredateurs.get(i).getY()==this.lesProies.get(j).getY()){
                        this.lesProies.get(j).setVie(0);
                        this.lesPredateurs.get(i).mangerPouasson();
                    }
                }
            }
        }
    }

    private void reproProies() {
        ArrayList<Proie> bebe = new ArrayList();
        
        for(int i=0;i<this.lesProies.size();i++){
            for(int j=0;j<this.lesProies.size();j++){
                if(!(i==j)){
                    if(this.lesProies.get(i).getX()==this.lesProies.get(j).getX()&&this.lesProies.get(i).getY()==this.lesProies.get(j).getY()){
                        int posX = this.lesProies.get(i).getX();
                        int posY = this.lesProies.get(i).getY();
                        if(this.lesProies.get(i).getVie()<=240&&this.lesProies.get(j).getVie()<=240){
                            int rep = Aleatoire(1,2);
                            if(rep == 1){
                                bebe.add(new Proie(posX,posY));
                            } else if (rep == 2){
                                bebe.add(new Proie(posX,posY));
                                bebe.add(new Proie(posX,posY));
                            }
                            
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<bebe.size();i++){
            this.lesProies.add(bebe.get(i));
        }
    }
    
    private void reproPredateurs() {
        ArrayList<Predateur> bebe = new ArrayList();
        
        for(int i=0;i<this.lesPredateurs.size();i++){
            for(int j=0;j<this.lesPredateurs.size();j++){
                if(!(i==j)){
                    if(this.lesPredateurs.get(i).getX()==this.lesPredateurs.get(j).getX()&&this.lesPredateurs.get(i).getY()==this.lesPredateurs.get(j).getY()){
                        int posX = this.lesPredateurs.get(i).getX();
                        int posY = this.lesPredateurs.get(i).getY();
                        if(this.lesPredateurs.get(i).getVie()<=240&&this.lesPredateurs.get(j).getVie()<=240){
                            int rep = Aleatoire(1,2);
                            if(rep == 1){
                                bebe.add(new Predateur(posX,posY));
                            } else if (rep == 2){
                                bebe.add(new Predateur(posX,posY));
                                bebe.add(new Predateur(posX,posY));
                            }
                            
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<bebe.size();i++){
            this.lesPredateurs.add(bebe.get(i));
        }
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
