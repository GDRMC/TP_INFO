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


}

