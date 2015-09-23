package s3.tp3cafe;

//Classe Groupe ......


public class Groupe{


private int priorite;
private int nbPers;
private int numero;
private int statut;


	Groupe(int num, int nb, int stat, int prio) 
	{
		this.priorite= prio;
		this.numero = num;
		this.nbPers = nb;
		this.statut = stat;
	}

	public String toString()
	{
		return "Num�ro : "+this.numero+ " Nombre de personnes : "+this.nbPers+" Statut : "+this.statut+ "  Priorit� : "+this.priorite;
	}
	
	public int getPrio() {return priorite; }
	
	public void setPrio(int p) {this.priorite=p; }

	public int getNumero() {return numero; }	
	
	public int getNbPers() {return nbPers; }
	
	public int getStatut() {return statut; }
	
	public void setStatut(int s) {this.statut = s; }
	


}