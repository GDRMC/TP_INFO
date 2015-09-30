package s3.tp4herit;

import java.util.ArrayList;
import java.util.Iterator;


public class File  						
{


private ArrayList <Personnage> F;


File()
{
	F= new ArrayList();
}

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


public Personnage get()	 
{
	if (!estVide())
	{
		return F.remove(0);						
	}
return null;
}


public Iterator iterator() 
{
	return F.iterator();
}

}