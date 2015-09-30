package s3.tp4herit;

/** CLASSE PERSONNAGE **/

public abstract class Personnage
{
	//CONSTANTES -----------------------------------------
	//Type de personnages
	public static final int TYPE_CHEVALIER = 0;
	public static final int TYPE_EXCALIBUR = 1;
	public static final int TYPE_ENCHANTEUR = 2;
	public static final int TYPE_TRUQUEUR = 3;
	private final int NB_TYPES = 4;
	
	//Cibles possibles (partie 2 TP)
	public static final int CIBLE_TETE = 0;
	public static final int CIBLE_VENTRE = 1;
	public static final int CIBLE_JAMBES = 2;
	private final int NB_CIBLES = 3;
	//-----------------------------------------------------

	protected int vie;						// parametre commun a tous les personnages
	protected int typePers;					// type du personnage cr�� selon constantes
	
	public int getVie()
	{
		return this.vie;
	}
	
	protected int Alea(int min, int max)  // tirage au sort entre min et max
	{
		return  min +(int)(Math.random()*(max - min + 1));
	}
	
	public int getType()						// renvoie le type de personnage selon les constantes
	{
		return this.typePers;
	}

	public abstract int attaque();		// renvoie un entier proposionnel � la force de l'attaque
	public abstract void blesse();		// methode diminuant les parametres
	public abstract String toString();	// methode permettant d'afficher un personnage
	
}

abstract class Magicien extends Personnage
{
    int magie;
    
}

abstract class Guerrier extends Personnage
{
    int force;
    
}


class Enchanteur extends Magicien
{
    int aura;
    
    Enchanteur(int vie,int magie,int aura){
        this.vie=vie;
        this.magie=magie;
        this.aura=aura;
        this.typePers=TYPE_ENCHANTEUR;
    }

    public int attaque() {
        int stata = 1/4*this.magie;
        int statb = 1/2*this.aura;
        return this.Alea(0, vie)+this.Alea(0, stata)+this.Alea(0, statb);
    }

    public void blesse() {
        this.vie = vie-Alea(20,40);
    }

    public String toString() {
        return "Personnage: Enchanteur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Magie: "+this.magie+"\n   Aura: "+this.aura;
    }
    
    
}


class Truqueur extends Magicien
{
    int malice;
    
    Truqueur(int vie,int magie,int malice){
        this.vie=vie;
        this.magie=magie;
        this.malice=malice;
        this.typePers=TYPE_TRUQUEUR;
    }

    public int attaque() {
        int stata = 1/6*this.magie;
        int statb = 1*this.malice;
        return this.Alea(0, vie)+this.Alea(0, stata)+this.Alea(0, statb);
    }

    public void blesse() {
        this.vie = vie-Alea(20,40);
    }

    public String toString() {
        return "Personnage: Truqueur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Magie: "+this.magie+"\n   Malice: "+this.malice;
    }
}

class Chevalier extends Guerrier
{
    int courage;
    
    Chevalier(int vie,int force,int courage){
        this.vie=vie;
        this.force=force;
        this.courage=courage;
        this.typePers=TYPE_CHEVALIER;
    }

    public int attaque() {
        int stata = 1/2*this.force;
        int statb = 1/4*this.courage;
        return this.Alea(0, vie)+this.Alea(0, stata)+this.Alea(0, statb);
    }

    public void blesse() {
        this.vie = vie-Alea(20,40);
    }

    public String toString() {
        return "Personnage: Chevalier ("+this.typePers+")\n   Vie: "+this.vie+"\n   Force: "+this.force+"\n   Courage: "+this.courage;
    }
}

class Excalibur extends Guerrier
{
    int agressivite;
    
    Excalibur(int vie, int force, int agressivite){
        this.vie=vie;
        this.force=force;
        this.agressivite=agressivite;
        this.typePers=TYPE_EXCALIBUR;
    }

    public int attaque() {
        int stata = 1*this.force;
        int statb = 1/6*this.agressivite;
        return this.Alea(0, vie)+this.Alea(0, stata)+this.Alea(0, statb);
    }

    public void blesse() {
        this.vie = vie-Alea(20,40);
    }

    public String toString() {
        return "Personnage: Excalibur ("+this.typePers+")\n   Vie: "+this.vie+"\n   Force: "+this.force+"\n   Agressivité: "+this.agressivite;
    }
    
}