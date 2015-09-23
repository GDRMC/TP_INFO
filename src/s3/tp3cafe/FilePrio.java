package s3.tp3cafe;

import java.util.ArrayList;

public class FilePrio
{
	private ArrayList <Groupe> L;
	
	FilePrio()
	{
		L=new ArrayList();
	}
	
	public void add( Groupe p )
	{
		int i=0;
		while ((i<L.size()) && (L.get(i).getPrio() <= p.getPrio() ))
		{
			i++;
		}
		L.add(i,p);	
	}

	public boolean isEmpty()
	{
		return (L.size() == 0);
	}

	public int size()
	{
		return L.size();
	}
	
	public Groupe get()
	{
		return  L.remove(0);
	}
	
	public Groupe getEnd()
	{
		return L.remove( L.size()-1);
	}
	
	public int getPrioTete()
	{
		return  L.get(0).getPrio();
	}
	
	public void Afficher()
	{
		for(int i=0; i<L.size(); i++ )
		{
			System.out.println( "  "+L.get( i ).toString() );
		}
		System.out.println();
	}
	
}