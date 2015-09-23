package s3.tp3cafe;

import java.util.*;

public class Cafe
{
	//Declaration des constantes
	 public static final int NbPersGroup=6;		// les parametres de simulation
	 public static final int DelaiArrivees = 15;
	 public static final int DelaiComMini = 2; 
	 public static final int DelaiComMaxi = 5;
	 public static final int DelaiServMini = 5 ;
	 public static final int DelaiServMaxi = 10;
	 public static final int DelaiDepMini = 10;
	 public static final int DelaiDepMaxi = 30 ;
	 
	 public static final int STAT_ARRIVEE = 0 ;	// les statuts
	 public static final int STAT_COMMANDE = 1 ;
	 public static final int STAT_SERVICE = 2 ;
	 public static final int STAT_DEPART = 3 ;

	// variable d'instance	

	private int nbPlaces;
	private String nom;
	private FilePrio FP; 
	

	//Constructeurs
	Cafe(String n, int nbPlaces)
	{
		this.nom=n;
		this.nbPlaces=nbPlaces;
	}
	
	//Methodes
	public int getNombrePlaces(){ return this.nbPlaces;}
	
	public void ouverture(int nbreGroupe)
	{
            out("Ouverture du café.");
            this.FP = new FilePrio();
            for(int i=0;i<nbreGroupe;i++){
                int nbGr = aleatoire(1,6);
                this.FP.add(new Groupe(i,aleatoire(1,6),0,aleatoire(1,4)));
            }
            FP.Afficher();
            
	
	
	}
	
	
	public void gestion()	// programmation de l'automate
	{
	
	
	
	
	
			
	}	

	public void afficherEvts()
	{
		FP.Afficher();
	}
	
	
		
	private int aleatoire(int min, int max)
	{
		return  min +(int)(Math.random()*(max - min + 1));
	}

        //affiche un message
        public void out(String str){ System.out.println(str); }

}

