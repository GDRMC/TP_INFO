import java.util.ArrayList;

public class Diapo
{
	private ArrayList <String> photos;
	private int vueCourante;

// constructeur d'objet	
	Diapo()
	{
		this.vueCourante =0;
		this.photos = new ArrayList();
	
	}
// methodes d'instances	
	public void ajouter ( String Nom )
	{
		this.photos.add( Nom );
	}
	
	public int nbPhotos()
	{
		return this.photos.size();
	}
	
	public void reset()
	{
		this.vueCourante = 0;
	}
	
	public String getPhoto()			// renvoit la photo courante
	{
		String laphoto =  this.photos.get( vueCourante);
		this.vueCourante++;
		if (this.vueCourante==photos.size())
			this.vueCourante=0;
		return laphoto;
	}
	
	public String aleaPhoto()
	{
		return this.photos.get( (int) (Math.random()*photos.size())   );	
	}
}