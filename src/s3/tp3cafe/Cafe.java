package s3.tp3cafe;

import java.util.*;

public class Cafe
{
	//Declaration des constantes
	 public static final int NbPersGroup = 6;		// les parametres de simulation
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
	public int getNombrePlaces(){ return this.nbPlaces; }
	
	public void ouverture(int nbreGroupe)
	{
            this.FP = new FilePrio();
            for(int i=0;i<nbreGroupe;i++){
                int nbGr = aleatoire(1,6);
                this.FP.add(new Groupe(i,aleatoire(1,NbPersGroup),0,aleatoire(0,DelaiArrivees)));
            }
            FP.Afficher();
	}
	
	
	public void gestion()	// programmation de l'automate
	{
            System.out.println("Ouverture du "+this.nom+"\nNombre de places disponibles: "+this.getNombrePlaces()+" !"+space());
            while(!FP.isEmpty()){
                Groupe g = FP.get();
                
                switch(g.getStatut()){
                    //cas où on doit faire s'asseoir les personnes dans le café s'il y a de la place disponible
                    case 0:
                        if(this.nbPlaces>0){
                            System.out.println("ARRIVEE du groupe n°"+g.getNumero()+space()+"On installe le groupe n°"+g.getNumero());
                            this.nbPlaces=this.getNombrePlaces()-g.getNbPers();
                            System.out.println("Nombre de places disponibles: "+this.getNombrePlaces());
                            g.setStatut(1);
                            FP.add(g);
                        }else{
                            System.out.println(space()+"ON S'EN VA, ACHETEZ PLUS DE CHAISES !\n");
                        }
                        break;
                    case 1:
                        System.out.println(space()+"COMMANDE du groupe n°"+g.getNumero()+" pour "+g.getNbPers()+" personne(s).");
                        g.setStatut(2);
                        FP.add(g);
                        break;
                    case 2:
                        System.out.println(space()+"SERVICE du groupe n°"+g.getNumero()+" pour "+g.getNbPers()+" personne(s).");
                        g.setStatut(3);
                        FP.add(g);
                        break;
                    case 3:
                        System.out.println(space()+"DEPART du groupe n°"+g.getNumero()+", libérant "+g.getNbPers()+" place(s).");
                        this.nbPlaces=this.getNombrePlaces()+g.getNbPers();
                        System.out.println("Nombre de places disponibles: "+this.getNombrePlaces()+space());
                        break;
                }
                
            }
            
	}	

	public void afficherEvts()
	{
		FP.Afficher();
	}
	
	
		
	private int aleatoire(int min, int max)
	{
		return  min +(int)(Math.random()*(max - min + 1));
	}

        //affiche un saut de ligne
        private String space() {
            return "\n";
        }

}

