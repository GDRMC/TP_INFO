import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
   


public class Fenetre extends JFrame implements ActionListener , MouseListener
{
        
    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  
    
    private Image im;
    private Diapo vacances ;
    
// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur) 
    {
        super(titre);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);          
        mise_en_page( largeur, hauteur );   // on place les boutons et la zone de dessin ...
        
        vacances = new Diapo();              // on charge la structure de données Diapo
        vacances.ajouter("paysage1.jpg");
		  vacances.ajouter("paysage2.jpg");
		  vacances.ajouter("paysage3.jpg");
		  vacances.ajouter("paysage4.jpg");
        
        try{
         im = ImageIO.read(new File("paysage1.jpg"));      // on charge une image
        }
        catch( IOException e ) {e.printStackTrace();}       
        repaint();        
    }
    
// la fenetre est constituée de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    public void mise_en_page(int maxX, int maxY) 
    {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
        ajouteBouton("Suivant", p1);
   	  getContentPane().add(p1,"North");  // on ajoute le panel en haut de la fenetre frame
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("Dessine", p2);
        ajouteBouton("Effacer", p2);
  		  ajouteBouton("Quitter", p2);
		  
		  getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        addMouseListener(this);
        //--------------------------------------------------------------------

        pack();
        setVisible(true);
    }
 
 // Affichage à l'ecran dans Paint() 
    public void paint(Graphics g)   // dessin de la fenêtre générale
    {
        this.p1.repaint();         // on redessine les boutons hauts
        this.p2.repaint();         // on redessine les boutons bas
               
        g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
            
        // c'est ici qu'il faut mettre les elements à afficher à l'ecran
        effacer();
        g.drawImage(im, 50, 10, zoneDessin);
   
    }
         
 // Procédure d'arrêt
    void quitter() {
        System.exit(0);
    }
     
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
     
    
// GESTION DES ACTIONS BOUTONS : cette methode est declenchée si Un bouton quelconque est appuyé
    public void actionPerformed(ActionEvent e)           // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
	 {
      String c = e.getActionCommand();                   // on capte l'evenement : nom du bouton !
        
      					
		if (c.equals("Effacer")) effacer();
      if (c.equals("Quitter")) quitter();		  										
	   if (c.equals("Dessine")) repaint();
      
      if (c.equals("Suivant")) 
      {
         try{
            im = ImageIO.read(new File( vacances.getPhoto() ) );      // on charge une image
           }
           catch( IOException ex ) {ex.printStackTrace();}
            
      }  
      repaint();        
    } 


// GESTION SOURIS : Quels evenements de souris vous voulez traiter ?

    public void mousePressed(MouseEvent e) { }
    
    public void mouseClicked(MouseEvent e){}
    
    public void mouseReleased(MouseEvent e){}
    
    public void mouseEntered(MouseEvent e)
    {
      try{
            im = ImageIO.read(new File( vacances.getPhoto() ) );      // on charge une image
           }
           catch( IOException ex ) {ex.printStackTrace();}  
      repaint();  
    }
    
    public void mouseExited(MouseEvent e){}
    
     
}

