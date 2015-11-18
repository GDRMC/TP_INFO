package s3.tp9tennis;

/**
 * Classe Arbre
 * @author USER
 */
public abstract class Arbre {

    /**
     *
     * @return
     */
    public abstract String getRacine();

    /**
     *
     * @return
     */
    public abstract Arbre getAg();

    /**
     *
     * @return
     */
    public abstract Arbre getAd();
    
    /**
     *
     * @param s
     */
    public abstract void setRacine(String s);

    /**
     *
     * @param Ag
     */
    public abstract void setAg(Arbre Ag);

    /**
     *
     * @param Ad
     */
    public abstract void setAd(Arbre Ad);
    
    /**
     *
     * @return
     */
    public abstract boolean estVide();
    
    /**
     *
     */
    public abstract void afficheGRD();
    
    /**
     *
     * @return
     */
    public abstract String lePlusAGauche();

    /**
     *
     * @return
     */
    public abstract String lePlusADroite();
    
    /**
     *
     * @param valeur
     * @return
     */
    public abstract Arbre supprimer(String valeur);
    
    /**
     *
     * @param element
     * @return
     */
    public abstract boolean trouver(String element);
    
    /**
     *
     * @return
     */
    public abstract boolean estFeuille();
    
    /**
     *
     * @return
     */
    public abstract int nbFeuille();
    
    /**
     *
     * @return
     */
    public abstract int nbNoeuds();

    /**
     *
     * @return
     */
    public abstract int hauteur();
    
    /**
     *
     * @param str
     * @return
     */
    public abstract boolean insereFeuille(String str);
    
    /**
     *
     * @param str
     * @return
     */
    public abstract void placerGagnant(String str);
}

class ArbreVide extends Arbre {
    
    public boolean estVide(){
        return true;
    }
    
    ArbreVide(){ }
    
    public void afficheGRD(){
        //System.out.println("");
    }
    
    public int nbFeuille(int nb){
        return nb;
    }

    public String getRacine() {
        return "";
    }

    public Arbre getAg() {
        return new ArbreVide();
    }

    public Arbre getAd() {
        return new ArbreVide();
    }

    public void setRacine(String s) {
        
    }

    public void setAg(Arbre Ag) {
        
    }

    public void setAd(Arbre Ad) {
        
    }

    public String lePlusAGauche() {
        return "";
    }

    public String lePlusADroite() {
        return "";
    }

    public boolean trouver(String element) {
        return false;
    }

    public boolean estFeuille() {
        return false;
    }

    public int nbFeuille() {
        return 0;
    }
    
    public Arbre supprimer(String valeur){
        return new ArbreVide();
    }
    
    public int nbNoeuds() {
        return 0;
    }

    public int hauteur() {
        return 0;
    }
    
    public boolean insereFeuille(String str){
        return false;
    }
    
    public void placerGagnant(String str){
        
    }
}

class ArbreCons extends Arbre {
    private String racine;
    private Arbre Ag;
    private Arbre Ad;
    
    public boolean estVide(){
        return false;
    }
    
    ArbreCons(String val, Arbre Ag, Arbre Ad) {
        this.racine = val;
        this.Ag = Ag;
        this.Ad = Ad;
    }
    
    ArbreCons(String val) {
        this.racine = val;
        this.Ag = new ArbreVide();
        this.Ad = new ArbreVide();
    }
    
    ArbreCons(int n){
        if(n>0){
            this.racine = null;
            this.Ag = new ArbreCons(n-1);
            this.Ad = new ArbreCons(n-1);
        } else {
            this.racine = null;
            this.Ag = new ArbreVide();
            this.Ad = new ArbreVide();
        }
    }
    
    public String getRacine(){
        return this.racine;
    }
    
    public Arbre getAg(){
        return this.Ag;
    }
    
    public Arbre getAd(){
        return this.Ad;
    }
    
    public void setRacine(String s){
        this.racine = s;
    }
    
    public void setAg(Arbre Ag){
        this.Ag = Ag;
    }
    
    public void setAd(Arbre Ad){
        this.Ag = Ad;
    }
    
    public void afficheGRD(){
        this.getAg().afficheGRD();
        System.out.print(this.getRacine()+" ");
        this.getAd().afficheGRD();
    }
    
    public int nbFeuille(){
        if(this.estFeuille()){
            return 1;
        } else {
            return this.getAg().nbFeuille()+this.getAd().nbFeuille();
        }
    }
    
    public boolean estFeuille(){
        return this.getAg().estVide() && this.getAd().estVide();
    }
    
    public boolean trouver(String element){
        if(this.getRacine().equals(element)){
            return true;
        } else {
            return this.getAg().trouver(element) || this.getAd().trouver(element);
        }
    }
    
    public String lePlusAGauche(){
        if(this.getAg().estFeuille()){
            return this.getAg().getRacine();
        } else {
            return this.getAg().lePlusAGauche();
        }
    }
    
    public String lePlusADroite(){
        if(this.getAd().estFeuille()){
            return this.getAd().getRacine();
        } else {
            return this.getAd().lePlusADroite();
        }
    }
    
    public Arbre supprimer(String valeur){
        if(this.getRacine().equals(valeur)){
            //si la racine est égale à la valeur recherchée, supprime la valeur et la remplace par l'élément le plus à gauche
            if(this.getAg().estVide()){
                return this.getAd();
            }
            String valeur2 = this.lePlusAGauche();
            return new ArbreCons(valeur2,this.getAg().supprimer(valeur2),this.getAd().supprimer(valeur2));
        } else {
            //si racine n'est pas égale à la valeur recherchée
            return new ArbreCons(this.getRacine(),this.getAg().supprimer(valeur),this.getAd().supprimer(valeur));
        }
    }
    
    public int nbNoeuds() {
        int nfg = 0, nfd = 0;
        nfg = getAg().nbNoeuds();
        nfd = getAd().nbNoeuds();
        return (1 + nfg + nfd);
    }

    public int hauteur() {
        int nfg = 0, nfd = 0;
        nfg = 1 + getAg().hauteur();
        nfd = 1 + getAd().hauteur();
        return Math.max(nfg, nfd);
    }
    
    public boolean insereFeuille(String str){
        boolean test = false;
        if(!this.estFeuille()){
            return this.getAg().insereFeuille(str)||this.getAd().insereFeuille(str);
        } else if(this.getRacine()==null&&!test){
            this.setRacine(str);
            return true;
        } else {
            return false;
        }
    }
    
    public void placerGagnant(String str){
        if(this.getAg().getRacine()!=null && this.getRacine()!=null){
            
        }
    }
}