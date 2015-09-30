import s3.tp4herit.Personnage;
import java.util.ArrayList;
import java.util.Iterator;

/** Cette classe g�re des listes de String, elle peut �tre adapt�e pour n'importe quel objet **/

public class File  						
{


private ArrayList <Personnage> F;


File()
{
	F= new ArrayList();
}

/** Est ce que la file est vide ? **/
public boolean estVide() 
{	return F.isEmpty();	
}

public int size()
{
	return F.size();
}

public void add(Personnage e)
{
	F.add(e);
}

/** demontage destructeur **/
public Personnage get()	 
{
	if (!estVide())
	{
		return F.remove(0);						
	}
return null;
}


/** retourne un iterateur voir TestFile.java **/
public Iterator iterator() 
{
	return F.iterator();
}

}