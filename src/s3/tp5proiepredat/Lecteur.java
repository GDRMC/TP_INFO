

import java.util.ArrayList;

public class Lecteur
{
	private String nom;
	private ArrayList <Element> liste;
	
	public Lecteur(String nom)
	{
		this.nom =nom;
		this.liste = new ArrayList();	
	}
	
	public void addElement( Element e)
	{
		this.liste.add(e);
	}
	
	public void afficher()
	{
		System.out.println(this.nom);
		for( int i=0; i<this.liste.size(); i++)
		{
			this.liste.get(i).afficher(1);		
		}
		System.out.println("/");	
	}


}


abstract class Element
{
	public abstract void afficher(int degre);

	protected void tab(int i )
	{
		for(int j=0; j<i; j++)
		{  System.out.print("	"); }
	}

}

class ElementVide 
{
	
}

class Dossier
{
		 
}

class Fichier 
{
		

}

