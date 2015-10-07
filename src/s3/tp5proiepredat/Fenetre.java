package s3.tp5proiepredat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers
import java.util.ArrayList;
   

public class Fenetre extends JFrame implements ActionListener 
{
   public static final int ESPACEVITALX = 100;
	public static final int ESPACEVITALY = 100;
   // 3 panneaux constituant la fen�tre    
   private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
   private JPanel p1;                    // zone boutons hauts
   private JPanel p2;                    // zone boutons bas  
   
   private Color cProies;
   private Color cPredateurs; 
   
    
   // Structure de donn�es � afficher
	private ArrayList <Proie> lesProies;
	private ArrayList <Predateur> lesPredateurs;
   private int temps;
	
  
// CONSTRUCTEUR 
    
    public Fenetre(String titre, int largeur, int hauteur, ArrayList proies, ArrayList predateurs, int temps, Color couleurProies, Color couleurPredateurs) 
    {
         super(titre);
        // placer ici l'initialisation de vos structures de donn�es ------------------------------        
         this.lesProies = proies;
   		this.lesPredateurs = predateurs;
         this.temps = temps;
         this.cProies = couleurProies;
         this.cPredateurs = couleurPredateurs;
   	
        //----------------------------------------------------------------------------------------
        // Construction de la fen�tre
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                                 
        mise_en_page( largeur, hauteur );   // on place les boutons et la zone de dessin ...
    
        repaint();                           // on dessine l'ensemble  
        
          
   
    }
    

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constitu�e de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    public void mise_en_page(int maxX, int maxY) 
    {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
           	  
  		  getContentPane().add(p1,"North");  // on ajoute le panel en haut de la fenetre frame
        
        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        ajouteBouton("Quitter", p2);
		  
		  getContentPane().add(p2,"South");  // on ajoute le panel en bas
        
        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX,maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX,maxY));
        getContentPane().add(this.zoneDessin,"Center");  // panel pour zoneDessiner au milieu
        
        //--------------------------------------------------------------------

        pack();
        setVisible(true);
    }
    
    public void mise_a_jour(ArrayList proies, ArrayList predateurs, int temps)
    {
         this.lesProies = proies;
   		this.lesPredateurs = predateurs;
         this.temps = temps;
      
    }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera � l'ecran   
    public void paint(Graphics g)  // dessin de la fen�tre g�n�rale
    {
         this.p1.repaint();  // on redessine les boutons hauts
         this.p2.repaint();  // on redessine les boutons bas
            
         g= this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin
        
	      effacer();
         
         // c'est ici qu'il faut mettre les elements � afficher
         g.drawString( "Temps:  "+this.temps+"  NbProies :  "+this.lesProies.size()+"  NbPredateurs:   "+this.lesPredateurs.size(), 100, 20 );
	
		   g.setColor( Color.black );
		   for( int j=0; j< this.lesProies.size(); j++)
		   {
		   	g.fillOval(50+(this.lesProies.get(j)).getX()*4  , 50+(this.lesProies.get(j)).getY()*4, 4,4);
		   }

   
    }


// QUELQUES OUTILS
   
    // Proc�dure d'arr�t
    void quitter() {
        System.exit(0);
    }
    
    // Effacer le plan de dessin
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics(); 
        g.setColor( Color.WHITE );
        g.fillRect(0,0,this.getWidth(),this.getHeight() );
    }
    
    // Permet d'ajouter un nouveau bouton dans le panel p
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    } 
    
       
       
// GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declench�e si Un bouton quelconque est appuy�
    public void actionPerformed(ActionEvent e)  // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
	 {
      String c = e.getActionCommand();     // on capte l'evenement : nom du bouton !
      if (c.equals("Quitter")) quitter();		
		
      repaint();    
    } 
    
}

