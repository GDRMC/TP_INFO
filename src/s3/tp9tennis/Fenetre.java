package s3.tp9tennis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*; // Pour pouvoir utiliser les fichiers

public class Fenetre extends JFrame implements ActionListener {

    // 3 panneaux constituant la fen�tre    

    private JPanel zoneDessin;            // zone de dessin central ou on va dessiner
    private JPanel p1;                    // zone boutons hauts
    private JPanel p2;                    // zone boutons bas  

    private JTextField txt;            // variable du champs de saisie

    private JTextField afRech;    	  // zone pour afficher
    private Boolean trouve = false;     // bool�en pour savoir si on a trouvé
    private String elementcherche = "";
    private FontMetrics fm;
    private Font police;

    //-------------------------------
    private Arbre Arb;        //!!!!IMPORTANT  noeud racine de l'arbre manipulé et afficher à l'ecran
    //-------------------------------

// CONSTRUCTEUR 
    public Fenetre(String titre, int largeur, int hauteur) {
        super(titre);
        // placer ici l'initialisation de vos structures de données ------------------------------        
        //on initialise l'arbre à afficher
        Arb = new ArbreVide();

        //----------------------------------------------------------------------------------------
        // Construction de la fen�tre
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mise_en_page(largeur, hauteur);   // on place les boutons et la zone de dessin ...

        repaint();                           // on dessine l'ensemble     
    }

// ASSEMBLAGE PARTIES FENETRE : la fenetre est constitu�e de trois parties Panel Nord : boutons ; Sud : boutons; Centre: zone de zoneDessin
    public void mise_en_page(int maxX, int maxY) {
        //--------------------------------------------------------------------
        // insertion boutons du haut
        this.p1 = new JPanel(new GridLayout());
        this.txt = new JTextField("");
        JLabel label = new JLabel("       Valeur :");
        p1.add(label);
        p1.add(txt);
        ajouteBouton("Construire tableau", p1);
        ajouteBouton("Insérer un joueur", p1);
        ajouteBouton("Charger exemple", p1);
        ajouteBouton("Saisir résultat", p1);

        getContentPane().add(p1, "North");  // on ajoute le panel en haut de la fenetre frame

        //--------------------------------------------------------------------
        // insertion boutons du bas
        this.p2 = new JPanel(new GridLayout());
        afRech = new JTextField(3);
        afRech.setFont(new Font("TimesRoman", Font.BOLD, 12));
        afRech.setEditable(false);
        p2.add(afRech);

        ajouteBouton("Rechercher", p2);
        ajouteBouton("Supprimer", p2);
        ajouteBouton("Effacer", p2);
        ajouteBouton("Exemple", p2);
        ajouteBouton("Quitter", p2);

        getContentPane().add(p2, "South");  // on ajoute le panel en bas

        //--------------------------------------------------------------------
        // zone de dessin
        this.zoneDessin = new JPanel();
        this.zoneDessin.setSize(maxX, maxY);
        this.zoneDessin.setPreferredSize(new Dimension(maxX, maxY));
        getContentPane().add(this.zoneDessin, "Center");  // panel pour zoneDessiner au milieu

        //--------------------------------------------------------------------
        setBackground(Color.gray);
        police = new Font("TimesRoman", Font.BOLD, 12);
        fm = getFontMetrics(police);
        setFont(police);

        pack();
        setVisible(true);
    }

// AFFICHAGE A L ECRAN : tout ce qui est dans le paint() sera � l'ecran   
    public void paint(Graphics g) // dessin de la fen�tre g�n�rale
    {
        this.p1.repaint();  // on redessine les boutons hauts
        this.p2.repaint();  // on redessine les boutons bas

        g = this.zoneDessin.getGraphics(); // on redessine dans le panel de dessin

        // c'est ici qu'il faut mettre les elements � afficher
        effacer();
        if (!Arb.estVide()) {
            dessineArbre(g, Arb, 600, 70, 350, 50); //on positionne la racine sur le point (600, 70)
        }
    }

    /**
     * ** M�thode de dessin rattach�es � la m�thode paint()**********************
     */
    public void dessineNoeud(Arbre A, int x, int y, Graphics g, Color c1, Color c2, Color c3) {

        String s;
        if (A.getRacine() != null) {
            s = (String) A.getRacine();
        } else {
            s = "";
        }
        //si le noeud correspond � un noeud contenant une valeur recherch�e
        if ((trouve) && (s.compareTo(elementcherche) == 0)) {
            trouve = false;
            g.setColor(c3);
            g.fillRect(x - 2, y - 2, 30 + fm.stringWidth(s), 30);
        }

        g.setColor(c1);
        //on dessine un oval noir pour le contour en fonction de la taille de la valeur
        g.fillOval(x, y, 25 + fm.stringWidth(s), 25);
        g.setColor(c2);
        g.fillOval(x + 2, y + 2, 21 + fm.stringWidth(s), 21);//on dessine un oval jaune pour l'int�rieur en fonction de la taille de la valeur
        g.setColor(c1);
        g.drawString(s, x + 10, y + 16);  //on dessine la valeur du noeud
    }

    //pour dessiner un arbre on a besoin de la position du noeud à dessiner et du pas en x et y pour dessiner les fils
    public void dessineArbre(Graphics g, Arbre A, int posX, int posY, int pasX, int pasY) {

        if (!A.estVide()) { //si l'arbre existe
            if (!A.getAg().estVide()) { //si il a un fils gauche
                g.setColor(Color.BLACK);
                g.drawLine(posX + 10, posY + 20, posX - pasX / 2, posY + pasY); //on dessine une ligne entre le noeud et le fils gauche
                g.drawLine(posX + 11, posY + 20, posX + 1 - pasX / 2, posY + pasY);
                dessineArbre(g, A.getAg(), posX - pasX / 2 - 10, posY + pasY, (int) (pasX * 0.5), pasY); //on appelle la fonction sur le fils gauche en diminuant la valeur des pas 
            }

            dessineNoeud(A, posX, posY, g, Color.black, Color.yellow, Color.red);

            if (!A.getAd().estVide()) {

                g.setColor(Color.BLACK);

                g.drawLine(posX + 10, posY + 20, posX + 10 + pasX / 2, posY + pasY); //on dessine une ligne entre le noeud et le fils droit
                g.drawLine(posX + 11, posY + 20, posX + 9 + pasX / 2, posY + pasY);
                dessineArbre(g, A.getAd(), posX + pasX / 2, posY + pasY, (int) (pasX * 0.5), pasY);  //on appelle la fonction sur le fils droit en diminuant la valeur du pas
            }
        }

    }

// QUELQUES OUTILS
    // Procdure d'arrêt
    void quitter() {
        System.exit(0);
    }

    // Effacer le plan de dessin
    void effacer() {
        Graphics g = this.zoneDessin.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    // Permet d'ajouter un nouveau bouton dans le panel p
    private void ajouteBouton(String label, JPanel p) {
        // Ajoute un bouton, avec le texte label, au panneau p
        JButton b = new JButton(label);
        p.add(b);
        b.addActionListener(this);
    }

// GESTION DES ACTIONS SUITE A UN APPUIS SUR BOUTON : cette methode est declench�e si Un bouton quelconque est appuy�
    public void actionPerformed(ActionEvent e) // on associe l'evenement souris sur bouton avec l'execution d'un sous prg
    {
        String arg = e.getActionCommand();     // on capte l'evenement : nom du bouton !

        if (arg.equals("Effacer")) {
            effacer();
        }
        if (arg.equals("Quitter")) {
            quitter();
        }

        if (arg.equals("Exemple")) {
            Arb = new ArbreCons("Durand",
                    new ArbreCons("Dubois"),
                    new ArbreCons("Fremond",
                            new ArbreCons("Calobin", new ArbreCons("Calamero"), new ArbreVide()),
                            new ArbreCons("Gramont", new ArbreCons("Bremaud"), new ArbreVide())
                    )
            );
            repaint();
        }
        //bouton recherche
        if (arg.equals("Rechercher")) {
            boolean resultat = false;
            elementcherche = txt.getText();
            if (!Arb.estVide()) {
                resultat = Arb.trouver(elementcherche);
                if (resultat) {
                    afRech.setBackground(Color.green);
                    trouve = true;
                    afRech.setText("Element "+elementcherche+" trouvé");
                } else {
                    afRech.setBackground(Color.red);
                    afRech.setText("Element "+elementcherche+" introuvable");
                }
            }
        }
        //bouton supprimer
        if (arg.equals("Supprimer")) {
            if (txt.getText().compareTo("") != 0) {
                if (!Arb.estVide()) {
                    Arb = Arb.supprimer(new String(txt.getText()));
                    repaint();
                }
            }
        }
        // bouton arbre de niveau 4
        if (arg.equals("Construire tableau")) {

        }

        // inserer feuille
        if (arg.equals("Insérer un joueur")) {

        }

        // saisir resultat match
        if (arg.equals("Saisir résultat")) {

        }
        // cr�ation du tournoi et remplissage 
        if (arg.equals("Charger exemple")) {

            /*Arb = new ArbreCons(3);		
             try{
             FileReader fic = new FileReader("tournoi.txt"); 
             StreamTokenizer entree = new StreamTokenizer(fic);
   
             entree.nextToken() ; 
   
             while ( entree.ttype != entree.TT_EOF ) 
             { 	
             Arb.insereFeuille( entree.sval);
             entree.nextToken() ;	
             }  
             }
             catch (IOException ex){System.out.println("erreur d'IO");};
   
             }
             */
            repaint();
        }
    }
}